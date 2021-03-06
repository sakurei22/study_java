package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dto.BbsDto;
import singleton.Singleton;


public class bbsAddView extends JFrame implements ActionListener {

	JTextField writerText;
	JTextField titleText;
	JTextArea contentArea;
	
	JButton btn;
	JButton backBtn;
	
	public bbsAddView() {
		super("글쓰기");
		setLayout(null);
		
		JLabel writerLabel = new JLabel("작성자:");
		writerLabel.setBounds(10, 10, 120, 15);
		add(writerLabel);		
		
		Singleton s = Singleton.getInstance();
				
		writerText = new JTextField(s.getLoginID());
		writerText.setBounds(120, 10, 200, 20);
		writerText.setEditable(false);		
		add(writerText);
		
		JLabel titleLabel = new JLabel("제목:");
		titleLabel.setBounds(10, 40, 120, 15);
		add(titleLabel);
		
		titleText = new JTextField();
		titleText.setBounds(120, 40, 350, 20);
		add(titleText);
		
		JLabel contentLabel = new JLabel("내용:");
		contentLabel.setBounds(10, 70, 120, 15);
		add(contentLabel);
		
		contentArea = new JTextArea();	
		contentArea.setLineWrap(true);	
			
		JScrollPane scrPane = new JScrollPane(contentArea);
		scrPane.setPreferredSize(new Dimension(200, 120));
		scrPane.setBounds(10, 100, 460, 300);
		add(scrPane);
		
		btn = new JButton("글올리기");
		btn.setBounds(150, 420, 100, 20);		
		add(btn);
		
		setBounds(100, 100, 500, 500);
		setVisible(true);	
		
		backBtn = new JButton("목록");
		backBtn.setBounds(10, 420, 100, 20);		
		add(backBtn);
		
		
		btn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn.addActionListener");
				
				Singleton s = Singleton.getInstance();	
								
				String id = s.getLoginID();
				String title = titleText.getText();
				String content = contentArea.getText();
				
				/*
				BbsDto dto = new BbsDto(0, id, title, content, null, 0, 0);				
				boolean b = dao.writeBBS(dto);
				if(b){
					JOptionPane.showMessageDialog(null, "성공적으로 추가되었습니다");
					new bbsListView();
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "추가되지 못했습니다");
				}
				*/
				BbsDto dto = new BbsDto(0, id, title, content, null, 0, 0);
				s.bbsCtrl.bbsWriteAf(dto);	
				dispose();
				
			}
		});
		
		backBtn.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton sc = Singleton.getInstance();
				sc.bbsCtrl.getBbsList();
				dispose();				
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
