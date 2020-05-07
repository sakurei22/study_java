package view;

import java.awt.Choice;
import java.awt.Color;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dto.BbsDto;
import javabean.BbsDao;
import javabean.MemberDao;

public class bbsListView extends JFrame implements MouseListener {
	
	private JTable jtable;
	private JScrollPane jscrPane;
	private JTextField searchTf;
	private JButton writeBtn, searchBtn, logoutBtn;
	private JButton listBtn;
	String columnNames[] = {
			"번호", "제목", "작성자"
	};
	
	Object rowData[][];
	
	DefaultTableModel model;	// table의 넓이를 설정

	List<BbsDto> list;
	
	int btnNum;
	
	public bbsListView() {
		super("게시판");
		setLayout(null);
		btnNum = 1;
		JLabel label = new JLabel("게시판");
		label.setBounds(10, 10, 120, 15);
		add(label);
		
		// dao(DB)를 통해서 list를 취득
		BbsDao dao = BbsDao.getInstance();
		list = dao.getBbsList(btnNum);			//btnNum 으로 파라미터 받아 리스트 출력 (10개씩)
		makeTable();
		
		
		// list사이즈로 버튼 생성 - 버튼 1개만 생성
		listBtn = new JButton(btnNum+"");
		listBtn.setBounds(280, 250, 50, 30);
		add(listBtn);
		
		JButton subBtn = new JButton("<");
		subBtn.setBounds(210, 250, 50, 30);
		add(subBtn);
		JButton plusBtn = new JButton(">");
		plusBtn.setBounds(350, 250, 50, 30);
		add(plusBtn);
		
		subBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnNum = btnNum - 1;
				if(btnNum == 0) {
					JOptionPane.showMessageDialog(null, "첫페이지입니다");
					btnNum = 1;
				}
				listBtn.setText(btnNum+"");
				list = dao.getBbsList(btnNum);
				makeTable();
			}
		});
		
		plusBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnNum = btnNum + 1;
				listBtn.setText(btnNum+"");
				list = dao.getBbsList(btnNum);
				if(list.size() == 0) {
					JOptionPane.showMessageDialog(null, "마지막페이지입니다");
					btnNum = btnNum - 1;
					listBtn.setText(btnNum+"");
					list = dao.getBbsList(btnNum);
				}
				makeTable();
			}
		});
		
		
		
		
		// 검색
		// 검색 조건 설정
		Choice choice = new Choice();
		choice.add("title");
		choice.add("id");
		choice.add("content");
		choice.setBounds(300, 360, 60, 20);
		add(choice);
		
		searchTf = new JTextField();
		searchTf.setBounds(360, 360, 140, 25);
		add(searchTf);
		
		
		searchBtn = new JButton("검색");
		searchBtn.setBounds(500, 360, 60, 25);
		add(searchBtn);
		
		
		writeBtn = new JButton("글 작성");
		writeBtn.setBounds(510, 10, 100, 20);
		add(writeBtn);
		
		
		logoutBtn = new JButton("로그아웃");
		logoutBtn.setBounds(10, 360, 100, 20);	
		add(logoutBtn);
		
		setBackground(new Color(0, 0, 128));
		setBounds(100, 100, 640, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// 글추가
		writeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				new addBbsView();
			}
		});
		// 로그아웃
		logoutBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberDao dao = MemberDao.getInstance();
				dao.setLoginID("");
				dispose();
				new loginView();
			}
		});
		// 검색
		searchBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// db에 접근 -> 검색된 글들
				String how_to_search = choice.getSelectedItem();
				String str = searchTf.getText().trim();
				list = dao.searchBbs(how_to_search, str);
				
				//확인
				if(list.size() == 0 || searchTf.getText().trim().equals("")) {
					JOptionPane.showMessageDialog(null, "검색할 단어나 문장이 없습니다.");
					//원본 list를 호출
					list = dao.getBbsList(btnNum);
				}	
			}
		});
	}

	public void makeTable() {
		
		// Jtable의 row를 생성
		rowData = new Object[list.size()][3];
		
		// list에서 Jtalbe로 데이터를 삽입
		for (int i = 0; i < list.size(); i++) {
			BbsDto dto = list.get(i);
			rowData[i][0] = i + 1;			// 글의 번호 : 1, 2, 3, ... 글번호와 sequence번호는 다름
			rowData[i][1] = dto.getTitle();	// 글의 제목
			rowData[i][2] = dto.getId();	// 작성자
		}
		// Jtable관련
		// 테이블 폭 설정하기 위한 model
		model = new DefaultTableModel(columnNames, 0);
		model.setDataVector(rowData, columnNames);
		
		// 테이블 생성
		jtable = new JTable(model);
		jtable.addMouseListener(this);
		
		// 각 column의 폭 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(50);	// 번호
		jtable.getColumnModel().getColumn(1).setMaxWidth(500);	// 제목
		jtable.getColumnModel().getColumn(2).setMaxWidth(200);	// 작성자
		
		// 테이블의 column의 글의 맞춤(왼쪽, 중간, 오른쪽)
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);	// 중간
		
		// '번호'와 '작성자'의 컬럼은 글의 중간 맞춤이 된다
		jtable.getColumn("번호").setCellRenderer(celAlignCenter);
		jtable.getColumn("작성자").setCellRenderer(celAlignCenter);
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 185);
		add(jscrPane);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// 게시글 눌렀을때 세부 정보 출력
		int rowNum = jtable.getSelectedRow();
		if(list.get(rowNum).getDel() == 1) {	// 삭제되었을 경우 delNumber 1로 전환. 1일경우 읽기 불가능 
			JOptionPane.showMessageDialog(null, "이 글은 볼 수 없습니다");
			return;
		}
		dispose();
		BbsDao dao = BbsDao.getInstance();
		dao.readCount(list.get(rowNum).getSeq());	// 선택했을 때 조회수 +1
		
		new bbsDetailView(list.get(rowNum).getSeq());
	}		
		
	
	

	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}