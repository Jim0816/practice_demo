/**
 * @author �����
 * @���ܣ��ӵ���
 */
package package1;
//�ӵ���
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
	//run����
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
				//��
				y-=speed;
				break;
			case 1:
				//��
				y+=speed;
				break;
			case 2:
				//��
				x-=speed;
				break;
			case 3:
				//��
				x+=speed;
				break;
			}
			//�ӵ�Խ�����Զ�����
			if(x<0||x>600||y<0||y>520) {
				this.isLive = false;
				break;
			}
		}
	}
}