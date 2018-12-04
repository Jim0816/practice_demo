/**
 * @author 李际明
 * @功能：坦克大战游戏主界面
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
	//构造函数
	public TankGame() {
		this.setSize(600,520);
		this.setTitle("坦克大战");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		MyPanel myPanel = new MyPanel();
		Thread t = new Thread(myPanel);
		t.start();
		this.add(myPanel);
		//注册监听
		this.addKeyListener(myPanel);
		this.validate();                    //更新界面
	}
}
