/**
 * @author �����
 * @���ܣ�̹�˸���
 */
package package1;
//̹����
class Tank{
	int x=0;
	int y =0;
	//̹�˷���  0��ʾ�ϣ�1��ʾ�£�2��ʾ��3��ʾ��
	int direct = 0;
	//̹���ٶ�
	int speed = 1;
	//̹����ɫ
	int color;
	boolean isLive = true;
	//���캯��
	public Tank(int x,int y) {
		this.x = x;
		this.y = y;
	}
	//̹�˺�����
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	//̹��������
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	//�ٶ�
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	//̹�˷���
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
	//̹���ƶ�
	//̹�������ƶ�
	public void moveUp() {
		y-=speed;
	}
	//̹�������ƶ�
	public void moveDowm() {
		y+=speed;
	}
	//̹�������ƶ�
	public void moveLeft() {
			x-=speed;
	}
	//̹�������ƶ�
	public void moveRight() {
			x+=speed;
	}
	//̹����ɫ
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
}

