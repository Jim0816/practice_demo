class Settings():
    """存储游戏的所有设置"""

    def __init__(self):
        """初始化游戏的设置"""
        self.screen_name="雷霆战机"
        self.screen_width = 1000
        self.screen_hight = 600
        self.bg_color = (230,230,230)
        #飞船的设置
        self.ship_speed = 1
        #子弹的设置
        self.bullet_speed = 1
        self.bullet_width = 3
        self.bullet_height = 15
        self.bullet_color = (60,60,60)
