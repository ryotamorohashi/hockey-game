package main;
import Listener.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class MainPanel extends JPanel{
	private double frameWidth = 550;
	private double frameHeight = 550;
	private Goal goal;
	private Ball ball;
	private Player player;
	private GameKeyListener gkl;
	
	private MainFrame mf;
	private TitlePanel tp;
	
	public String FinishWord;
	
	/* PLAYERの得点換算 */
	public Integer TotalScoreA = 0;
	public Integer TotalScoreB = 0;
	
	/* 画面表示用のlabel */
	JLabel AScore = new JLabel();
	JLabel BScore = new JLabel();
	
	/* ゲーム終了の得点 */
	private int WinScore = 3;
	
	private int speed;
	
	MainPanel(MainFrame mf) {
		FinishWord = "";
		setBackground(Color.BLACK);
		this.mf = mf;
		gkl = new GameKeyListener();
		mf.addKeyListener(gkl);
		player = new Player(this, gkl);
		goal = new Goal(this);
		ball = new Ball();
		
		AScore.setForeground(Color.WHITE);
		BScore.setForeground(Color.WHITE);
		LineBorder border = new LineBorder(Color.RED, 10, true);
		setBorder(border);
		add(AScore);
		add(BScore);
		setVisible(false);
	}

	public void run() {
		player.movePlayer();
		ball.setSpeed(getSpeed());
		ball.moveBall(this);

		AScore.setText(TotalScoreA.toString());
		BScore.setText(TotalScoreB.toString());
		
		/* ボールとPlayerAの衝突 */
		if (Hit.isHit(ball.getX(), 
				ball.getY(), 
				ball.getX() + ball.getSize(), 
				ball.getY() + ball.getSize(),
				(int) player.getPlayerAPositionX(),
				(int) player.getPlayerAPositionY(),
				(int) player.getPlayerAPositionX() + (int) player.getPlayerWidth(),
				(int) player.getPlayerAPositionY() + (int) player.getPlayerHeight())) {
			ball.changeLRflag();
		}
		
		/* ボールとPlayerBの衝突 */
		if (Hit.isHit(ball.getX(), 
				ball.getY(), 
				ball.getX() + ball.getSize(), 
				ball.getY() + ball.getSize(),
				(int) player.getPlayerBPositionX(),
				(int) player.getPlayerBPositionY(),
				(int) player.getPlayerBPositionX() + (int) player.getPlayerWidth(),
				(int) player.getPlayerBPositionY() + (int) player.getPlayerHeight())) {
			ball.changeLRflag();
		}
		
		/* ボールとゴールAの衝突 */
		if(Hit.isHit(ball.getX(),
				ball.getY(),
				ball.getX() + ball.getSize(),
				ball.getY() + ball.getSize(),
				(int) goal.getGoalAPositionX(),
				(int) goal.getGoalAPositionY(),
				(int) goal.getGoalAPositionX() + (int) goal.getGoalWidth(),
				(int) goal.getGoalAPositionY() + (int) goal.getGoalHeight())) {
			TotalScoreA++;
			System.out.println("トータルスコアA=" + TotalScoreA);
			ball.setBallPosition(300, 300);
		}
		
		/* ボールとゴールBの衝突 */
		if(Hit.isHit(ball.getX(),
				ball.getY(),
				ball.getX() + ball.getSize(),
				ball.getY() + ball.getSize(),
				(int) goal.getGoalBPositionX(),
				(int) goal.getGoalBPositionY(),
				(int) goal.getGoalBPositionX() + (int) goal.getGoalWidth(),
				(int) goal.getGoalBPositionY() + (int) goal.getGoalHeight())) {
			TotalScoreB++;
			System.out.println("トータルスコアB=" + TotalScoreB);
			ball.setBallPosition(300, 300);
		}
		
		if(TotalScoreA == WinScore) {
			mf.setFinishWord("チームBの勝利です");
			panelChangeToFinish();
		} else if(TotalScoreB == WinScore) {
			mf.setFinishWord("チームAの勝利です");
			panelChangeToFinish();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.WHITE);
		goal.goalGraphics(g);
		ball.ballGraphics(g);
		player.playerGraphics(g);
	}
	
	public int getFrameWidth() {
		return (int) frameWidth;
	}
	
	public int getFrameHeight() {
		return (int) frameHeight;
	}
	
	public int getTotalScoreA() {
		return TotalScoreA++;
	}
	
	public int getTotalScoreB() {
		return TotalScoreB++;
	}
	
	public void setZeroTotalScoreA() {
	    this.TotalScoreA = 0;
	}
	
	public void setZeroTotalScoreB() {
		 this.TotalScoreB = 0;
	}
	
//	public void setFinishWord(String FinishWord) {
//		this.FinishWord = FinishWord;
//	}
	
	public String getFinishWord() {
		return FinishWord;
	}
	
	public void panelChangeToFinish() {
		mf.showTitlePanel((JPanel)this);
	}
	
	public int getSpeed() {
		speed = mf.getBallSpeed();
		return speed;
	}
}
