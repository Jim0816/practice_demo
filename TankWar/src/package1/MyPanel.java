/**
 * @author �����
 * @���ܣ���Ϸ�ٿ����
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
//�ҵ�̹����Ϸ���
class MyPanel extends JPanel implements KeyListener,Runnable{
	//����һ���ҵ�̹��
	Hero hero = null;
	//�������̹��  
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	int enSize = 20;
	//����һ��ը������
	Vector<Bomb> bombs = new Vector<Bomb>();
	//���캯��
	public MyPanel() {
		hero = new Hero(280,420);
		//��ʼ������̹��
		for(int i=0;i<enSize;i++) {
			//��������̹�˶��󣬼���Vector
			EnemyTank et = new EnemyTank((i+1)*20,0);
			et.setColor(0);
			et.setDirect(1);
			//��MyPanel�ĵ���̹�����������õ���̹��
			et.setEts(ets);
			//�����о�̹��
			Thread t = new Thread(et);
			t.start();
			//������̹�����һ���ӵ�
			Shot s = new Shot(et.x+10,et.y+30,1,et.color);
			et.ss.add(s);
			Thread t2 = new Thread(s);
			t2.start();
			//����Vector
			ets.add(et);
		}
		}
	//��ʼ�����ű�ըͼƬ
	Image big = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_1.gif"));
	Image middle = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_2.gif"));
	Image small = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bomb_3.gif"));
	public void paint(Graphics g) {
		super.paint(g);
		g.fillRect(0, 0, 600, 520);
		//�����Լ���̹��
		if(hero.isLive) {
			this.drawTank(hero.getX(), hero.getY(), g, this.hero.direct, 3);
		}else {
            //����Ӣ��̹��������һֱ��ը�����⣬��Ҫ�Ľ�
		}
		//��ss��ȡ��ÿ���ӵ�����
		for(int i=0;i<this.hero.ss.size();i++) {
			Shot myShot = hero.ss.get(i);
			//�����ӵ�
			if(myShot!=null&&myShot.isLive==true) {
				g.draw3DRect(myShot.x,myShot.y, 1, 1, false);
			}
			//ɾ���Ѿ��������ӵ�
			if(myShot.isLive == false) {
				hero.ss.remove(myShot);
			}
		}
		//����ը��(ע�⣺�ڻ�ը��ʱ��ͼƬ�����ٶȻ��յ���CPU��Ӱ�죬����ݵ���״������ʱ��)
		for(int i=0;i<bombs.size();i++) {
			//ȡ��ը��
			Bomb b = bombs.get(i);
			if(b.life>13) {
				g.drawImage(big, b.x, b.y, 30, 30, this);
			}else if(b.life>5) {
				g.drawImage(middle, b.x, b.y, 30, 30, this);
			}else {
				g.drawImage(small, b.x, b.y, 30, 30, this);
			}
			//��b������ֵ��С
			b.lifeDown();
			if(b.life ==0) {
				bombs.remove(b);
			}
		}
		//��������̹��
		for(int i=0;i<ets.size();i++) {
			EnemyTank et = ets.get(i);
			if(et.isLive) {
				this.drawTank(et.getX(), et.getY(), g, et.getDirect(), 1);
				//�����о��ӵ�
				for(int j=0;j<et.ss.size();j++) {
					Shot enemyShot = et.ss.get(j);
					if(enemyShot.isLive) {
						g.draw3DRect(enemyShot.x,enemyShot.y, 1, 1, false); 
					}else {
						//����о�̹�����������Vector��ɾȥ
						et.ss.remove(enemyShot);
					}
				}
			}	
		}
	}
	//����̹�˵ĺ���
	public void drawTank(int x,int y,Graphics g,int direct,int type) {
		//�ж�̹����ɫ����
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
		//�ж�̹�˷���
		switch(direct) {
		//����
		case 0:
			//��߾���
			g.fill3DRect(x, y, 5, 30,false);
			//�ұ߾���
			g.fill3DRect(x+15, y, 5, 30,false);
			//�м����
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//Բ��
			g.fillOval(x+5, y+10, 10, 10);
			//����
			g.drawLine(x+10, y, x+10,y+15 );
			break;
		//����	
		case 1:
			//��߾���
			g.fill3DRect(x, y, 5, 30,false);
			//�ұ߾���
			g.fill3DRect(x+15, y, 5, 30,false);
			//�м����
			g.fill3DRect(x+5, y+5, 10, 20,false);
			//Բ��
			g.fillOval(x+5, y+10, 10, 10);
			//����
			g.drawLine(x+10, y+15, x+10,y+30);
			break;
		//����
		case 2:
			//�������
			g.fill3DRect(x, y, 30, 5,false);
			//�������
			g.fill3DRect(x, y+15, 30, 5,false);
			//�м����
			g.fill3DRect(x+5, y+5, 20, 10,false);
			//Բ��
			g.fillOval(x+10, y+5, 10, 10);
			//����
			g.drawLine(x, y+10, x+15,y+10 );
		    break;
		//����
		case 3:
			//�������
			g.fill3DRect(x, y, 30, 5,false);
			//�������
			g.fill3DRect(x, y+15, 30, 5,false);
			//�м����
			g.fill3DRect(x+5, y+5, 20, 10,false);
			//Բ��
			g.fillOval(x+10, y+5, 10, 10);
			//����
			g.drawLine(x+15, y+10, x+30,y+10 );
		    break;
		}
	}
	//�ж��ҵ��ӵ��Ƿ���е���̹��
	public void hitEnemyTank() {
		//�ж��Ƿ����
		for(int i=0;i<hero.ss.size();i++) {
			//ȡ���ӵ�
			Shot myShot = hero.ss.get(i);
			//�ж��ӵ��Ƿ���Ч
			if(myShot!=null&&myShot.isLive==true) {
				//ȡ��ÿһ���о�̹�ˣ��ж϶����Ƿ�����
				for(int j=0;j<ets.size();j++) {
					//ȡ��̹��
					EnemyTank et = ets.get(j);
					if(et.isLive) {
						this.hitTank(myShot, et);
					}
				}
			}
		}
	}
	//�жϵо��ӵ��Ƿ����Ӣ��̹��
	public void hitHero() {
		//ȡ��ÿ���о�̹��
		for(int i=0;i<this.ets.size();i++) {
			//ȡ��̹��
			EnemyTank et = ets.get(i);
			//ȡ��ÿ���ӵ�
			for(int j=0;j<et.ss.size();j++) {
				Shot enemyShot = et.ss.get(j);
				this.hitTank(enemyShot, hero);
			}
		}
	}
	//дһ���ж�̹���Ƿ񱻻��еĺ���
	public void hitTank(Shot s,Tank et) {
		//�жϸ�̹�˵ķ���
		switch(et.direct) {
		//�о�̹�˷���Ϊ�Ϻ���ʱ
		case 0:
		case 1:
			if(s.x>=et.x && s.x<=et.x+20 && s.y>=et.y && s.y<=et.y+30) {
				//�ӵ��ͱ�����̹������
				s.isLive = false;
				et.isLive = false;
				//����һ��ը��,����Vector
				Bomb b = new Bomb(et.x,et.y);
				bombs.add(b);
				
			}
		//�о�̹�˷���Ϊ�����ʱ
		case 2:
		case 3:
            if(s.x>=et.x && s.x<=et.x+30 && s.y>=et.y && s.y<=et.y+20) {
            	//�ӵ��ͱ�����̹������
            	s.isLive = false;
				et.isLive = false;
				//����һ��ը��,����Vector
				Bomb b = new Bomb(et.x,et.y);
				bombs.add(b);	
			}
		}
	}
	//�¼�����
	//������
	public void keyPressed(KeyEvent e) {
		//����
      if(e.getKeyCode() == KeyEvent.VK_UP||e.getKeyCode() == KeyEvent.VK_W) {
			//�����ҵ�̹�˷���
      	this.hero.setDirect(0);
      	this.hero.moveUp();
		}
		//����
      else if(e.getKeyCode() == KeyEvent.VK_DOWN||e.getKeyCode() == KeyEvent.VK_S) {
			this.hero.setDirect(1);
      	this.hero.moveDowm();
		}
      //����
      else if(e.getKeyCode() == KeyEvent.VK_LEFT||e.getKeyCode() == KeyEvent.VK_A) {
      	this.hero.setDirect(2);
      	this.hero.moveLeft();
		}
      //����
      else if(e.getKeyCode() == KeyEvent.VK_RIGHT||e.getKeyCode() == KeyEvent.VK_D) {
         	this.hero.setDirect(3);
      	this.hero.moveRight();
		}
      //�����ӵ�����
      if(e.getKeyCode() == KeyEvent.VK_SPACE) {
    	  if(this.hero.ss.size()<=9) {
    		  this.hero.ShotEnemy();  
    	  }
      	
      }
	}
	//�ɼ���
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	//���̵�һ��ֵ�����
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
			//�ػ�
			this.repaint();
		}
	}
}
