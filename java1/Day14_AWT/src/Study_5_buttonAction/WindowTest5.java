package Study_5_buttonAction;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowTest5 extends Frame implements WindowListener{//, ActionListener{
																	//액션을 캐치하는 클래스
	Label label;
	Button btn1, btn2;
	
	public WindowTest5() {
		super("간단한 예제");
		
		setLayout(null);
		/*
		 	resource(자원) : button, panel, text field -> Handle(번호)
		 */
		label = new Label("레이블");
		label.setBounds(100, 100, 300, 30);
		add(label);
		/*
		btn1 = new Button("버튼 one");
		btn1.setBounds(100, 160, 150, 30);
		btn1.addActionListener(this);
		add(btn1);
		
		btn2 = new Button("버튼 two");
		btn2.setBounds(300, 160, 150, 30);
		btn2.addActionListener(this);
		add(btn2);
		*/
		
		// 버튼이 한개일 경우
		// 생성된 버튼 안에서 ActionListener를 생성하는 게 보기 편함
		btn1 = new Button("버튼 one");
		btn1.setBounds(100, 160, 150, 30);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText("one 버튼이 클릭!!");
				
			}
		});
		add(btn1);
		
		
		setSize(640, 480);	// 윈도우의 크기
		setLocation(200, 0);	// 윈도우 실행 위치 - 화면 제일 왼쪽 위. 
		setVisible(true);	// 윈도우 시각화
		
		addWindowListener(this);
	}
	
	

	
/*	public void actionPerformed(ActionEvent e) {
//		JOptionPane.showMessageDialog(null, "버튼클릭");
		Button btn = (Button)e.getSource();
		String btnTitle = btn.getLabel();	//버튼의 타이틀값 얻어옴
		
		if(btnTitle.equals("버튼 one")) {
			label.setText("one 버튼이 클릭되었습니다.");
		}else if(btnTitle.equals("버튼 two")) {
			label.setText("two 버튼이 클릭되었습니다.");
		}
		
	}
*/


	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
		System.exit(0);
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
