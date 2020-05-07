package study_2_choice;

import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowText2 extends Frame implements WindowListener{//, ItemListener {

	Choice choice;
	Label label;
	
	
	public WindowText2() {
		
		// AWT		- Choice
		// Swing	- JComboBox
		
		choice = new Choice();
		choice.add("사과");
		choice.add("망고");
		choice.add("오렌지");
		choice.add("포도");
		choice.add("배");
		
//		choice.addItemListener(this);
		choice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				label.setText(choice.getSelectedItem());
				
			}
		});
		
		add(choice);
		label = new Label("--");
		add(label);
		
		setLayout(new FlowLayout());
		setSize(640, 480); // 윈도우의 크기
		setLocation(200, 0); // 윈도우 실행 위치 - 화면 제일 왼쪽 위.
		setVisible(true); // 윈도우 시각화

		addWindowListener(this);
	}
//	@Override
//	public void itemStateChanged(ItemEvent e) {
//		Choice ch = (Choice)e.getSource();	//섞어쓸땐 obj로 받아서 if로 가려줘야함
//		String selected = ch.getSelectedItem();
//		label.setText(selected);
//	}
	
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
