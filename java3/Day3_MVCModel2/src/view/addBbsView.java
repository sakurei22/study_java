package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import dao.BbsDao;
import dto.BbsDto;
import singleton.Singleton;

public class addBbsView extends JFrame implements MouseListener{
	
	private JLabel idLabel, titleLabel, contentLabel, idLb;
	private JTextField titleTf;
	private JTextArea contentTa;
	private JButton addconBtn;
	
	
	public addBbsView(){
		super("게시판");
		setLayout(null);
		
		idLabel = new JLabel("id");
		idLabel.setBounds(50, 50, 50, 50);
		
//		MemberDao dao = MemberDao.getInstance();
		
		Singleton s = Singleton.getInstance();
		idLb = new JLabel(s.getLoginID());	// 로그인 id
		idLb.setBounds(110, 50, 200, 50);
		
		titleLabel = new JLabel("제목");
		titleLabel.setBounds(50, 110, 50, 50);
		contentLabel = new JLabel("내용");
		contentLabel.setBounds(50, 170, 50, 50);
		
		add(idLabel);
		add(idLb);
		add(titleLabel);
		add(contentLabel);
		
		titleTf = new JTextField();
		titleTf.setBounds(110, 110, 200, 50);
		add(titleTf);
		
		contentTa = new JTextArea();
		contentTa.setBounds(50, 230, 300, 200);
		add(contentTa);
		
		addconBtn = new JButton("글 추가");
		addconBtn.setBounds(200, 170, 80, 20);
		add(addconBtn);
		
		JButton bbsBtn = new JButton("게시판목록");
		bbsBtn.setBounds(290, 170, 100, 20);		
		add(bbsBtn);
		bbsBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				new bbsListView();
				s.bbsCtrl.getBbsList();
				dispose();
			}
		});
		addconBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	// 글추가 버튼
				Singleton s = Singleton.getInstance();
				
				if(titleTf.getText().equals("") || 	contentTa.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "모두 기입해 주십시오");
					return;
				}
//				BbsDao dao = BbsDao.getInstance();
//				boolean b = dao.addBbs(new BbsDto(0, idLb.getText(), titleTf.getText(), contentTa.getText(), null, 0, 0));
				
				boolean b = s.bbsCtrl.addBbsList(new BbsDto(0, idLb.getText(), titleTf.getText(), contentTa.getText(), null, 0, 0));
				if(b) {
					JOptionPane.showMessageDialog(null, "성공적으로 추가되었습니다");
//					new bbsListView();
					s.bbsCtrl.getBbsList();
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "글 추가에 실패했습니다");
				}
			}
		});
		
		
		
		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
