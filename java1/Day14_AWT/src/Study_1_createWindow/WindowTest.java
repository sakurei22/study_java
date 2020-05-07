package Study_1_createWindow;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest extends Frame implements WindowListener{
							//프레임상속받아 창 생성			// 윈도우의 반응을 캐치하는 클래스
	public WindowTest() {
		super("간단한 예제");
		setSize(640, 480);	// 윈도우의 크기
		setLocation(200, 0);	// 윈도우 실행 위치 - 화면 제일 왼쪽 위. 
		setVisible(true);	// 윈도우 시각화
		
		addWindowListener(this);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		System.exit(0);		// 종료 메소드 없으면 윈도우의 x 를 눌러도 반응하지 않음
	}

	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("windowClosed");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified(");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
	}

	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("windowActivated");
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("windowDeactivated");
	}
	
	
}
