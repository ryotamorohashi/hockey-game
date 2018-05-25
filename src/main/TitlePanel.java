package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TitlePanel extends JPanel {
	private int frameWidth = 600;
	private int frameHeight = 600;
	
	private MainFrame mf;
	JPanel bp = new JPanel();
	JButton btn1 = new JButton("簡単");
	JButton btn2 = new JButton("難しい");
	private int DefaultSpeed;
	/* 勝利者の名前を出す */
	private String FinishWord;
	JLabel FinishWordLabel = new JLabel();
	
	TitlePanel(MainFrame mf){
		this.mf = mf;
		MainPanel mp = new MainPanel(mf);
		
		btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            		setDefaultSpeed(5);
            		panelChangeToGame();
            }
        });
		
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultSpeed(20);
				panelChangeToGame();
			}
		});
		setBounds(10, 10, frameWidth, frameHeight);
		
		add(btn1);
		add(btn2);
		
		add(FinishWordLabel);	
		System.out.println(getFinishWord());
		System.out.println(FinishWord);
		
		setVisible(true);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
	
	public void panelChangeToGame() {
		mf.showMainPanel((JPanel)this);
	}
	
	public void setDefaultSpeed(int default_speed) {
		this.DefaultSpeed = default_speed;
	}
	
	public int getDefaultSpeed() {
		return DefaultSpeed;
	}	
	
	public void setFinishWord(String finish_word) {
		this.FinishWord = finish_word;
	}
	
	public String getFinishWord() {
		return FinishWord;
	}
	
	public void setFinishWordLabel(String finish_word) {
		FinishWordLabel.setText(FinishWord);
	}
}
