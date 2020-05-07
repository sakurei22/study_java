package work1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Window extends JFrame {
	JLabel lb_1, lb_2;
	JButton bt_1, bt_2;
	JTextField tf_1, tf_2;
	public Window() {
		super("회원가입");
		setLayout(null);

		lb_1 = new JLabel();
		lb_2 = new JLabel();
		lb_1.setText("ID");
		lb_1.setBounds(50, 50, 50, 50);
		lb_2.setText("PW");
		lb_2.setBounds(50, 120, 50, 50);
		add(lb_1);
		add(lb_2);
		
		tf_1 = new JTextField();
		tf_1.setBounds(160, 50, 200, 50);
		tf_2 = new JTextField();
		tf_2.setBounds(160, 120, 200, 50);
		add(tf_1);
		add(tf_2);
		
		bt_1 = new JButton();
		bt_2 = new JButton();
		bt_1.setText("로그인");
		bt_1.setBounds(50, 200, 100, 50);
		bt_2.setText("회원가입");
		bt_2.setBounds(160, 200, 100, 50);
		add(bt_1);
		add(bt_2);
		bt_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		bt_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InsertMember();
			}
		});
		setSize(600, 480);
		setLocation(100, 0);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
