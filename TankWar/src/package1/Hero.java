/**
 * @author 李际明
 * @功能：英雄坦克类
 */
package package1;

import java.util.Vector;

//我的坦克
class Hero extends Tank{
	//我的坦克子弹
	Shot s = null;
	Vector<Shot> ss = new Vector<Shot>();
	public Hero(int x, int y) {
		super(x,y);
	}
  //发射子弹
	public void ShotEnemy() {
		switch(this.direct) {
		case 0:
			s = new Shot(x+10,y,0,color);
		    ss.add(s);
			break;
		case 1:
		    s = new Shot(x+10,y+30,1,color);
			ss.add(s);
			break;	
		case 2:
			s = new Shot(x,y+10,2,color);
			ss.add(s);
			break;	
		case 3:
			s = new Shot(x+30,y+10,3,color);
			ss.add(s);
			break;	
		}
		//启动子弹线程
		Thread t = new Thread(s);
		t.start();
	}
}