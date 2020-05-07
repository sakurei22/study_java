package awt_teacher;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.WindowClass;

public class BatterPanel extends JPanel implements ActionListener{
	InsertView iView;
	JLabel label[] = new JLabel[6];
	JTextField textField[] = new JTextField[6];
	
	JButton menuBtn, insertBtn;
	
	public BatterPanel(InsertView iview) {
			
		setLayout(null);
		this.iView = iview;
		
		String title[] = {"이름: ", "나이: ", "신장: ", "타수: ", "안타: ","타율: " };
		
		for (int i = 0; i < title.length; i++) {
			label[i] = new JLabel();
			label[i].setText(title[i]);
			label[i].setBounds(30, 50+40*i, 100, 30);
			
			textField[i] = new JTextField();
			textField[i].setBounds(180, 50+40*i, 200, 30);
			
			add(label[i]);
			add(textField[i]);
		}
		
		menuBtn = new JButton("메뉴");
		menuBtn.setBounds(150, 320, 150, 50);
		menuBtn.addActionListener(this);
		add(menuBtn);
		
		insertBtn = new JButton("추가");
		insertBtn.setBounds(320, 320, 150, 50);
		insertBtn.addActionListener(this);
		add(insertBtn);
		
		setBounds(0, 0, 640, 450);
		setBackground(Color.CYAN);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == menuBtn) {
		//	JOptionPane.showMessageDialog(null, "menuBtn");
			iView.dispose();
			new WindowClass();
			
		}
	}
}
