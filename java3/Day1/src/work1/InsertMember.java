package work1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InsertMember extends JFrame {
	JLabel lb[];
	JTextField tf[];
	JButton bt1, bt2;
	
	public InsertMember() {
		super("회원가입");
		setLayout(null);
		
		lb = new JLabel[4];
		for (int i = 0; i < lb.length; i++) {
			lb[i] = new JLabel();
			lb[i].setBounds(50 , 50+ 60 * i, 60, 50);
			add(lb[i]);			
		}		
		lb[0].setText("ID");
		lb[1].setText("PW");
		lb[2].setText("Name");
		lb[3].setText("Email");
		
		tf = new JTextField[4];
		lb = new JLabel[4];
		for (int i = 0; i < tf.length; i++) {
			tf[i] = new JTextField();
			tf[i].setBounds(110 , 50+ 60 * i, 120, 50);
			add(tf[i]);			
		}
		
		bt1 = new JButton();
		bt1.setText("중복확인");
		bt1.setBounds(250, 50, 100, 50);
		bt2 = new JButton();
		bt2.setText("회원 가입");
		bt2.setBounds(80, 300, 150, 50);
		add(bt1);
		add(bt2);
		
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "사용가능한 ID입니다");
			}
		});
		bt2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "회원가입 성공!");
				dispose();
				new Window();
			}
		});
		
		setSize(600, 480);
		setLocation(100, 0);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
