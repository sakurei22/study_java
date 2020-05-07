package DAO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import DTO.Batter;
import DTO.Human;
import DTO.Pitcher;

public class BaseSelect extends JFrame{
Container contentPane;
JLabel lb[], lb2[];
	public BaseSelect() {
		super("선수 조회");
		
		JLabel label = new JLabel("검색");
		JLabel nameLabel = new JLabel("이름: ");
		JTextField textField = new JTextField(20); // 칸
		JButton button = new JButton("검색");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "선택");
				Singleton s = Singleton.getInstance();
				Human h = s.map.get(textField.getText());
				lb2[0].setText(h.getNumber()+"");
				lb2[1].setText(h.getName());
				lb2[2].setText(h.getAge()+"");
				lb2[3].setText(h.getBirth());
				if (h instanceof Pitcher) {
					Pitcher p = (Pitcher) h;
					lb[4].setText("승");
					lb2[4].setText(p.getWin()+"");
					lb[5].setText("패");
					lb2[5].setText(p.getLose()+"");
					lb[6].setText("방어율");
					lb2[6].setText(p.getDefence()+"");
				} else if(h instanceof Batter) {
					Batter b = (Batter) h;
					lb[4].setText("타석");
					lb2[4].setText(b.getBatcount()+"");
					lb[5].setText("안타");
					lb2[5].setText(b.getHit()+"");
					lb[6].setText("타율");
					lb2[6].setText(b.getHitAvg()+"");
				}
			}
		});

		JPanel panel = new JPanel();
		panel.setBackground(Color.yellow);
		panel.add(label);
		panel.add(nameLabel);
		panel.add(textField);
		panel.add(button);
		
		JPanel botpanel = new JPanel();
		botpanel.setLayout(null);
		lb = new JLabel[7];
		String TextTitle[] = { "이름", "나이", "신장", "생일", "미정1", "미정2", "미정3" };
		for (int i = 0; i < 7; i++) {
			lb[i] = new JLabel();
			lb[i].setBounds(50, 50 * i + 100, 100, 30);
			lb[i].setText(TextTitle[i]);
			botpanel.add(lb[i]);
		}
		
		lb2 = new JLabel[7];
		for (int i = 0; i < 7; i++) {
			lb2[i] = new JLabel();
			lb2[i].setBounds(200, 50 * i + 100, 100, 30);
			lb2[i].setText(TextTitle[i]);
			lb2[i].setBackground(Color.cyan);
			botpanel.add(lb2[i]);
		}
		
		contentPane = getContentPane();
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(botpanel, BorderLayout.CENTER);
		
		
		setSize(800, 600);
		setLocation(200, 0);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}


