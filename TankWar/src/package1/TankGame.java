/**
 * @author �����
 * @���ܣ�̹�˴�ս��Ϸ������
 */
package package1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
public class TankGame extends JFrame{
	
	public static void main(String[] args) {
		new TankGame();
	}
	//���캯��
	public TankGame() {
		this.setSize(600,520);
		this.setTitle("̹�˴�ս");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		MyPanel myPanel = new MyPanel();
		Thread t = new Thread(myPanel);
		t.start();
		this.add(myPanel);
		//ע�����
		this.addKeyListener(myPanel);
		this.validate();                    //���½���
	}
}
