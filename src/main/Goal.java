package main;

import java.awt.*;

public class Goal {
	private double goal_a_position_x;
	private double goal_a_position_y;
	private double goal_b_position_x;
	private double goal_b_position_y;
	
	private double goalWidth;
	private double goalHeight;
	
	public Goal(MainPanel mp) {
		/* Goalの座標を決定 */
		goal_a_position_x = mp.getFrameWidth() * 1 / 10;
		goal_a_position_y = mp.getFrameHeight() * 3 / 10;
		
		goal_b_position_x = mp.getFrameWidth() * 9 / 10;
		goal_b_position_y = mp.getFrameHeight() * 3 / 10;
		
		goalWidth = 10;
		goalHeight = 150;
	}
	
	/* Goalの座標を取得する */
	public double getGoalAPositionX() {
		return goal_a_position_x;
	}
	
	public double getGoalAPositionY() {
		return goal_a_position_y;
	}
	
	public double getGoalBPositionX() {
		return goal_b_position_x;
	}
	
	public double getGoalBPositionY() {
		return goal_b_position_y;
	}
	
	public double getGoalHeight() {
		return goalHeight;
	}
	
	public double getGoalWidth() {
		return goalWidth;
	}
	
	/* goalの描写 */
	public void goalGraphics(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect((int)goal_a_position_x, (int)goal_a_position_y, (int)goalWidth, (int)goalHeight);
		g.setColor(Color.WHITE);
		g.fillRect((int)goal_b_position_x, (int)goal_b_position_y, (int)goalWidth, (int)goalHeight);
	}
}
