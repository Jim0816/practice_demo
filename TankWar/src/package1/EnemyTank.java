/**
 * @author 李际明
 * @功能：敌军坦克类
 */
package package1;

import java.util.Vector;

//敌人坦克
class EnemyTank extends Tank implements Runnable{
	int times = 0;                         //控制敌军坦克子弹的发射频率
	//定义一个向量，可以访问到MyPanel上的所有敌军坦克
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	//定义一个存放敌人坦克子弹的向量
	Vector<Shot> ss = new Vector<Shot>();
	//敌人发射子弹介于敌军坦克出生到死亡期间
	public EnemyTank(int x, int y) {
		super(x,y);
	}
	//得到敌人坦克向量
	public void setEts(Vector<EnemyTank> vv) {
		this.ets = vv;
	}
	//判断敌人坦克之间是否相碰重叠
	public boolean isTouchOtherEnemy() {
		boolean b = false;
		switch(this.direct) {
		//敌军坦克中的我的方向朝上时
		case 0:
			for(int i=0;i<ets.size();i++) {
				//取出MyPanel上所有敌人坦克
				EnemyTank et = ets.get(i);
				//排除敌军自身坦克
				if(et!=this) {
					//敌人而言，如果战友坦克的方向向下或向上
					if(et.direct==0||et.direct==1) {
						if(this.x>=et.x && this.x<=et.x+20 && this.y>=et.y && this.y<=et.y+30) {
							return true;
						}
						if(this.x+20>=et.x && this.x+20<=et.x+20 && this.y>=et.y && this.y<=et.y+30) {
							return true;
						}
					}
					//敌人而言，如果战友坦克的方向向左或向右
					if(et.direct==2||et.direct==3) {
						if(this.x>=et.x && this.x<=et.x+30 && this.y>=et.y && this.y<=et.y+20) {
							return true;
						}
						if(this.x+20>=et.x && this.x+20<=et.x+30 && this.y>=et.y && this.y<=et.y+20) {
							return true;
						}
					}
				}
			}
			break;
		//敌军坦克中的我的方向朝下时	
		case 1:
			for(int i=0;i<ets.size();i++) {
				//取出MyPanel上所有敌人坦克
				EnemyTank et = ets.get(i);
				//排除敌军自身坦克
				if(et!=this) {
					//敌人而言，如果战友坦克的方向向下或向上
					if(et.direct==0||et.direct==1) {
						if(this.x>=et.x && this.x<=et.x+20 && this.y+30>=et.y && this.y+30<=et.y+30) {
							return true;
						}
						if(this.x+20>=et.x && this.x+20<=et.x+20 && this.y+30>=et.y && this.y+30<=et.y+30) {
							return true;
						}
					}
					//敌人而言，如果战友坦克的方向向左或向右
					if(et.direct==2||et.direct==3) {
						if(this.x>=et.x && this.x<=et.x+30 && this.y+30>=et.y && this.y+30<=et.y+20) {
							return true;
						}
						if(this.x+20>=et.x && this.x+20<=et.x+30 && this.y+30>=et.y && this.y+30<=et.y+20) {
							return true;
						}
					}
				}
			}
			break;
		//敌军坦克中的我的方向朝左时		
		case 2:
			for(int i=0;i<ets.size();i++) {
				//取出MyPanel上所有敌人坦克
				EnemyTank et = ets.get(i);
				//排除敌军自身坦克
				if(et!=this) {
					//敌人而言，如果战友坦克的方向向下或向上
					if(et.direct==0||et.direct==1) {
						if(this.x>=et.x && this.x<=et.x+20 && this.y>=et.y && this.y<=et.y+30) {
							return true;
						}
						if(this.x>=et.x && this.x<=et.x+20 && this.y+20>=et.y && this.y+20<=et.y+30) {
							return true;
						}
					}
					//敌人而言，如果战友坦克的方向向左或向右
					if(et.direct==2||et.direct==3) {
						if(this.x>=et.x && this.x<=et.x+30 && this.y>=et.y && this.y<=et.y+20) {
							return true;
						}
						if(this.x>=et.x && this.x<=et.x+30 && this.y+20>=et.y && this.y+20<=et.y+20) {
							return true;
						}
					}
				}
			}
			break;
		//敌军坦克中的我的方向朝右时
		case 3:
			for(int i=0;i<ets.size();i++) {
				//取出MyPanel上所有敌人坦克
				EnemyTank et = ets.get(i);
				//排除敌军自身坦克
				if(et!=this) {
					//敌人而言，如果战友坦克的方向向下或向上
					if(et.direct==0||et.direct==1) {
						if(this.x+30>=et.x && this.x+30<=et.x+20 && this.y>=et.y && this.y<=et.y+30) {
							return true;
						}
						if(this.x+30>=et.x && this.x+30<=et.x+20 && this.y>=et.y && this.y+20<=et.y+30) {
							return true;
						}
					}
					//敌人而言，如果战友坦克的方向向左或向右
					if(et.direct==2||et.direct==3) {
						if(this.x+30>=et.x && this.x+30<=et.x+30 && this.y>=et.y && this.y<=et.y+20) {
							return true;
						}
						if(this.x+30>=et.x && this.x+30<=et.x+30 && this.y+20>=et.y && this.y+20<=et.y+20) {
							return true;
						}
					}
				}
			}
			break;
		}
		return b;
	}
	//run函数
	public void run() {
		while(true) {
			try {
				Thread.sleep(50);
			}catch(Exception e){
				e.printStackTrace();
			}
			switch(this.direct) {
			//向上
			case 0:
				for(int i=0;i<30;i++) {
					if(y>0&&!this.isTouchOtherEnemy())
					{
						y-=speed;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;
			//向下
			case 1:
				for(int i=0;i<30;i++) {
					if(y<520&&!this.isTouchOtherEnemy())
					{
						y+=speed;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;
			//向左
			case 2:
				for(int i=0;i<30;i++) {
					if(x>0&&!this.isTouchOtherEnemy())
					{
						x-=speed;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;
			//向右
			case 3:
				for(int i=0;i<30;i++) {
					if(x<550&&!this.isTouchOtherEnemy())
					{
						x+=speed;
					}
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				break;	
			}
			this.times++;
			if(times%2==0) {
					if(isLive) {
						if(ss.size()<10) {
							Shot s = null;
							//没有子弹，需要添加
							switch(direct) {
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
							//启动敌军子弹线程
							Thread t = new Thread(s);
							t.start();
						}
					}
			}
			//让敌军坦克随机产生一个新的方向,random会随机产生一个0-1的小数，乘以4后转换为0-3的整数
			this.direct = (int)(Math.random()*4);
			//判断敌军坦克是否死亡
			if(this.isLive ==false) {
				//坦克死亡后退出线程
				break;
			}
		}
	}
}

