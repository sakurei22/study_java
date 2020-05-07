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
import main.WindowClass;

public class BaseUpdate extends JFrame implements ActionListener {
	Container contentPane;
	JTextField textField[];
	JButton selbutton, menuBtn, updateBtn;
	JLabel ulabel[];
	JTextField name;
	public BaseUpdate() {
		super("Update member");

		textField = new JTextField[3];

		// 정보 입력란
		JLabel label = new JLabel("수정");
		JLabel nameLabel = new JLabel("이름: ");
		name = new JTextField(20); // 칸
		selbutton = new JButton("선택");
		selbutton.addActionListener(this);

		JPanel panel = new JPanel();
		panel.setBackground(Color.yellow);
		panel.add(label);
		panel.add(nameLabel);
		panel.add(name);
		panel.add(selbutton);

		// 정보 출력란
		JPanel botpanel = new JPanel();
		botpanel.setLayout(null);
		ulabel = new JLabel[3];
		for (int i = 0; i < 3; i++) {
			ulabel[i] = new JLabel();
			ulabel[i].setText("미정");
			ulabel[i].setBounds(30, 50 + 40 * i, 100, 30);

			textField[i] = new JTextField();

			textField[i].setBounds(180, 50 + 40 * i, 200, 30);

			botpanel.add(ulabel[i]);
			botpanel.add(textField[i]);
		}

		menuBtn = new JButton("메뉴");
		menuBtn.setBounds(150, 320, 150, 50);
		menuBtn.addActionListener(this);
		botpanel.add(menuBtn);

		updateBtn = new JButton("수정");
		updateBtn.setBounds(320, 320, 150, 50);
		updateBtn.addActionListener(this);
		botpanel.add(updateBtn);

		setBounds(0, 0, 640, 450);
		setBackground(Color.green);

		contentPane = getContentPane();
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(botpanel, BorderLayout.CENTER);

		setBounds(0, 0, 640, 480);
		setBackground(Color.LIGHT_GRAY);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Singleton s = Singleton.getInstance();
		Human h;
		System.out.println(name.getText());
		if (selbutton == (Object) e.getSource()) {
			//JOptionPane.showMessageDialog(null, "선택");
			h = s.map.get(name.getText());
			
		//	System.out.println(h.toString()); 
			if (h instanceof Pitcher) {
				Pitcher p = (Pitcher) h;
				ulabel[0].setText("승");
				textField[0].setText(p.getWin() + "");
				ulabel[1].setText("패");
				textField[1].setText(p.getLose() + "");
				ulabel[2].setText("방어율");
				textField[2].setText(p.getDefence() + "");
			} else if(h instanceof Batter) {
				Batter b = (Batter) h;
				ulabel[0].setText("타석");
				textField[0].setText(b.getBatcount() + "");
				ulabel[1].setText("안타");
				textField[1].setText(b.getHit() + "");
				ulabel[2].setText("타율");
				textField[2].setText(b.getHitAvg() + "");
			}
		} else if (menuBtn == (Object) e.getSource()) {
			this.dispose();
			new WindowClass();

		} else if (updateBtn == (Object) e.getSource()) {
			h = s.map.get(name.getText());
			if (h instanceof Pitcher) {
				Pitcher p = (Pitcher) h;
				p.setWin(Integer.parseInt(textField[0].getText()));
				p.setLose(Integer.parseInt(textField[1].getText()));
				p.setDefence(Double.parseDouble(textField[2].getText()));
				s.map.put(p.getName(), p);
				
			}else {
				Batter b = (Batter) h;
				b.setBatcount(Integer.parseInt(textField[0].getText()));
				b.setHit(Integer.parseInt(textField[1].getText()));
				b.setHitAvg(Double.parseDouble(textField[2].getText()));
				s.map.put(b.getName(), b);
			}
			JOptionPane.showMessageDialog(null, "수정되었습니다.");
		}
		revalidate();

	}
}
