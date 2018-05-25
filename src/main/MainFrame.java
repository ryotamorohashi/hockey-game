package main;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
	private int frameWidth;
	private int frameHeight;
	/* ボールの速さ */
	private int ballSpeed;
	
	/* 勝った方の名前 */
	private String FinishWord;
	
	
	TitlePanel tp = new TitlePanel(this);
	MainPanel mp = new MainPanel(this);
	FinishPanel fp = new FinishPanel(this);

	MainFrame(){
		frameWidth = 600;
		frameHeight = 600;
		add(tp);
		add(mp);
//		add(fp);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, frameWidth, frameHeight);
		setVisible(true);
	}

	public void run() {
		while(true) {
			try {
				mp.run();
				mp.repaint();
				Thread.sleep(1000/30);	
			} catch (Exception e){
				
			}
		}
	}
	
	public int getFrameWidth() {
		return frameWidth;
	}
	
	public int getFrameHeight() {
		return frameHeight;
	}
	
	/* mainPanelを見せるためのメソッド now = tp*/
	public void showMainPanel(JPanel nowPanel) {
		nowPanel.setVisible(false);
		fp.setVisible(false);
		mp.setVisible(true);
	}
	
	/* finishPanelを見せるためのメソッド now = mp*/
	public void showFinishPanel(JPanel nowPanel) {
		nowPanel.setVisible(false);
		tp.setVisible(false);
		fp.setVisible(true);
	}
	
	/* titlePanelを見せるためのメソッド now = fp*/
	public void showTitlePanel(JPanel nowPanel) {
		nowPanel.setVisible(false);
//		fp.setVisible(false);
		tp.setVisible(true);
		mp.setZeroTotalScoreA();
		mp.setZeroTotalScoreB();
		tp.setDefaultSpeed(0);
		tp.setFinishWordLabel(tp.getFinishWord());
	}
	
	public int getBallSpeed() {
		ballSpeed = tp.getDefaultSpeed();
		return ballSpeed;
	}
	
	public void setFinishWord(String finish_word) {
		this.FinishWord = finish_word;
		tp.setFinishWord(finish_word);
	}
	
	public String getFinishWord() {
		return FinishWord;
	}
}
