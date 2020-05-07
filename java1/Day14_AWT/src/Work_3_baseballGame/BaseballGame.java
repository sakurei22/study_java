package Work_3_baseballGame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class BaseballGame extends Frame implements WindowListener, ActionListener {
	
	int r_num[], u_num[], message[];
	boolean clear;
	int w;

	TextField tf1, tf2, tf3;
	Label label1, label2, label3;
	Button btn1, btn2;

	public BaseballGame() {
		super("Baseball game");
		setLayout(null);

		label1 = new Label("Baseball");
		label1.setBounds(50, 50, 350, 50);
		label1.setBackground(Color.gray);
		add(label1);

		btn1 = new Button("reset");
		btn1.setBounds(450, 50, 50, 50);
		btn1.addActionListener(this);
		add(btn1);

		tf1 = new TextField();
		tf1.setBounds(50, 120, 50, 50);
		tf1.setBackground(Color.lightGray);
		add(tf1);

		tf2 = new TextField();
		tf2.setBounds(200, 120, 50, 50);
		tf2.setBackground(Color.lightGray);
		add(tf2);

		tf3 = new TextField();
		tf3.setBounds(350, 120, 50, 50);
		tf3.setBackground(Color.lightGray);
		add(tf3);

		label2 = new Label();
		label2.setBounds(50, 200, 350, 50);
		label2.setBackground(Color.gray);
		add(label2);

		btn2 = new Button("확인");
		btn2.setBounds(50, 300, 350, 50);
		btn2.addActionListener(this);
		add(btn2);

		setSize(640, 480); // 윈도우의 크기
		setLocation(200, 0); // 윈도우 실행 위치 - 화면 제일 왼쪽 위.
		setVisible(true); // 윈도우 시각화

		addWindowListener(this);

		r_num = new int[3];
		u_num = new int[3];
		message = new int[2];
		clear = false;
		w = 0;
		ballRandom(r_num);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button btn = (Button) e.getSource();
		String btnTitle1 = btn1.getLabel();
		String btnTitle2 = btn2.getLabel();

		if (btnTitle2.equals("확인")) {
			if (!tf1.getText().equals("") && !tf2.getText().equals("") 
											&& !tf3.getText().equals("")) {

				u_num[0] = Integer.parseInt(tf1.getText());
				u_num[1] = Integer.parseInt(tf2.getText());
				u_num[2] = Integer.parseInt(tf3.getText());

				if (u_num[0] == u_num[1] || u_num[0] == u_num[2] || u_num[1] == u_num[2]) {
					JOptionPane.showMessageDialog(null, "중복된 숫자가 있습니다.");
				}
			}
		}else if(btnTitle2.equals("reset")){
			
		}
		
	}

	public void ballRandom(int r_num[]) {
		boolean _switch[] = new boolean[10];
		int w, r;
		w = 0;
		while (w < 3) {
			r = (int) (Math.random() * 10); // 0~9
			if (_switch[r] == false) {
				_switch[r] = true; // ff t ff fffff
				r_num[w] = r + 1; // 1~10
				w++;
			}
		}

		for (int i = 0; i < r_num.length; i++) {
			System.out.println("r_num[" + i + "]= " + r_num[i]);

		}
	}

	boolean finding(int rnum[], int unum[], int message[]) {
		int strike = 0, ball = 0;
		// ball
		for (int i = 0; i < rnum.length; i++) {
			for (int j = 0; j < rnum.length; j++) {
				if (rnum[i] == unum[j] && i != j) {
					ball++;
				}
			}
		}
		// strike
		for (int i = 0; i < rnum.length; i++) {
			for (int j = 0; j < rnum.length; j++) {
				if (rnum[i] == unum[j]) {
					strike++;
				}
			}
		}
		message[0] = strike;
		message[1] = ball;

		// 판정
		if (strike > 2) {
			return true;
		}
		return false;
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
