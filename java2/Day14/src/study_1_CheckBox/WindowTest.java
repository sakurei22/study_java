package study_1_CheckBox;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class WindowTest extends Frame implements WindowListener, ItemListener{
	Checkbox cb1, cb2,cb3,cb4,cb5,cb6;
	Label label1, label2, label3;
	JRadioButton rb1, rb2, rb3;
	
	public WindowTest() {
		/*
		 	Check Box(취미)
		 	Radio Button
		 	
		 	AWT : radio -> Checkbox
		 	swing : JRadioButton
		 */
	
		
		CheckboxGroup cbg1 = new CheckboxGroup();
		// cb1, cb2, cb3 : 1group
		cb1 = new Checkbox("사과", cbg1, true);
		cb2 = new Checkbox("배", cbg1, false);
		cb3 = new Checkbox("바나나", cbg1, false);
		
		CheckboxGroup cbg2 = new CheckboxGroup();
		// cb4, cb5 : 2group
		cb4 = new Checkbox("남성", cbg2, true);
		cb5 = new Checkbox("여성", cbg2, false);
		
		//cb6
		cb6 = new Checkbox("exit");
				
		label1 = new Label("label1");
		label2 = new Label("label2");
		label3 = new Label("label3");
		
		JRadioButton rb1 = new JRadioButton("사과");
		JRadioButton rb2 = new JRadioButton("배");
		JRadioButton rb3 = new JRadioButton("바나나");
		ButtonGroup bg = new ButtonGroup();
		bg.add(rb1);
		bg.add(rb2);
		bg.add(rb3);
		
		add(rb1);
		add(rb2);
		add(rb3);
		
		add(cb1);
		add(cb2);
		add(cb3);
		add(cb4);
		add(cb5);
		add(cb6);
		
		cb1.addItemListener(this);
		cb2.addItemListener(this);
		cb3.addItemListener(this);
		cb4.addItemListener(this);
		cb5.addItemListener(this);
		cb6.addItemListener(this);
		
		add(label1);
		add(label2);
		add(label3);
		
		setLayout(new FlowLayout());
		setSize(640, 480); // 윈도우의 크기
		setLocation(200, 0); // 윈도우 실행 위치 - 화면 제일 왼쪽 위.
		setVisible(true); // 윈도우 시각화

		addWindowListener(this);
	
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
	//	JOptionPane.showMessageDialog(null, "체크");
		Object obj = e.getSource();
		Checkbox cb = (Checkbox)obj;
		
		if(obj == cb6) {	//check box
			cb = (Checkbox)obj;
			if(cb.getState()) {
				JOptionPane.showMessageDialog(null, "체크");
			}else {
				JOptionPane.showMessageDialog(null, "체크 해제");
			}
		}else if(obj ==cb1 ||obj ==cb2 ||obj ==cb3){	//cb1,2,3,4,5
			if(cb.getState()) {
				label1.setText( cb.getLabel() );
		
			}
		}else if(obj == cb4 || obj ==cb5 ){
			if(cb.getState()) {
				label2.setText( cb.getLabel() );
			}
		}
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
