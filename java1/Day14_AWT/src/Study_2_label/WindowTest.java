package Study_2_label;

import java.awt.Frame;
import java.awt.Label;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class WindowTest extends Frame implements WindowListener {
	
	public WindowTest() {
		super("label");
		setTitle("레이블");
//		setSize(640, 480);
//		setLocation(0, 0);
		setBounds(0, 0, 640, 480);
		
		setVisible(true);
		
		addWindowListener(this);
		
		Label label = new Label();
		label.setText("여기가 label입니다.");		// 실행시 한글 꺠지면 구글에서 검색. 
		add(label);								// -Dfile.encoding=MS949

		Label label1 = new Label("추가 label입니다");
		add(label1);
		
		System.out.println("WindowTest WindowTest()"); // 콘솔로 확인
		
		JOptionPane.showMessageDialog(null, "WindowTest WindowTest()실행");	
		// text box로 확인	
		// 메세지 출력시 프로그램 멈춤.
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
	}

	@Override
	public void windowIconified(WindowEvent e) {
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
	}

	@Override
	public void windowActivated(WindowEvent e) {
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
	}
}
