package DAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DTO.Batter;
import DTO.Human;
import DTO.Pitcher;
import main.WindowClass;

public class BaseAllprint extends JFrame implements ActionListener {
	// table 써서 출력
	JTable table;
	JScrollPane scrPane;
	Object BaseData[][];
	JButton btn;

	String columNames[] = { "선수 번호", "포지션", "이름", "나이", "신장", "생일", "승/타석", "패/안타", "방어율/타율" };

	public BaseAllprint() {
		super("2. 모두 출력");
		Singleton s = Singleton.getInstance();
		BaseData = new Object[s.map.size()][columNames.length];
		int w = 0;
		Iterator<String> it = s.map.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			Human h = s.map.get(key);
			if (h instanceof Pitcher) {
				Pitcher p = (Pitcher) h;
				BaseData[w][0] = p.getNumber();
				BaseData[w][1] = "투수";
				BaseData[w][2] = p.getName();
				BaseData[w][3] = p.getAge();
				BaseData[w][4] = p.getHeight();
				BaseData[w][5] = p.getBirth();
				BaseData[w][6] = p.getWin();
				BaseData[w][7] = p.getLose();
				BaseData[w][8] = p.getDefence();
				w++;
			} else {
				Batter b = (Batter) h;
				BaseData[w][0] = b.getNumber();
				BaseData[w][1] = "타자";
				BaseData[w][2] = b.getName();
				BaseData[w][3] = b.getAge();
				BaseData[w][4] = b.getHeight();
				BaseData[w][5] = b.getBirth();
				BaseData[w][6] = b.getBatcount();
				BaseData[w][7] = b.getHit();
				BaseData[w][8] = b.getHitAvg();
				w++;
			}

		}
		
		setLayout(null);

		JLabel label = new JLabel("선수 명단");
		label.setBounds(10, 10, 200, 30);
		add(label);

		table = new JTable(BaseData, columNames);
		scrPane = new JScrollPane(table);
		scrPane.setBounds(10, 50, 600, 300);
		add(scrPane);

	
		btn = new JButton("메뉴로");
		btn.setBounds(50, 500, 120, 50);
		btn.addActionListener(this);
		add(btn);
		
		setSize(800, 600);
		setLocation(200, 0);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == btn) {
			this.dispose();
			new WindowClass();
		}
	}
}