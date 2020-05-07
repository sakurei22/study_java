package Study_4_Panel;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest4 extends Frame implements WindowListener {
	
	public WindowTest4() {
	
		// Panel == 종이위에 종이(작업영역)
		setLayout(new GridLayout(2, 1)); 	// 기본으로 위.아래 두칸으로 나눔
		
		//label 
//		Label label = new Label("labele");	// 1,1
//		add(label);		// 추가하는 순서대로 작성
		
		MyPanel myP = new MyPanel();
		add(myP);						// 상속받아 만든 페널 추가
		
		//Panel
		Panel panel = new Panel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setLayout(new GridLayout(1, 2));
		add(panel);
		
		Label label1 = new Label("label1"); // 2,1
		panel.add(label1);
		
		Button button = new Button("button");	//2,2
		panel.add(button);
		
		setBounds(0, 0, 640, 480);
		setVisible(true);
		addWindowListener(this);
		
	}
	
	
	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
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
