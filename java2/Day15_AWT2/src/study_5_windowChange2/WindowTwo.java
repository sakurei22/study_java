package study_5_windowChange2;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTwo extends Frame implements WindowListener {
	public WindowTwo() {
	
					
			setSize(800, 600); // 윈도우의 크기
			setLocation(200, 0); // 윈도우 실행 위치 - 화면 제일 왼쪽 위.
			setVisible(false); // 윈도우 시각화
			setBackground(Color.blue);
			addWindowListener(this);
			
		
		
	}
	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowOpened(WindowEvent e) {

	}

}
