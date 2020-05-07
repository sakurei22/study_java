package study_4_windowChange;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class windowOne extends Frame implements WindowListener {
	public windowOne() {
	
		setLayout(null);
		Button btn = new Button("move win");
		btn.setBounds(100, 100, 100, 30);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new windowTwo();
				
			}
		});
		add(btn);
		
		setSize(640, 480); // 윈도우의 크기
		setLocation(200, 0); // 윈도우 실행 위치 - 화면 제일 왼쪽 위.
		setVisible(true); // 윈도우 시각화
		setBackground(Color.darkGray);
		addWindowListener(this);
		
	}
	@Override
	public void windowActivated(WindowEvent arg0) {

	}

	@Override
	public void windowClosed(WindowEvent arg0) {

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {

	}

	@Override
	public void windowIconified(WindowEvent arg0) {

	}

	@Override
	public void windowOpened(WindowEvent arg0) {

	}

}
