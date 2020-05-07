package study_3_image;


import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowText3 extends Frame implements WindowListener {

	Image img = null;
	Image pngImg = null;
	int width, height;
	
	public WindowText3() {

		setLayout(null);
		Toolkit tk = Toolkit.getDefaultToolkit();
		
//		img = tk.getImage("house.jpg");
//		img = tk.getImage("d:/tmp/pig.png");
		pngImg = tk.getImage("bird.png");
		img = tk.getImage("\\\\192.168.3.3\\공유\\경치.gif");
		
		width = img.getWidth(this);
		height = img.getHeight(this);
		
		
		
		setSize(width, height); // 윈도우의 크기
		setLocation(200, 0); // 윈도우 실행 위치 - 화면 제일 왼쪽 위.
		setVisible(true); // 윈도우 시각화

		addWindowListener(this);
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		int width = img.getWidth(this);
		int height = img.getHeight(this);
		setSize(width, height);
		
		g.drawImage(img, 0, 0, this);
		g.drawImage(pngImg, 200, 200, this);
		
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
	

}
