package Study_1_createWindow;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class WindowTest1 implements WindowListener {
						// 상속없이 창 생성
	public WindowTest1() {
		
		Frame frame = new Frame();
		
		frame.setTitle("제목");
		frame.setSize(640, 480);
		frame.setLocation(100, 100);
		frame.setBackground(Color.black);
		
		frame.setVisible(true);
		frame.addWindowListener(this);
		
	
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
	}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);							// 오버라이딩하고 첫번쨰로 작성한는것이 좋음
	}
	@Override
	public void windowClosed(WindowEvent e) {
	}
	@Override
	public void windowIconified(WindowEvent e) {
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
	}
	@Override
	public void windowActivated(WindowEvent e) {
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
	}
}
