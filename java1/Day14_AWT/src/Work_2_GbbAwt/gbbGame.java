package Work_2_GbbAwt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class gbbGame extends Frame implements WindowListener, ActionListener {
	Label label1, label2, label3, label4, label5, label6;
	Button btn1, btn2, btn3;
	String str;
	int u_num;
	int com;
	
	int win = 0 ;
	int lose = 0;
	int draw = 0;
	
	
	public gbbGame() {
	
		super("가위바위보 게임");
		setLayout(null);
		label1 = new Label();
		str = win+"승 "+lose+"패 "+draw+"무";
		label1.setText(str);
		label1.setBounds(50, 50, 450, 50);
		label1.setBackground(Color.gray);
		add(label1);
		
		label2 = new Label("player choice");
		label2.setBounds(50, 200, 150, 100);
		label2.setBackground(Color.gray);
		add(label2);
		
		label3 = new Label("result");
		label3.setBounds(210, 200, 150, 100);
		label3.setBackground(Color.gray);
		add(label3);
		
		label4 = new Label("com choice");
		label4.setBounds(370, 200, 150, 100);
		label4.setBackground(Color.gray);
		add(label4);
		
		label5 = new Label("Player");
		label5.setBounds(50, 150, 150, 50);
		label5.setBackground(Color.DARK_GRAY);
		add(label5);
		
		label6 = new Label("Computer");
		label6.setBounds(370, 150, 150, 50);
		label6.setBackground(Color.DARK_GRAY);
		add(label6);
		
		btn1 = new Button("가위");
		btn1.setBounds(50, 350, 150, 100);
		btn1.addActionListener(this);
		add(btn1);

		btn2 = new Button("바위");
		btn2.setBounds(210, 350, 150, 100);
		btn2.addActionListener(this);
		add(btn2);

		btn3 = new Button("보");
		btn3.setBounds(370, 350, 150, 100);
		btn3.addActionListener(this);
		add(btn3);
		
		
		setSize(640, 480); // 윈도우의 크기
		setLocation(200, 0); // 윈도우 실행 위치 - 화면 제일 왼쪽 위.
		setVisible(true); // 윈도우 시각화

		addWindowListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button) e.getSource();
		String btnTitle = btn.getLabel(); // 버튼의 타이틀값 얻어옴
		com = (int) (Math.random() * 3);
		
			if (btnTitle.equals("가위")) {
				u_num = 0;
				label2.setText("가위");
				if( u_num == com ) {
					label4.setText("가위");
					label3.setText("무승부");
					draw += 1;
				}
				else if (com == 1) {
					label4.setText("바위");
					label3.setText("패배");
					lose += 1;
				} else {
					label4.setText("보");
					label3.setText("승리");
					win += 1;
				}
			} else if (btnTitle.equals("바위")) {
				u_num = 1;
				label2.setText("바위");
				if( u_num == com ) {
					label4.setText("바위");
					label3.setText("무승부");
					draw += 1;
				} else if (com == 2) {
					label4.setText("보");
					label3.setText("패배");
					lose += 1;
				} else {
					label4.setText("가위");
					label3.setText("승리");
					win += 1;
				}
			} else if (btnTitle.equals("보")) {
				u_num = 2;
				label2.setText("보");
				if( u_num == com ) {
					label4.setText("보");
					label3.setText("무승부");
					draw += 1;
				} else if (com == 0) {
					label4.setText("가위");
					label3.setText("패배");
					lose += 1;
				} else {
					label4.setText("바위");
					label3.setText("승리");
					win += 1;
				}
			}
			str = win+"승 "+lose+"패 "+draw+"무";
			label1.setText(str);
		
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
