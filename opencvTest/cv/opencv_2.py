import cv2
import numpy as np
from matplotlib import pyplot as plt
def show_video():
    """打开摄像头显示"""
    cap = cv2.VideoCapture(0)
    while(1):
        # get a frame
        #cap.read()返回两个参数赋给两个值。第一个参数ret的值为True或False，
        # 代表有没有读到图片。第二个参数是frame，是当前截取一帧的图片
        ret,frame = cap.read()
        #处理视频帧的颜色
        gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
        #第二个参数如果为frame表示原帧，颜色不变
        cv2.imshow("capture",gray)
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break
    cap.release()
    cv2.destroyAllWindows()

def play_video_file():
    cap = cv2.VideoCapture('e:\校园智能平台.mp4')
    while (cap.isOpened()):
        ret, frame = cap.read()
        #gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
        cv2.imshow('image', frame)
        if cv2.waitKey(1) & 0xFF == ord('q'):
            break
    cap.release()
    cv2.destroyAllWindows()

def save_video():
    """打开摄像头录制视频保存到本地"""
    cap = cv2.VideoCapture(0)
    fourcc = cv2.VideoWriter_fourcc(*'DIVX')
    out = cv2.VideoWriter('e:\output.avi', fourcc, 20.0, (640, 480))
    while(cap.isOpened()):
        # 代表有没有读到图片。第二个参数是frame，是当前截取一帧的图片
        ret,frame = cap.read()
        if ret == True:
            #图像翻转
            #frame = cv2.flip(frame,0)
            out.write(frame)
            #处理视频帧的颜色
            #gray = cv2.cvtColor(frame, cv2.COLOR_BGR2GRAY)
            #第二个参数如果为frame表示原帧，颜色不变
            cv2.imshow("frame",frame)
            if cv2.waitKey(1) & 0xFF == ord('q'):
                break
        else:
            break
    cap.release()
    out.release()
    cv2.destroyAllWindows()

