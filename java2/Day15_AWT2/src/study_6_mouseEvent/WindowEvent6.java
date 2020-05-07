package study_6_mouseEvent;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.MouseMotionListener;

public class WindowEvent6 extends Frame implements WindowListener, MouseListener, MouseMotionListener {
		Label label;
		int x,y;
	public WindowEvent6() {
		super("");
		setLayout(null);
		
		label = new Label("x = y = ");
		label.setBounds(50, 100, 200, 30);
		add(label);
		
		
		setSize(800, 600); // 윈도우의 크기
		setLocation(100, 0); // 윈도우 실행 위치 - 화면 제일 왼쪽 위.
		setVisible(true); // 윈도우 시각화
		addWindowListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);

		
	}
	// mouseMoved
	 public void mouseMoved(MouseEvent e) {
		  int xpos = e.getX();
		  int ypos = e.getY();
		  label.setText("x = " + xpos + ", y = " + ypos);
		 }
	
	@Override
	public void mousePressed(MouseEvent e) {	//클릭했을때
//		System.out.println("mousePressed");
//		x = e.getX();
//		y = e.getY();
//		
//		label.setText("x = " +x + " y = "+y);
		
		
	}

	
	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		
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
		@Override
		public void mouseDragged(MouseEvent e) {
			
		}
}
