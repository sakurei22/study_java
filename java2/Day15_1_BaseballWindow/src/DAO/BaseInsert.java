package DAO;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import DTO.Batter;
import DTO.Human;
import DTO.Pitcher;
import main.WindowClass;

public class BaseInsert extends JFrame implements ActionListener{
	// 텍스트필드. 입력버튼.
	// 선수입력.
	private int MemNumber;
	JTextField tf[];
	JButton btn1, btn2, btn3, btn4;
	JLabel lb[], plb[], blb[];

	public BaseInsert() {
		super("1. 선수 입력");
		MemNumber = 1000;
		
		Singleton si = Singleton.getInstance();
		if(si.map.size() > 0) {
			MemNumber = si.MemNumber;
		}

		// 투수 타자 선택
		btn1 = new JButton("1. 투수 입력");
		btn1.setBounds(50, 50, 120, 50);
		btn1.addActionListener(this);
		add(btn1);

		btn2 = new JButton("2. 타자 입력");
		btn2.setBounds(200, 50, 120, 50);
		btn2.addActionListener(this);
		add(btn2);

		// 메뉴로
		btn3 = new JButton("3. 메뉴로");
		btn3.setBounds(50, 500, 120, 50);
		btn3.addActionListener(this);
		add(btn3);
		
		// 선수 입력
		btn4 = new JButton("4. 선수 입력");
		btn4.setBounds(200, 500, 120, 50);
		btn4.addActionListener(this);
		add(btn4);
		
		// 제목
		lb = new JLabel[7];
		String TextTitle[] = { "이름", "나이", "신장", "생일", "미정1", "미정2", "미정3" };
		for (int i = 0; i < 7; i++) {
			lb[i] = new JLabel();
			lb[i].setBounds(50, 50 * i + 100, 100, 30);
			lb[i].setText(TextTitle[i]);
			add(lb[i]);
		}
		// 입력
		tf = new JTextField[7];
		for (int i = 0; i < 7; i++) {

			tf[i] = new JTextField();
			tf[i].setBounds(200, 50 * i + 100, 100, 30);
			tf[i].setBackground(Color.LIGHT_GRAY);
			add(tf[i]);
		}

		setLayout(null);
		setSize(800, 600);
		setLocation(200, 0);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 1.투수 2.타자 선택 후 출력 메세지 바뀜
		plb = new JLabel[3];
		String p_TextTitle[] = { "승", "패", "방어율" };
		blb = new JLabel[3];
		String b_TextTitle[] = { "타석", "안타", "타율" };

		JButton btn = (JButton) e.getSource();
		String btnTitle1 = btn.getLabel();
		Human human = null;

		if (btnTitle1.equals("1. 투수 입력")) {
			for (int i = 0; i < 3; i++) {
				lb[i + 4].setText(p_TextTitle[i]);
				}
			
		}else if (btnTitle1.equals("2. 타자 입력")) {
			
			for (int i = 0; i < 3; i++) {
				lb[i + 4].setText(b_TextTitle[i]);
			}
			
		}else if(btnTitle1.equals("3. 메뉴로")) {
			dispose();
			new WindowClass();
			
		}else if(btnTitle1.equals("4. 선수 입력")) {
			//String contains 승
			if(lb[4].getText().equals("승")) {
				String name =	 	tf[0].getText();
				int age = 			Integer.parseInt(tf[1].getText());
				Double height = 	Double.parseDouble(tf[2].getText());
				String birth = 		tf[3].getText();
				int win =  			Integer.parseInt(tf[4].getText());
				int lose =  		Integer.parseInt(tf[5].getText());
				Double defence = 	Double.parseDouble(tf[6].getText());
				
				human = new Pitcher(MemNumber, name, age, height, birth, win, lose, defence);
				
				
			}else if(lb[4].getText().equals("타석")) {
			//String contains 타석
				String name =	 	tf[0].getText();
				int age = 			Integer.parseInt(tf[1].getText());
				Double height = 	Double.parseDouble(tf[2].getText());
				String birth = 		tf[3].getText();
				int batcount =  		Integer.parseInt(tf[4].getText());
				int hit =  			Integer.parseInt(tf[5].getText());
				Double hitAvg = 	Double.parseDouble(tf[6].getText());
				human = new Batter(MemNumber + 1000, name, age, height, birth, batcount, hit,
						  hitAvg); 	
			}
			Singleton si = Singleton.getInstance();
			si.map.put(tf[0].getText(), human);
			System.out.println(si.map.get(tf[0].getText()));
			MemNumber++;
		}
	}
}
