/**
 * @author 李际明
 * @功能：坦克父类
 */
package package1;
//坦克类
class Tank{
	int x=0;
	int y =0;
	//坦克方向  0表示上，1表示下，2表示左，3表示右
	int direct = 0;
	//坦克速度
	int speed = 1;
	//坦克颜色
	int color;
	boolean isLive = true;
	//构造函数
	public Tank(int x,int y) {
		this.x = x;
		this.y = y;
	}
	//坦克横坐标
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	//坦克纵坐标
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	//速度
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	//坦克方向
	public int getDirect() {
		return direct;
	}
	public void setDirect(int direct) {
		this.direct = direct;
	}
	//坦克移动
	//坦克向上移动
	public void moveUp() {
		y-=speed;
	}
	//坦克向下移动
	public void moveDowm() {
		y+=speed;
	}
	//坦克向左移动
	public void moveLeft() {
			x-=speed;
	}
	//坦克向右移动
	public void moveRight() {
			x+=speed;
	}
	//坦克颜色
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
}

