package Work_1_windowChange3;

import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelTwo extends Panel {
	public PanelTwo() {
	
		Panel pn2 = new Panel();
		pn2.setBackground(Color.blue);
		pn2.setSize(640, 480);
		
		Button btn = new Button();
		
		btn = new Button("move win2");
		btn.setBounds(100, 100, 100, 30);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelOne pn = new PanelOne();
				add(pn);
				
				
			}
		});
		pn2.add(btn);
	}
}
