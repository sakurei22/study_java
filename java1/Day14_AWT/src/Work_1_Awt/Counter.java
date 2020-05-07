package Work_1_Awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class Counter extends Frame implements WindowListener, ActionListener {

	Label label;
	Button btn1, btn2, btn3;
	int num;
	String str;

	public Counter() {
		super("카운터");
		setLayout(null);
		label = new Label();
		num = 0;
		str = num + "";
		label.setText(str);

		label.setBounds(75, 50, 400, 50);
		label.setBackground(Color.gray);

		add(label);

		btn1 = new Button("+");
		btn1.setBounds(75, 150, 200, 200);
		btn1.addActionListener(this);
		add(btn1);

		btn2 = new Button("-");
		btn2.setBounds(300, 150, 200, 200);
		btn2.addActionListener(this);
		add(btn2);

		btn3 = new Button("reset");
		btn3.setBounds(75, 400, 400, 50);
		btn3.addActionListener(this);
		add(btn3);

		setSize(640, 480); // 윈도우의 크기
		setLocation(200, 0); // 윈도우 실행 위치 - 화면 제일 왼쪽 위.
		setVisible(true); // 윈도우 시각화

		addWindowListener(this);

	}

	public void actionPerformed(ActionEvent e) {
//		JOptionPane.showMessageDialog(null, "버튼클릭");
		Button btn = (Button) e.getSource();
		String btnTitle = btn.getLabel(); // 버튼의 타이틀값 얻어옴
		
			if (btnTitle.equals("+")) {
				num += 1;
				str = num + "";
				label.setText(str);
			} else if (btnTitle.equals("-")) {
				num -= 1;
				str = num + "";
				label.setText(str);
			} else if (btnTitle.equals("reset")) {
				num = 0;
				str = num+"";
				label.setText(str);
			}
		
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
