/**
 * @author �����
 * @���ܣ��о�̹����
 */
package package1;

import java.util.Vector;

//����̹��
class EnemyTank extends Tank implements Runnable{
	int times = 0;                         //���Ƶо�̹���ӵ��ķ���Ƶ��
	//����һ�����������Է��ʵ�MyPanel�ϵ����ео�̹��
	Vector<EnemyTank> ets = new Vector<EnemyTank>();
	//����һ����ŵ���̹���ӵ�������
	Vector<Shot> ss = new Vector<Shot>();
	//���˷����ӵ����ڵо�̹�˳����������ڼ�
	public EnemyTank(int x, int y) {
		super(x,y);
	}
	//�õ�����̹������
	public void setEts(Vector<EnemyTank> vv) {
		this.ets = vv;
	}
	//�жϵ���̹��֮���Ƿ������ص�
	public boolean isTouchOtherEnemy() {
		boolean b = false;
		switch(this.direct) {
		//�о�̹���е��ҵķ�����ʱ
		case 0:
			for(int i=0;i<ets.size();i++) {
				//ȡ��MyPanel�����е���̹��
				EnemyTank et = ets.get(i);
				//�ų��о�����̹��
				if(et!=this) {
					//���˶��ԣ����ս��̹�˵ķ������»�����
					if(et.direct==0||et.direct==1) {
						if(this.x>=et.x && this.x<=et.x+20 && this.y>=et.y && this.y<=et.y+30) {
							return true;
						}
						if(this.x+20>=et.x && this.x+20<=et.x+20 && this.y>=et.y && this.y<=et.y+30) {
							return true;
						}
					}
					//���˶��ԣ����ս��̹�˵ķ������������
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
		//�о�̹���е��ҵķ�����ʱ	
		case 1:
			for(int i=0;i<ets.size();i++) {
				//ȡ��MyPanel�����е���̹��
				EnemyTank et = ets.get(i);
				//�ų��о�����̹��
				if(et!=this) {
					//���˶��ԣ����ս��̹�˵ķ������»�����
					if(et.direct==0||et.direct==1) {
						if(this.x>=et.x && this.x<=et.x+20 && this.y+30>=et.y && this.y+30<=et.y+30) {
							return true;
						}
						if(this.x+20>=et.x && this.x+20<=et.x+20 && this.y+30>=et.y && this.y+30<=et.y+30) {
							return true;
						}
					}
					//���˶��ԣ����ս��̹�˵ķ������������
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
		//�о�̹���е��ҵķ�����ʱ		
		case 2:
			for(int i=0;i<ets.size();i++) {
				//ȡ��MyPanel�����е���̹��
				EnemyTank et = ets.get(i);
				//�ų��о�����̹��
				if(et!=this) {
					//���˶��ԣ����ս��̹�˵ķ������»�����
					if(et.direct==0||et.direct==1) {
						if(this.x>=et.x && this.x<=et.x+20 && this.y>=et.y && this.y<=et.y+30) {
							return true;
						}
						if(this.x>=et.x && this.x<=et.x+20 && this.y+20>=et.y && this.y+20<=et.y+30) {
							return true;
						}
					}
					//���˶��ԣ����ս��̹�˵ķ������������
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
		//�о�̹���е��ҵķ�����ʱ
		case 3:
			for(int i=0;i<ets.size();i++) {
				//ȡ��MyPanel�����е���̹��
				EnemyTank et = ets.get(i);
				//�ų��о�����̹��
				if(et!=this) {
					//���˶��ԣ����ս��̹�˵ķ������»�����
					if(et.direct==0||et.direct==1) {
						if(this.x+30>=et.x && this.x+30<=et.x+20 && this.y>=et.y && this.y<=et.y+30) {
							return true;
						}
						if(this.x+30>=et.x && this.x+30<=et.x+20 && this.y>=et.y && this.y+20<=et.y+30) {
							return true;
						}
					}
					//���˶��ԣ����ս��̹�˵ķ������������
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
	//run����
	public void run() {
		while(true) {
			try {
				Thread.sleep(50);
			}catch(Exception e){
				e.printStackTrace();
			}
			switch(this.direct) {
			//����
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
			//����
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
			//����
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
			//����
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
							//û���ӵ�����Ҫ���
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
							//�����о��ӵ��߳�
							Thread t = new Thread(s);
							t.start();
						}
					}
			}
			//�õо�̹���������һ���µķ���,random���������һ��0-1��С��������4��ת��Ϊ0-3������
			this.direct = (int)(Math.random()*4);
			//�жϵо�̹���Ƿ�����
			if(this.isLive ==false) {
				//̹���������˳��߳�
				break;
			}
		}
	}
}

