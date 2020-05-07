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
import DTO.Batter;
import DTO.Human;
import main.WindowClass;

public class PitcherPanel extends JPanel implements ActionListener{
	
	JLabel label[] = new JLabel[6];
	JTextField textField[] = new JTextField[6];
	
	JButton menuBtn, insertBtn;

	InsertView iView;
	
	public PitcherPanel(InsertView iview) {
		setLayout(null);
		this.iView = iview;
		
		String title[] = {"이름: ", "나이: ", "신장: ", "승: ", "패: ","방어율: " };
		
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
		setBackground(Color.green);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == menuBtn) {
		//	JOptionPane.showMessageDialog(null, "menuBtn");
			iView.dispose();
			new WindowClass();
			
		}else if(obj == insertBtn) {
			
			
			if(textField[0].getText().equals("")) {
				JOptionPane.showMessageDialog(null, "모두입력해주세요");
				return;
			}
			
			Singleton si = Singleton.getInstance();
			Human human = null;
			String name =	 	textField[0].getText();
			int age = 			Integer.parseInt(textField[1].getText());
			Double height = 	Double.parseDouble(textField[2].getText());
			String birth = 		textField[3].getText();
			int batcount =  	Integer.parseInt(textField[4].getText());
			int hit =  			Integer.parseInt(textField[5].getText());
			Double hitAvg = 	Double.parseDouble(textField[6].getText());
			
			human = new Batter(si.MemNumber + 1000, name, age, height, birth, batcount, hit,
					  hitAvg); 
			
			si.map.put(human.getName(), human);
			System.out.println(si.map.get(human.getName()));
			si.MemNumber++;
		}
	}
	
}
