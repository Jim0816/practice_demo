/**
 * @author �����
 * @���ܣ�Ӣ��̹����
 */
package package1;

import java.util.Vector;

//�ҵ�̹��
class Hero extends Tank{
	//�ҵ�̹���ӵ�
	Shot s = null;
	Vector<Shot> ss = new Vector<Shot>();
	public Hero(int x, int y) {
		super(x,y);
	}
  //�����ӵ�
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
		//�����ӵ��߳�
		Thread t = new Thread(s);
		t.start();
	}
}