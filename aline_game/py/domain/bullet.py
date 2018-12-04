import pygame
from pygame.sprite import Sprite

class Bullet(Sprite):
    """对飞船发射子弹的管理"""

    def __init__(self,aline_seetings,screen,ship):
        super().__init__()
        self.screen = screen

        #在(0,0)处创建一个表示子弹的矩形，再设置其位置
        self.rect = pygame.Rect(0,0,aline_seetings.bullet_width,aline_seetings.bullet_height)
        self.rect.centerx = ship.rect.centerx
        self.rect.top = ship.rect.top
        #存储小数表示子弹位置
        self.y = float(self.rect.y)

        self.color = aline_seetings.bullet_color
        self.speed = aline_seetings.bullet_speed

    def update(self):
        """向上移动子弹"""
        self.y -= self.speed
        self.rect.y = self.y

    def draw_bullet(self):
        """再屏幕上绘制子弹"""
        pygame.draw.rect(self.screen,self.color,self.rect)