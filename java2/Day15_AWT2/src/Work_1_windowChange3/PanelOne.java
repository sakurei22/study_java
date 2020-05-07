package Work_1_windowChange3;

import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOne extends Panel {
	public PanelOne() {
	
		Panel pn = new Panel();
		pn.setBackground(Color.green);
		pn.setSize(640, 480);
		
		Button btn = new Button();
		
		btn = new Button("move win2");
		btn.setBounds(100, 100, 100, 30);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PanelTwo pn2 = new PanelTwo();
				add(pn2);
				
				
			}
		});
		pn.add(btn);
	}
}
