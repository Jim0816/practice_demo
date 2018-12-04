/**
 * @author 李际明
 * @功能：游戏操控面板
 */
package package1;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
import javax.swing.JPanel;
import java.awt.*;
import sun.awt.*;
//我的坦克游戏面板
class MyPanel extends JPanel implements KeyListener,Runnable{
	//定义一个我的坦克
	Hero hero = null;
	//定义敌人坦克  
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	int enSize = 20;
	//定义一个炸弹集合
	Vector<Bomb> bombs = new Vector<Bomb>();
	//构造函数
	public MyPanel() {
		hero = new Hero(280,420);
		//初始化敌人坦克
		for(int i=0;i<enSize;i++) {
			//创建敌人坦克对象，加入Vector
			EnemyTank et = new EnemyTank((i+1)*20,0);
			et.setColor(0);
			et.setDirect(1);
			//将MyPanel的敌人坦克向量交给该敌人坦克
			et.setEts(ets);
			//启动敌军坦克
			Thread t = new Thread(et);
			t.start();
			//给敌人坦克添加一颗子弹
			Shot s = new Shot(et.x+10,et.y+30,1,et.color);
			et.ss.add(s);
			Thread t2 = new Thread(s);
			t2.start();
			//加入Vector
			ets.add(et);
		}
		}
	//初始化三张爆炸图片
	Image big = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
	Image middle = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
	Image small = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 600, 520);
		//画出自己的坦克
		if(hero.isLive) {
			this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 3);
		}else {
            //存在英雄坦克死亡后一直爆炸的问题，需要改进
		}
		//从ss中取出每颗子弹画出
		for(int i=0;i<this.hero.ss.size();i++) {
			Shot myShot = hero.ss.get(i);
			//画出子弹
			if(myShot!=null&&myShot.isLive==true) {
				g.draw3DRect(myShot.x,myShot.y, 1, 1, false);
			}
			//删除已经死亡的子弹
			if(myShot.isLive == false) {
				hero.ss.remove(myShot);
			}
		}
		//画出炸弹(注意：在画炸弹时，图片加载速度会收电脑CPU的影响，需根据电脑状况配置时间)
		for(int i=0;i<bombs.size();i++) {
			//取出炸弹
			Bomb b = bombs.get(i);
			if(b.life>13) {
				g.drawImage(big, b.x, b.y, 30, 30, this);
			}else if(b.life>5) {
				g.drawImage(middle, b.x, b.y, 30, 30, this);
			}else {
				g.drawImage(small, b.x, b.y, 30, 30, this);
			}
			//让b的生命值减小
			b.lifeDown();
			if(b.life ==0) {
				bombs.remove(b);
			}
		}
		//画出敌人坦克
		for(int i=0;i<ets.size();i++) {
			EnemyTank et = ets.get(i);
			if(et.isLive) {
				this.drawTank(et.getX(), et.getY(), g, et.getDirect(), 1);
				//画出敌军子弹
				for(int j=0;j<et.ss.size();j++) {
					Shot enemyShot = et.ss.get(j);
					if(enemyShot.isLive) {
						g.draw3DRect(enemyShot.x,enemyShot.y, 1, 1, false); 
					}else {
						//如果敌军坦克死亡，则从Vector中删去
						et.ss.remove(enemyShot);
					}
				}
			}	
		}
	}
	//画出坦克的函数
	public void drawTank(int x,int y,Graphics g,int direct,int type) {
		//判断坦克颜色类型
		switch(type) {
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		case 2:
			g.setColor(Color.BLUE);
			break;
		case 3:
			g.setColor(Color.RED);
			break;
		}
		//判断坦克方向
		switch(direct) {
		//向上
		case 0:
			//左边矩形
			g.fill3DRect(x, y, 5, 30,false);
			//右边矩形
			g.fill3DRect(x+15, y, 5, 30,false);
			//中间矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//圆形
			g.fillOval(x+5, y+10, 10, 10);
			//画线
			g.drawLine(x+10, y, x+10,y+15 );
			break;
		//向下	
		case 1:
			//左边矩形
			g.fill3DRect(x, y, 5, 30,false);
			//右边矩形
			g.fill3DRect(x+15, y, 5, 30,false);
			//中间矩形
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//圆形
			g.fillOval(x+5, y+10, 10, 10);
			//画线
			g.drawLine(x+10, y+15, x+10,y+30);
			break;
		//向左
		case 2:
			//上面矩形
			g.fill3DRect(x, y, 30, 5,false);
			//下面矩形
			g.fill3DRect(x, y+15, 30, 5,false);
			//中间矩形
			g.fill3DRect(x+5, y+5, 20, 10,false);
			//圆形
			g.fillOval(x+10, y+5, 10, 10);
			//画线
			g.drawLine(x, y+10, x+15,y+10 );
		    break;
		//向右
		case 3:
			//上面矩形
			g.fill3DRect(x, y, 30, 5,false);
			//下面矩形
			g.fill3DRect(x, y+15, 30, 5,false);
			//中间矩形
			g.fill3DRect(x+5, y+5, 20, 10,false);
			//圆形
			g.fillOval(x+10, y+5, 10, 10);
			//画线
			g.drawLine(x+15, y+10, x+30,y+10 );
		    break;
		}
	}
	//判断我的子弹是否击中敌人坦克
	public void hitEnemyTank() {
		//判断是否击中
		for(int i=0;i<hero.ss.size();i++) {
			//取出子弹
			Shot myShot = hero.ss.get(i);
			//判断子弹是否有效
			if(myShot!=null&&myShot.isLive==true) {
				//取出每一辆敌军坦克，判断二者是否相遇
				for(int j=0;j<ets.size();j++) {
					//取出坦克
					EnemyTank et = ets.get(j);
					if(et.isLive) {
						this.hitTank(myShot, et);
					}
				}
			}
		}
	}
	//判断敌军子弹是否击中英雄坦克
	public void hitHero() {
		//取出每辆敌军坦克
		for(int i=0;i<this.ets.size();i++) {
			//取出坦克
			EnemyTank et = ets.get(i);
			//取出每颗子弹
			for(int j=0;j<et.ss.size();j++) {
				Shot enemyShot = et.ss.get(j);
				this.hitTank(enemyShot, hero);
			}
		}
	}
	//写一个判断坦克是否被击中的函数
	public void hitTank(Shot s,Tank et) {
		//判断该坦克的方向
		switch(et.direct) {
		//敌军坦克方向为上和下时
		case 0:
		case 1:
			if(s.x>=et.x && s.x<=et.x+20 && s.y>=et.y && s.y<=et.y+30) {
				//子弹和被击中坦克死亡
				s.isLive = false;
				et.isLive = false;
				//创建一颗炸弹,放入Vector
				Bomb b = new Bomb(et.x,et.y);
				bombs.add(b);
				
			}
		//敌军坦克方向为左和右时
		case 2:
		case 3:
            if(s.x>=et.x && s.x<=et.x+30 && s.y>=et.y && s.y<=et.y+20) {
            	//子弹和被击中坦克死亡
            	s.isLive = false;
				et.isLive = false;
				//创建一颗炸弹,放入Vector
				Bomb b = new Bomb(et.x,et.y);
				bombs.add(b);	
			}
		}
	}
	//事件处理
	//按键盘
	public void keyPressed(KeyEvent e) {
		//向上
      if(e.getKeyCode() == KeyEvent.VK_UP||e.getKeyCode() == KeyEvent.VK_W) {
			//设置我的坦克方向
      	this.hero.setDirect(0);
      	this.hero.moveUp();
		}
		//向下
      else if(e.getKeyCode() == KeyEvent.VK_DOWN||e.getKeyCode() == KeyEvent.VK_S) {
			this.hero.setDirect(1);
      	this.hero.moveDowm();
		}
      //向左
      else if(e.getKeyCode() == KeyEvent.VK_LEFT||e.getKeyCode() == KeyEvent.VK_A) {
      	this.hero.setDirect(2);
      	this.hero.moveLeft();
		}
      //向右
      else if(e.getKeyCode() == KeyEvent.VK_RIGHT||e.getKeyCode() == KeyEvent.VK_D) {
         	this.hero.setDirect(3);
      	this.hero.moveRight();
		}
      //发射子弹按键
      if(e.getKeyCode() == KeyEvent.VK_SPACE) {
    	  if(this.hero.ss.size()<=9) {
    		  this.hero.ShotEnemy();  
    	  }
      	
      }
	}
	//松键盘
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	//键盘的一个值被输出
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.hitEnemyTank();
			this.hitHero();
			//重绘
			this.repaint();
		}
	}
}
