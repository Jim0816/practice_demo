import pygame
from pygame.sprite import Group
from settings import Settings
from domain.ship import Ship
from domain.bullet import Bullet
import game_functions as gf

def run_game():
    #初始化游戏并且创建一个窗口对象
    pygame.init()
    aline_settings = Settings()
    screen = pygame.display.set_mode((aline_settings.screen_width,aline_settings.screen_hight))
    pygame.display.set_caption(aline_settings.screen_name)
    #创建一艘飞船
    ship = Ship(aline_settings,screen)
    bullets = Group()
    #开始游戏的主循环
    while True:
        #监视键盘的鼠标事件
        gf.check_events(aline_settings,screen,ship,bullets)
        ship.update()
        bullets.update()
        #更新屏幕
        gf.update_screen(aline_settings,screen,ship,bullets)


run_game()