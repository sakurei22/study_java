package awt_teacher;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DAO.Singleton;
import DTO.Pitcher;
import main.WindowClass;

public class UpdatePitPanel extends JPanel implements ActionListener{
	JLabel label[] = new JLabel[3];
	JTextField textField[] = new JTextField[3];
	
	JButton menuBtn, updateBtn;
	
	String name;
	Pitcher pit;
	UpdateView uview;
	
	public UpdatePitPanel(String name, UpdateView uview) {
		this.name = name;
		this.uview = uview;
		Singleton s = Singleton.getInstance();
		pit = (Pitcher)s.map.get(name);
		
		setLayout(null);
		String title[] = {"승: ", "패: ","방어율: " };
		String data[] = { pit.getWin()+"", pit.getLose()+"", pit.getDefence()+"" };
		
		
		for (int i = 0; i < title.length; i++) {
			label[i] = new JLabel();
			label[i].setText(title[i]);
			label[i].setBounds(30, 50+40*i, 100, 30);
			
			textField[i] = new JTextField();
			textField[i].setText(data[i]);
			textField[i].setBounds(180, 50+40*i, 200, 30);
			
			add(label[i]);
			add(textField[i]);
		}
		
		menuBtn = new JButton("메뉴");
		menuBtn.setBounds(150, 320, 150, 50);
		menuBtn.addActionListener(this);
		add(menuBtn);
		
		updateBtn = new JButton("수정");
		updateBtn.setBounds(320, 320, 150, 50);
		updateBtn.addActionListener(this);
		add(updateBtn);
		
		setBounds(0, 0, 640, 450);
		setBackground(Color.green);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(menuBtn == (Object)e.getSource()) {
			uview.dispose();
			new WindowClass();
		}
		else if(updateBtn == (Object)e.getSource()) {
			pit.setWin(Integer.parseInt(textField[0].getText()));
			pit.setLose(Integer.parseInt(textField[1].getText()));
			pit.setDefence(Double.parseDouble(textField[2].getText()));
			
			Singleton s = Singleton.getInstance();
			s.map.put(name, pit);
			JOptionPane.showMessageDialog(null, "수정되었습니다.");
		}
	}
}
