/**
 * @author 李际明
 * @功能：子弹类
 */
package package1;
//子弹类
class Shot implements Runnable{
	int x;
	int y;
	int direct;
	int speed=2;
	int color;
	boolean isLive = true;
	public Shot(int x,int y,int direct,int color) {
		this.x = x;
		this.y = y;
		this.direct = direct;
		this.color = color;
	}
	//run函数
	public void run() {
		while(true) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			switch(direct) {
			case 0:
				//上
				y-=speed;
				break;
			case 1:
				//下
				y+=speed;
				break;
			case 2:
				//左
				x-=speed;
				break;
			case 3:
				//右
				x+=speed;
				break;
			}
			//子弹越界则自动死亡
			if(x<0||x>600||y<0||y>520) {
				this.isLive = false;
				break;
			}
		}
	}
}