def paint_line():
    """画线"""
    img = np.zeros((512, 512, 3), np.uint8)

    # draw a diagonal blue line with thickness of 5 px
    cv2.line(img, (0, 0), (260, 260), (255, 0, 0), 5)

    # 为了演示，建窗口显示出来
    cv2.namedWindow('image', cv2.WINDOW_NORMAL)
    cv2.resizeWindow('image', 500, 500)  # 定义frame的大小
    cv2.imshow('image', img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

def paint_circle():
    """画圆"""
    img = np.zeros((500, 500, 3), np.uint8)
    cv2.circle(img,(200,200),100,(0,0,255),0)
    cv2.imshow('circle', img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

def paint_word():
    """设置输入写字"""
    img = np.zeros((500, 500, 3), np.uint8)
    font = cv2.FONT_HERSHEY_COMPLEX
    cv2.putText(img,'Hello OpenCv',(10,150),font,2,(255,255,0),2)
    cv2.imshow('write text', img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

def nothing(x):
    pass
def trackbar():
    """测试滑动条"""
    # 创建一副黑色图像
    img=np.zeros((500,512,3),np.uint8)
    cv2.namedWindow('image')
    #创建滑动条
    cv2.createTrackbar('R','image',0,255,nothing)
    cv2.createTrackbar('G','image',0,255,nothing)
    cv2.createTrackbar('B','image',0,255,nothing)
    switch='0:OFF\n1:ON'
    cv2.createTrackbar(switch,'image',0,1,nothing)

    while(1):
        cv2.imshow('image',img)
        k=cv2.waitKey(1) & 0xFF
        if k == ord('q'):
            break
        #获取滑动条对象
        r = cv2.getTrackbarPos('R', 'image')
        g = cv2.getTrackbarPos('G', 'image')
        b = cv2.getTrackbarPos('B', 'image')
        s = cv2.getTrackbarPos(switch, 'image')

        if s == 0:
            img[:] = 0
        else:
            img[:] = [b, g, r]

    cv2.destroyAllWindows()

def shift_phonto():
    """移动图片内部某指定位置"""
    cv2.namedWindow('photo',0)
    cv2.resizeWindow('photo',500,400)
    cv2.moveWindow('photo',400,300)
    img = cv2.imread('e:\jsx.jpg')
    shift = img[280:340,330:390]
    img[273:333,100:160] = shift
    cv2.imshow('photo', img)
    cv2.waitKey(0)
    cv2.destroyAllWindows()

def paint_border():
    """给图片扩充边界"""
    img = cv2.imread('e:\jsx.jpg')
    color = [255, 0, 0]
    replicate = cv2.copyMakeBorder(img, 10, 10, 10, 10, cv2.BORDER_REPLICATE)
    reflect = cv2.copyMakeBorder(img, 10, 10, 10, 10, cv2.BORDER_REFLECT)
    reflect101 = cv2.copyMakeBorder(img, 10, 10, 10, 10, cv2.BORDER_REFLECT101)
    wrap = cv2.copyMakeBorder(img, 10, 10, 10, 10, cv2.BORDER_WRAP)
    constant = cv2.copyMakeBorder(img, 10, 10, 10, 10, cv2.BORDER_CONSTANT, value=color)
    #plt.subplot()的参数表示，如231-236表示把一张图片复制6份，按照2行3列摆放，最后一个数字表示先后顺序
    plt.subplot(231), plt.imshow(img, 'gray'), plt.title('original')
    plt.subplot(232), plt.imshow(replicate, 'gray'), plt.title('replicate')
    plt.subplot(233), plt.imshow(reflect, 'gray'), plt.title('reflect')
    plt.subplot(234), plt.imshow(reflect101, 'gray'), plt.title('reflect101')
    plt.subplot(235), plt.imshow(wrap, 'gray'), plt.title('wrap')
    plt.subplot(236), plt.imshow(constant, 'gray'), plt.title('constant')
    plt.show()

def transform_color():
    cap = cv2.VideoCapture(0)
    while (1):
        # 获取每一帧
        ret, frame = cap.read()
        # 转换到HSV
        hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)
        # 设定蓝色的阀值
        lower_blue = np.array([110, 50, 50])
        upper_blue = np.array([130, 255, 255])
        # 根据阀值构建掩模
        mask = cv2.inRange(hsv, lower_blue, upper_blue)
        # 对原图和掩模进行位运算
        res = cv2.bitwise_and(frame, frame, mask=mask)
        # 显示图像
        cv2.imshow('frame', frame)
        cv2.imshow('mask', mask)
        cv2.imshow('res', res)
        k = cv2.waitKey(5) & 0xFF
        if k == 27:
            break
    # 关闭窗口
    cv2.destroyAllWindows()

def search_color():
    Img = cv2.imread('e:\color.png')  # 读入一幅图像
    kernel_2 = np.ones((2, 2), np.uint8)  # 2x2的卷积核
    kernel_3 = np.ones((3, 3), np.uint8)  # 3x3的卷积核
    kernel_4 = np.ones((4, 4), np.uint8)  # 4x4的卷积核
    if Img is not None:  # 判断图片是否读入
        HSV = cv2.cvtColor(Img, cv2.COLOR_BGR2HSV)  # 把BGR图像转换为HSV格式
        '''
        HSV模型中颜色的参数分别是：色调（H），饱和度（S），明度（V）
        下面两个值是要识别的颜色范围
        '''
        Lower = np.array([20, 20, 20])  # 要识别颜色的下限
        Upper = np.array([30, 255, 255])  # 要识别的颜色的上限
        # mask是把HSV图片中在颜色范围内的区域变成白色，其他区域变成黑色
        mask = cv2.inRange(HSV, Lower, Upper) #黑白图
        # 下面四行是用卷积进行滤波
        erosion = cv2.erode(mask, kernel_4, iterations=1)
        erosion = cv2.erode(erosion, kernel_4, iterations=1)
        dilation = cv2.dilate(erosion, kernel_4, iterations=1)
        dilation = cv2.dilate(dilation, kernel_4, iterations=1)#滤波后的黑白图
        # target是把原图中的非目标颜色区域去掉剩下的图像
        target = cv2.bitwise_and(Img, Img, mask=dilation)#最终提取出来的图像结果
        # 将滤波后的图像变成二值图像放在binary中
        ret, binary = cv2.threshold(dilation, 127, 255, cv2.THRESH_BINARY)
        # 在binary中发现轮廓，轮廓按照面积从小到大排列
        im1,contours, hierarchy = cv2.findContours(binary, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
        p = 0
        # 遍历所有的轮廓
        for i in contours:
            x, y, w, h = cv2.boundingRect(i)  # 将轮廓分解为识别对象的左上角坐标和宽、高
            # 在图像上画上矩形（图片、左上角坐标、右下角坐标、颜色、线条宽度）
            cv2.rectangle(Img, (x, y), (x + w, y + h), (0, 255,), 3)
            # 给识别对象写上标号
            font = cv2.FONT_HERSHEY_SIMPLEX
            cv2.putText(Img, str(p), (x - 10, y + 10), font, 1, (0, 0, 255), 2)  # 加减10是调整字符位置
            p += 1

        print('黄色方块的数量是', p, '个')  # 终端输出目标数量
        cv2.imwrite('e:\Img.png', Img)  # 将画上矩形的图形保存到当前目录
    while True:
        Key = chr(cv2.waitKey(15) & 255)
        if Key == 'q':
            cv2.destroyAllWindows()
            break

def find_range():
    """用于测试HSV颜色阀值"""
    '''通过区分米粒的颜色来划分区域'''
    '''
    cv2.namedWindow('mask', 0)
    cv2.resizeWindow('mask', 400, 400)
    cv2.moveWindow('mask', 500, 100)
    '''
    cv2.namedWindow('Test', 0)
    cv2.resizeWindow('Test', 400, 400)
    cv2.moveWindow('Test', 50, 100)

    Img = cv2.imread('E:\\cvImg\\mi\\8.JPG')  # 读入一幅图像
    kernel_4 = np.ones((4, 4), np.uint8)  # 4x4的卷积核
    if Img is not None:  # 判断图片是否读入
        HSV = cv2.cvtColor(Img, cv2.COLOR_BGR2HSV)  # 把BGR图像转换为HSV格式
        Lower = np.array([0, 0, 150])  # 要识别颜色的下限
        Upper = np.array([190, 80, 255])  # 要识别的颜色的上限
        # mask是把HSV图片中在颜色范围内的区域变成白色，其他区域变成黑色
        mask = cv2.inRange(HSV, Lower, Upper)  # 黑白图
        blur = cv2.bilateralFilter(mask, 9, 75, 75)  # 双边滤波
        # 将滤波后的图像变成二值图像放在binary中
        ret, binary = cv2.threshold(mask, 127, 255, cv2.THRESH_BINARY)
        # 在binary中发现轮廓，轮廓按照面积从小到大排列
        im1, contours, hierarchy = cv2.findContours(binary, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
        nums = 0
        # 遍历所有的轮廓
        for i in contours:
            x, y, w, h = cv2.boundingRect(i)  # 将轮廓分解为识别对象的左上角坐标和宽、高
            # 在图像上画上矩形（图片、左上角坐标、右下角坐标、颜色、线条宽度）
            cv2.rectangle(Img, (x, y), (x + w, y + h),(0,0,0), 8)
            # 给识别对象写上标号
            font = cv2.FONT_HERSHEY_SIMPLEX
            #cv2.putText(Img, str(nums), (x - 10, y + 10), font, 1, (0, 0, 255), 2)  # 加减10是调整字符位置
            nums += 1
        print('共有'+str(nums)+'粒米')
        cv2.imshow('Test', Img)
        while True:
            if cv2.waitKey(1) == 27:
                cv2.destroyAllWindows()
                break

def img_rotate():
    '''旋转图片'''
    img = cv2.imread('E:\cvImg\jsx.jpg',1)
    rows, cols = img.shape[:2]
    # 这里的第一个参数为旋转中心，第二个为旋转角度，第三个为旋转后的缩放因子
    # 可以通过设置旋转中心，缩放因子以及窗口大小来防止旋转后超出边界的问题。
    M = cv2.getRotationMatrix2D((cols / 2, rows / 2), 45, 0.6)
    # 第三个参数是输出图像的尺寸中心
    dst = cv2.warpAffine(img, M, (2 * cols, 2 * rows))
    while (1):
        cv2.imshow('img', dst)
        if cv2.waitKey(1) == 27:
            break
    cv2.destroyAllWindows()

def two_juanji():
    img = cv2.imread('E:\\cvImg\\banli\\4.jpg')
    kernel = np.ones((5, 5), np.float32) / 25
    dst = cv2.filter2D(img, -1, kernel)#2D卷积
    blur1 = cv2.blur(img, (5, 5))#平均
    blur2 = cv2.GaussianBlur(img, (5, 5), 0)#高斯模糊
    median = cv2.medianBlur(img, 5)#中值模糊
    blur3 = cv2.bilateralFilter(img, 9, 75, 75)#双边滤波

    plt.subplot(231), plt.imshow(img), plt.title('original')
    plt.xticks([]), plt.yticks([])
    plt.subplot(232), plt.imshow(dst), plt.title('2Djuanji')
    plt.xticks([]), plt.yticks([])
    plt.subplot(233), plt.imshow(blur1), plt.title('averaging')
    plt.xticks([]), plt.yticks([])
    plt.subplot(234), plt.imshow(blur2), plt.title('gaosi')
    plt.xticks([]), plt.yticks([])
    plt.subplot(235), plt.imshow(median), plt.title('zhongzhi')
    plt.xticks([]), plt.yticks([])
    plt.subplot(236), plt.imshow(blur3), plt.title('shuangbian')
    plt.xticks([]), plt.yticks([])
    plt.show()

def check_nums():
    cv2.namedWindow('Test', 0)
    cv2.resizeWindow('Test', 400, 400)
    cv2.moveWindow('Test', 50, 100)
    img = cv2.imread('E:\\cvImg\\banli\\3.JPG',0)  # 读入一幅图像
    # blur = cv2.bilateralFilter(img, 9, 75, 75)


    ret, binary = cv2.threshold(img, 127, 255, cv2.THRESH_BINARY)
    blur = cv2.GaussianBlur(binary, (5, 5), 0)
    im1, contours, hierarchy = cv2.findContours(blur, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
    # 遍历所有的轮廓
    for i in contours:
        cv2.drawContours(blur,contours,-1,(0,255,0),2)

    cv2.imshow('Test', blur)

    while True:
        if cv2.waitKey(1) == 27:
            cv2.destroyAllWindows()
            break



def check_aim():
    cv2.namedWindow('Test', 0)
    cv2.resizeWindow('Test', 400, 400)
    cv2.moveWindow('Test', 50, 100)

    img = cv2.imread("E:\\cvImg\\other\\banli\\6.jpg",1)
    gray = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    gauss = cv2.GaussianBlur(gray,(7,7),0)
    ret, binary = cv2.threshold(gauss, 127, 255, cv2.THRESH_BINARY)
    #形态学处理
    NpKernel = np.uint8(np.ones((5, 5)))
    Nperoded = cv2.erode(binary, NpKernel)
    #边缘处理
    im1, contours, hierarchy = cv2.findContours(Nperoded, cv2.RETR_TREE, cv2.CHAIN_APPROX_SIMPLE)
    canvas = img.copy()
    #计数
    nums = []
    for count in contours:
        print(count)
        area = cv2.contourArea(count)
        x,y,w,h = cv2.boundingRect(count)
        if area < 7 or area/(w*h) < 0.3:
            continue
        nums.append(count)
    print(len(nums))
    cv2.drawContours(canvas,nums,-1,(0,0,255),2)
    cv2.imshow('Test', canvas)
    cv2.waitKey(0)
    cv2.destroyAllWindows()


def rgb_test():
    cv2.namedWindow('Test', 0)
    cv2.resizeWindow('Test', 400, 400)
    cv2.moveWindow('Test', 50, 100)
    img = cv2.imread("E:\\cvImg\\other\\banli\\6.jpg", 1)
    hsv = cv2.cvtColor(img, cv2.COLOR_BGR2HSV)  # 把BGR图像转换为HSV格式

    lower_blue = np.array([0,0,100])
    upper_blue = np.array([174,168,209])
    # 根据阀值构建掩模
    mask = cv2.inRange(hsv, lower_blue, upper_blue)
    cv2.imshow('Test', mask)
    cv2.waitKey(0)
    cv2.destroyAllWindows()


def bgr_to_hsv():
    """bgr转hsv"""
    # 这里的三层括号应该分别对应于 cvArray ， cvMat ， IplImage
    #b、g、r 顺序
    green = np.uint8([[[72, 53, 156]]])
    hsv_green = cv2.cvtColor(green, cv2.COLOR_BGR2HSV)
    print (hsv_green)

check_aim()