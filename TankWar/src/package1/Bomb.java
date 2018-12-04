package package1;

public class Bomb {
	//定义炸弹坐标
	int x,y;
	//炸弹生命
	int life = 20;
	boolean isLive = true;
	public Bomb(int x,int y) {
		this.x = x;
		this.y = y;
	}
    //减少生命值
	public void lifeDown() {
		if(life>0) {
			life--;
		}else {
			this.isLive = false;
		}
	}
}
