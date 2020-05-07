package study_7_table;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class WindowTest7 extends JFrame implements WindowListener, MouseListener{
	
	JTable table;
	JScrollPane scrPane;
	
	String columNames[] = {
			"상품번호","상품명","상품 가격","제조 회사"
	};
	
	Object rowDatas[][] = {	 // data를 삽입하는 배열
			{1001, "맛동산", 1000, "오리온"},
			{1002, "초코파이", 1200, "해태"},
			{1003, "감자깡", 1500, "롯데"},
	};	
	public WindowTest7() {
		
		table = new JTable(rowDatas, columNames);
		table.addMouseListener(this);
		scrPane = new JScrollPane(table);
		add(scrPane);
		
	
		
		
		setSize(640, 480); // 윈도우의 크기
		setLocation(200, 0); // 윈도우 실행 위치 - 화면 제일 왼쪽 위.
		setVisible(true); // 윈도우 시각화
		
		addWindowListener(this);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int rowNum = table.getSelectedRow();
//		JOptionPane.showMessageDialog(null, "rowNum = "+rowNum);
		
		for (int i = 0; i < rowDatas.length; i++) {
			for (int j = 0; j < rowDatas[0].length; j++) {
				String item =  columNames[j]+"= "+rowDatas[i][j];
				
			}
		}
				
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
}