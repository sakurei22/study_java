package Study_4_Panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

public class MyPanel extends Panel {
	public MyPanel() {
		setLayout(new GridLayout(3,1));
		setBackground(Color.yellow);
		
		Label l1 = new Label("MyPanel label1");
		Label l2 = new Label("MyPanel label1");
		Label l3 = new Label("MyPanel label1");
		
		add(l1);
		add(l2);
		add(l3);
	}
}
