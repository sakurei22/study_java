package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dto.BbsDto;
import javabean.BbsDao;
import javabean.MemberDao;

public class bbsDetailView extends JFrame {
	
	JLabel lb[];
	JLabel conLb[];
	JLabel content;
	
	JButton updateBtn, deleteBtn, backBtn;
	
	BbsDto dto;
	BbsDao dao;
	
	public bbsDetailView(int seq) {
		super("글 세부내용");
		setLayout(null);
		dao = BbsDao.getInstance();
		dto = dao.getOneBbs(seq);
		String title[] = { "작성자", "작성일", "조회수", "제목", "내용"};
		lb = new JLabel[5];
		for (int i = 0; i < lb.length; i++) {
			lb[i] = new JLabel(title[i]);
			lb[i].setBounds(50, 20 + 60* i, 60, 50);
			add(lb[i]);
		}
		
		conLb = new JLabel[4];
		for (int i = 0; i < conLb.length; i++) {
			conLb[i] = new JLabel();
			conLb[i].setBounds(110, 20 + 60 * i, 100, 50);
			add(conLb[i]);
		}
		conLb[0].setText(dto.getId());
		conLb[1].setText(dto.getWdate());
		conLb[2].setText(dto.getReadcount()+"");
		conLb[3].setText(dto.getTitle());
		
		content = new JLabel();
		content.setOpaque(true);
		content.setBackground(new Color(255,255,255));
		content.setBounds(100, 300, 500, 100);
		content.setText(dto.getContent());
		add(content);
		
		updateBtn = new JButton("수정");
		updateBtn.setBounds(400, 50, 100, 50);
		deleteBtn = new JButton("삭제");
		deleteBtn.setBounds(400, 120, 100, 50);
		backBtn = new JButton("뒤로");
		backBtn.setBounds(400, 190, 100, 50);
		add(updateBtn);
		add(deleteBtn);
		add(backBtn);
		
		
		// 작성된 글의 id와 현재 로그인된 id가 다르면 버튼 비활성화
		if(!dto.getId().equals(MemberDao.getInstance().getLoginID())){
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);			
		}
		
		updateBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new updateBbsView(dto);
				dispose();
				
			}
		});
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BbsDao dao = BbsDao.getInstance();
				if(dao.deleteBbs(seq)) {
				JOptionPane.showMessageDialog(null, "삭제되었습니다");
				} else {
				JOptionPane.showMessageDialog(null, "글이 삭제되지 않았습니다");
				}
				new bbsListView();
				dispose();
				
			}
		});
		backBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new bbsListView();
				dispose();
				
			}
		});
		
		
		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
