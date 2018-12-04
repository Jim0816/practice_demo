import cv2
import numpy as np
from matplotlib import pyplot as plt

def yuzhi():
    """图像阈值化"""
    img = cv2.imread('E:\cvImg\jsx.jpg',0)
    #第一个参数必须是灰度图，第二个参数为分类阈值
    #第三个参数为新像素值，第四个参数为阈值方案
    ret,thresh1 = cv2.threshold(img,127,255,cv2.THRESH_BINARY)
    ret,thresh2 = cv2.threshold(img,127,255,cv2.THRESH_BINARY_INV)
    ret,thresh3 = cv2.threshold(img,127,255,cv2.THRESH_TRUNC)
    ret,thresh4 = cv2.threshold(img,127,255,cv2.THRESH_TOZERO)
    ret,thresh5 = cv2.threshold(img,127,255,cv2.THRESH_TOZERO_INV)

    titles = ['original image','Binary','binary-inv','trunc','tozero','tozero-inv']
    images = [img,thresh1,thresh2,thresh3,thresh4,thresh5]

    for i in range(6):
        plt.subplot(2,3,i+1),plt.imshow(images[i],'gray')
        plt.title(titles[i])
        #取消坐标轴标尺
        plt.xticks([]),plt.yticks([])

    plt.show()
