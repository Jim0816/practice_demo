import cv2
import numpy as np
from matplotlib import pyplot as plt

def rgb_test(img,lower_hsv,upper_hsv):
    """通过颜色HSV阈值选定区域"""
    hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)  # 把BGR图像转换为HSV格式

    # 根据阀值构建掩模
    mask = cv2.inRange(hsv, lower_hsv, upper_hsv)
    return mask

def boundry():
    """帅选边界"""
    cv2.namedWindow('Counter', 0)
    cv2.resizeWindow('Counter', 400, 400)
    cv2.moveWindow('Counter', 50, 100)
    img = cv2.imread("E:\\cvImg\\other\\banli\\1.jpg", 1)
    # 定义hsv阈值区间
    lower_hsv = np.array([0, 0, 100])
    upper_hsv = np.array([174, 168, 219])
    mask = rgb_test(img,lower_hsv,upper_hsv)
    #gauss = cv2.GaussianBlur(mask, (3, 3), 0)
    ret, binary = cv2.threshold(mask, 127, 255, cv2.THRESH_BINARY)
    # 形态学处理

    #erosion = cv2.erode(binary, kernel, iterations=1)
    kernel = np.ones((3, 3), np.uint8)
    dilation = cv2.dilate(binary, kernel, iterations=1)
    #NpKernel = np.uint8(np.ones((10, 10)))
    #Nperoded = cv2.erode(binary, NpKernel)
    # gauss = cv2.GaussianBlur(binary, (7, 7), 0)
    # kernel = np.ones((3, 3), np.uint8)
    #erosion = cv2.erode(gauss, kernel, iterations=5)
    # 边缘处理
    im1, contours, hierarchy = cv2.findContours(dilation, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
    canvas = img.copy()
    # 计数
    nums = []
    for count in contours:
        if len(count) < 300:
            continue
        #area = cv2.contourArea(count)
        # x, y, w, h = cv2.boundingRect(count)
        # if area < 7 or area / (w * h) < 0.3:
        #
        nums.append(count)
    cv2.drawContours(canvas, nums, -1, (0, 0, 255), 2)
    print(len(nums))
    cv2.imshow('Counter', canvas)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

boundry()