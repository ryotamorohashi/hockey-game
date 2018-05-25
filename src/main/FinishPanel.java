package main;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FinishPanel extends JPanel {
	private int frameWidth = 600;
	private int frameHeight = 600;
		
	private MainFrame mf;
	private MainPanel mp;
	JPanel bp = new JPanel();
	JButton btn = new JButton("スタートに戻る");
	
//	TextField txt1 = new TextField(mp.getFinishWord());
	
	FinishPanel(MainFrame mf){
		this.mf = mf;
		
		btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            		panelChangeToTitle();
            }
        });
		setBounds(10, 10, frameWidth, frameHeight);
		add(btn);
		setVisible(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
	}
	
	public void panelChangeToTitle() {
		mf.showTitlePanel((JPanel)this);
	}
}
