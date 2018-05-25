package main;

import java.awt.*;
import Listener.GameKeyListener;

public class Player {
	private GameKeyListener key;
	private MainPanel mp;
	
	/* PlayerA position*/
	private double player_a_position_x;
	private double player_a_position_y;
	/* PlayerB position */
	private double player_b_position_x;
	private double player_b_position_y;
	
	/* Color */
	private static final Color PlayerAColor = Color.BLUE;
	private static final Color PlayerBColor = Color.RED;
	
	/* Playerの枠の大きさ */
	private double playerWidth;
	private double playerHeight;
	
	/* Playerの速さ */
	private double speed;
	
	/* Playerの移動制限フラグ */
	private boolean LRflagA;
	private boolean UDflagA;
	private boolean LRflagB;
	private boolean UDflagB;
	
	/* コンストラクタ */
	public Player(MainPanel mp, GameKeyListener key) {
		this.mp = mp;
		this.key = key;
		
		/* Playerの大きさ設定 */
		playerWidth = 10;
		playerHeight = 30;
		/* Playerの速さ設定 */
		speed = 20;

		/* Playerの初期値設定 */
		player_a_position_x = mp.getFrameWidth() * 2 / 10;
		player_a_position_y = mp.getFrameHeight() * 3 / 10;
		player_b_position_x = mp.getFrameWidth() * 8 / 10;
		player_b_position_y = mp.getFrameHeight() * 3 / 10;
	}
	
	/* Playerの動き */
	public void movePlayer() {
		if (key.isDownkeypressed()) {
			if(player_a_position_y > mp.getFrameHeight()) {
				player_a_position_y += 0;
			} else {
				player_a_position_y += 6;
			}
		} else if (key.isUpkeypressed()) {
			if (player_a_position_y < 0) {
				player_a_position_y -= 0;
			} else {
				player_a_position_y -= 6;
			}
		} else if (key.isRightkeypressed()) {
			if(player_a_position_x > 300) {
				player_a_position_x += 0;
			} else {
				player_a_position_x += 6;
			}
		} else if (key.isLeftkeypressed()) {
			if(player_a_position_x < 120){
				player_a_position_x -= 0;
			}else {
				player_a_position_x -= 6;
			}
		}
		
		if (key.isDownkeypressed2()) {
			if(player_b_position_y > mp.getFrameHeight()) {
				player_b_position_y += 0;
			} else {
				player_b_position_y += 6;
			}
		} else if (key.isUpkeypressed2()) {
			if (player_b_position_y < 0) {
				player_b_position_y -= 0;
			} else {
				player_b_position_y -= 6;
			}
		} else if (key.isRightkeypressed2()) {
			if(player_b_position_x > mp.getFrameWidth()-120) {
				player_b_position_x += 0;
			} else {
				player_b_position_x += 6;
			}
		}else if(key.isLeftkeypressed2()){
			if(player_b_position_x < 300) {
				player_b_position_x -= 0;
			} else {
				player_b_position_x -= 6;
			}
		}
	}
	
	/* Playerの絵画 */
	public void playerGraphics(Graphics g) {
		/*A*/
		g.setColor(PlayerAColor);
		g.fillRect((int)player_a_position_x, (int)player_a_position_y, (int)playerWidth, (int)playerHeight);
		/*B*/
		g.setColor(PlayerBColor);
		g.fillRect((int)player_b_position_x, (int)player_b_position_y, (int)playerWidth, (int)playerHeight);
	}
	
	public double getPlayerWidth() {
		return playerWidth;
	}
	
	public double getPlayerHeight() {
		return playerHeight;
	}
	
	public double getPlayerAPositionX() {
		return player_a_position_x;
	}
	
	public double getPlayerAPositionY() {
		return player_a_position_y;
	}
	
	public double getPlayerBPositionX() {
		return player_b_position_x;
	}
	
	public double getPlayerBPositionY() {
		return player_b_position_y;
	}
}
