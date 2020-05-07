package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dto.BbsDto;
import javabean.BbsDao;
import javabean.MemberDao;

public class updateBbsView extends JFrame {
	private JLabel idLabel, titleLabel, contentLabel, idLb;
	private JTextField titleTf;
	private JTextArea conTa;
	private JButton updateBtn, backBtn;
	
	
	public updateBbsView(BbsDto dto) {
		super("수정");
		setLayout(null);
		
		
		idLabel = new JLabel("id");
		idLabel.setBounds(50, 50, 50, 20);
		
		MemberDao dao = MemberDao.getInstance();
		idLb = new JLabel(dao.getLoginID());	// 로그인 id
		idLb.setBounds(100, 50, 200, 20);
		
//		wdateTextfield.setEditable(false);		텍스트필드로 설정 후 편집 불가 설정 할 수 있음(setEditable)
		titleLabel = new JLabel("제목");
		titleLabel.setBounds(50, 80, 50, 20);
		contentLabel = new JLabel("내용");
		contentLabel.setBounds(50, 110, 50, 20);
		
		add(idLabel);
		add(idLb);
		add(titleLabel);
		add(contentLabel);
		
		titleTf = new JTextField();
		titleTf.setBounds(100, 80, 100, 20);
		titleTf.setText(dto.getTitle());
		add(titleTf);
		
		conTa = new JTextArea();
		conTa.setBounds(50, 140, 400, 300);
		conTa.setText(dto.getContent());
		conTa.setLineWrap(true);				// 자동 줄 바꿈
		add(conTa);
		JScrollPane scrPane = new JScrollPane(conTa);
		scrPane.setBounds(10, 160, 400, 300);	// location + dimension
		add(scrPane);
		
		updateBtn = new JButton("수정");
		updateBtn.setBounds(200, 50, 60, 20);
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BbsDao dao = BbsDao.getInstance();
				dao.updateBbs(dto.getSeq(), titleTf.getText(), conTa.getText());
				new bbsListView();
			}
		});
		add(updateBtn);
		
		backBtn = new JButton("뒤로");
		backBtn.setBounds(200, 80, 60, 20);
		backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new bbsDetailView(dto.getSeq());
				
			}
		});
		add(backBtn);
		
		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
