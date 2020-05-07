package Study_6_chatApp;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

public class WindowTest6 extends JFrame {
													// 윈도우의 반응을 캐치하는 클래스
	JTextField textField;	//채팅 입력받는 곳
	JTextArea textArea;		//채팅 보이는 곳
	
	JButton btn1, btn2;
	
	public WindowTest6() {
		super("간단한 예제");
		
		JPanel panel = new JPanel();
		textArea = new JTextArea();
		textArea.setLineWrap(true); // 라인그리기
		JScrollPane scrPane = new JScrollPane(textArea);
		scrPane.setPreferredSize(new Dimension(400, 300));
		panel.add(scrPane);
		
		JPanel botpan = new JPanel();
		textField = new JTextField(20);
		btn1 = new JButton("next insert");
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(!textField.getText().equals("")) {
					String msg = textField.getText() + "\n";
					textArea.append(msg);
				}
			}
		});
		
		btn2 = new JButton("prev insert");
		btn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				if(textField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "문장을 기입하세요");
					return;
				}
				
				try {
					textArea.insert(textField.getText() + "\n", textArea.getLineStartOffset(0));
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		botpan.add(textField);
		botpan.add(btn1);
		botpan.add(btn2);
		
		// Layout
		Container contentPane = getContentPane();
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(botpan, BorderLayout.SOUTH);
		
		
		setSize(640, 480);	// 윈도우의 크기
		setLocation(200, 0);	// 윈도우 실행 위치 - 화면 제일 왼쪽 위. 
		setVisible(true);	// 윈도우 시각화
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
