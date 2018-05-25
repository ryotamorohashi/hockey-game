package main;

import java.awt.*;

public class Ball {

	/* Ballの座標 */
	private int x;
	private int y;
	/* ボールの大きさ */
	private int size;
	/* ボールの速さ */
	private int speed;
	/* 当たり判定と、枠から出ない判定を出すためのフラグ*/
	private boolean LRflag;
	private boolean UDflag;
	/*スコア*/
	private int scorePlayerA;
	private int scorePlayerB;
	
	/* 得点が入った時、真ん中からスタートするためのフラグ*/
	private int restartFlag;
	
	/* コンストラクタ */
	public Ball() {
		scorePlayerA = 0;
		scorePlayerB = 0;
		x = 300;
		y = 300;
		size = 20;
		
		LRflag = true;
		UDflag = true;
		
		
	}
	
	/* 得点を取得する */
	public int getScorePlayerA() {
		return scorePlayerA;
	}
	
	public int getScorePlayerB() {
		return scorePlayerB;
	}
	
	/* 得点を取得する */
	public void setScorePlayerA(int scorePlayerA) {
		this.scorePlayerA = scorePlayerA;
	}
	
	public void setScorePlayerB(int scorePlayerB) {
		this.scorePlayerB = scorePlayerB;
	}
	
	/* ボールの移動 */
	public void moveBall(MainPanel mp) {
		speed = getSpeed();
		/* ボールが枠外に出ないようにする */
		if (x < 0) {
			LRflag = false;
		} else if(x > mp.getFrameWidth()) {
			LRflag = true;
		}
		
		if( y < 0 ) {
			UDflag = false;
		} else if ( y > mp.getFrameHeight()) {
			UDflag = true;
		}
		
		if(LRflag) {
			x -= speed;
		} else {
			x += speed;
		}
		
		if(UDflag) {
			y -= speed;
		} else {
			y += speed;
		}
	}
	
	/* 速度変更 */
	public void changeLRflag(){
		if(LRflag){
			LRflag = false;
		}else{
			LRflag = true;
		}
	}

	//ballの上下移動の変更
	public void changeUDflag(){
		if(UDflag){
			UDflag = false;
		}else{
			UDflag = true;
		}
	}
	
	public void setBallPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getSize() {
		return size;
	}
	
	/* ボールの描写 */
	public void ballGraphics(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRoundRect(x, y, size, size, 20, 20);
	}
}
