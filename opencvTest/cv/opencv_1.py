import numpy as np
import cv2
"""读取图片"""
cv2.namedWindow('image',cv2.WINDOW_NORMAL)
img = cv2.imread('e:\jsx.jpg',1)
cv2.imshow('image',img)

k = cv2.waitKey(0)&0xFF
if k == 27:
    cv2.destroyAllWindows()
elif k == ord('s'):
    cv2.imwrite('e:\jsycopy.jpg',img)
    cv2.destroyAllWindows()
