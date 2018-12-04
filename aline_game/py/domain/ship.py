import pygame

class Ship():
    """飞船类"""
    def __init__(self,aline_settings,screen):
        """初始化飞船及其初始位置"""
        self.screen = screen
        self.aline_settings = aline_settings
        #加载飞船图像并获取其外接矩形
        self.image = pygame.image.load('images\ship.png')
        self.rect = self.image.get_rect()
        self.screen_rect = screen.get_rect()

        #将每一艘新飞船放置屏幕底部中央
        self.rect.centerx = self.screen_rect.centerx
        self.rect.bottom = self.screen_rect.bottom
        #在飞船属性center中添加小数值
        #下面直接操作飞船本身了，不需要操作外界矩形
        self.center = float(self.rect.centerx)
        #移动标志
        self.moving_right = False
        self.moving_left = False
    def update(self):
        """根据移动标志调整飞船位置"""
        if self.moving_right and self.rect.right < self.screen_rect.right:
            self.center +=self.aline_settings.ship_speed
        if self.moving_left and self.rect.left > 0:
            self.center -=self.aline_settings.ship_speed
        #根据飞船位置更新其外接矩形位置
        self.rect.centerx = self.center
    def blitme(self):
        """在指定位置绘制飞船"""
        self.screen.blit(self.image,self.rect)