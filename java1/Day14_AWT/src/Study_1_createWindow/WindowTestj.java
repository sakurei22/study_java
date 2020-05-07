package Study_1_createWindow;

import javax.swing.JFrame;

public class WindowTestj extends JFrame{	//JFrame이용하여 창 생성
	public WindowTestj() {
		setSize(800, 600);
		setLocation(100, 0);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
