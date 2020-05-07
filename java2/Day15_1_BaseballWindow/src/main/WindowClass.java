package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import DAO.BaseAllprint;
import DAO.BaseDelete;
import DAO.BaseInsert;
import DAO.BaseSelect;
import DAO.BaseSorting;
import DAO.BaseUpdate;
import DAO.Singleton;
import awt_teacher.AllprintView;
import awt_teacher.InsertView;
import awt_teacher.UpdateView;
import file.DataFile;

public class WindowClass extends JFrame implements ActionListener {
	JButton button[]; 
	
	
	public WindowClass() {	// 메뉴
		super("야구 선수 메니저");
		setLayout(null);			// 큰메뉴 null, 패널 null인 경우 동작x 둘 중 하나만 nullS
		
		button = new JButton[7];
		String btnTitle[] = { "1. 선수 추가", "2. 모두 출력", "3. 선수 조회",
								"4. 선수 삭제", "5. 선수 수정", "6. 선수 정렬",
								"7. 파일 저장"};
		
		for (int i = 0; i < btnTitle.length; i++) {
			button[i] = new JButton();
			button[i].setBounds(50, 60* i, 200, 50);
			button[i].setLabel(btnTitle[i]);
			button[i].addActionListener(this);
			add(button[i]);		
		}		 

		setSize(800, 600); 
		setLocation(300, 0); 
		setVisible(true); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		String btnTitle = btn.getLabel();
		
		if(btnTitle.equals("1. 선수 추가")) {
		
			new BaseInsert();
			//new InsertView();
		}
		else if(btnTitle.equals("2. 모두 출력")) {
			new BaseAllprint();
			//new AllprintView();
		} 
		else if(btnTitle.equals("3. 선수 조회")) {
			
			new BaseSelect();
		} 
		else if(btnTitle.equals("4. 선수 삭제")) {
			
			new BaseDelete();
		} 
		else if(btnTitle.equals("5. 선수 수정")) {
			//new UpdateView();
			new BaseUpdate();
		} 
		else if(btnTitle.equals("6. 선수 정렬")) {
			
			new BaseSorting();
		} 
		else if(btnTitle.equals("7. 파일 저장")) {
			Singleton s = Singleton.getInstance();
			s.dataCls.writeFile();
			new WindowClass();
		} 
		this.dispose();
		
		/*
		   Object obj = e.getSource();
		   if(obj == button[0]	{
		   }else if (obj == button[1]){
		   } ....
		  
		 */
	}
}
