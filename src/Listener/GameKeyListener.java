package Listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener{

	//PlayerAのキー
	private static final int UP_Key = KeyEvent.VK_W; //上
	private static final int DOWN_Key = KeyEvent.VK_S; //下
	private static final int RIGHT_Key = KeyEvent.VK_D; //右
	private static final int LEFT_Key = KeyEvent.VK_A; //左

	//PlayerBのキー
	private static final int UP2_Key = KeyEvent.VK_I;//上
	private static final int DOWN2_Key = KeyEvent.VK_K;//下
	private static final int RIGHT2_Key = KeyEvent.VK_L; //右
	private static final int LEFT2_Key = KeyEvent.VK_J;//左
	
	//PlayerAの玉発車ボタン
	private static final int AShootingKey = KeyEvent.VK_X;//発車用
	
	//PlayerBの玉発車ボタン
	private static final int BShootingKey = KeyEvent.VK_M;//発車用

	//Keyの入力状態を保持する
	private boolean upkeypressed;
	private boolean downkeypressed;
	private boolean rightkeypressed;
	private boolean leftkeypressed;
	private boolean upkeypressed2;
	private boolean downkeypressed2;
	private boolean rightkeypressed2;
	private boolean leftkeypressed2;
	
	private boolean a_shooting_key_pressed;
	private boolean b_shooting_key_pressed;

	public GameKeyListener() {
		//初期値は押されていないFalse
		upkeypressed = false;
		downkeypressed = false;
		rightkeypressed = false;
		leftkeypressed = false;

		upkeypressed2 = false;
		downkeypressed2 = false;
		rightkeypressed2 = false;
		leftkeypressed2 = false;
		
		a_shooting_key_pressed = false;
		b_shooting_key_pressed = false;
	}

	@Override//キーを押したときの処理
	public void keyTyped(KeyEvent e) {

	}

	@Override//キーを押しているときの処理
	public void keyPressed(KeyEvent e) {

		//キーが押されている間はキーを入力されているに変更する。
		if(e.getKeyCode() == UP_Key){
			upkeypressed = true;
		}else if(e.getKeyCode() == DOWN_Key){
			downkeypressed = true;
		}else if(e.getKeyCode() == RIGHT_Key) {
			rightkeypressed = true;
		}else if(e.getKeyCode() == LEFT_Key) {
			leftkeypressed = true;
		}

		if(e.getKeyCode() == UP2_Key){
			upkeypressed2 = true;
		}else if(e.getKeyCode() == DOWN2_Key){
			downkeypressed2 = true;
		}else if(e.getKeyCode() == RIGHT2_Key) {
			rightkeypressed2 = true;
		}else if(e.getKeyCode() == LEFT2_Key) {
			leftkeypressed2 = true;
		}
		
		//発車キーを押した時は玉消えない限りtrueにする
		if(e.getKeyCode() == AShootingKey) {
			a_shooting_key_pressed = true;
		}
		if(e.getKeyCode() == BShootingKey) {
			b_shooting_key_pressed = true;
		}
	}

	@Override//キーを離したときの処理
	public void keyReleased(KeyEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		//キー入力が離れた時に、キー入力されていないと変更する。
		if(e.getKeyCode() == UP_Key){
			upkeypressed = false;
		}else if(e.getKeyCode() == DOWN_Key){
			downkeypressed = false;
		}else if(e.getKeyCode() == RIGHT_Key) {
			rightkeypressed = false;
		}else if(e.getKeyCode() == LEFT_Key) {
			leftkeypressed = false;
		}

		if(e.getKeyCode() == UP2_Key){
			upkeypressed2 = false;
		}else if(e.getKeyCode() == DOWN2_Key){
			downkeypressed2 = false;
		}else if(e.getKeyCode() == RIGHT2_Key) {
			rightkeypressed2 = false;
		}else if(e.getKeyCode() == LEFT2_Key) {
			leftkeypressed2 = false;
		}

	}


	//PlayerAの下への入力がされているかを取得する
	public boolean isDownkeypressed() {
		return downkeypressed;
	}

	//PlayerAの上への入力がされているかを取得する
	public boolean isUpkeypressed() {
		return upkeypressed;
	}
	
	//PlayerAの右入力がされているかを取得する
	public boolean isRightkeypressed() {
		return rightkeypressed;
	}
	//PlayerAの左入力がされているかを取得する
	public boolean isLeftkeypressed() {
		return leftkeypressed;
	}
	
	//PlayerBの下への入力がされているかを取得する
	public boolean isDownkeypressed2() {
		return downkeypressed2;
	}
	//PlayerBの上への入力がされているかを取得する
	public boolean isUpkeypressed2() {
		return upkeypressed2;
	}
	
	//PlayerAの右入力がされているかを取得する
	public boolean isRightkeypressed2() {
		return rightkeypressed2;
	}
	
	//PlayerAの左入力がされているかを取得する
	public boolean isLeftkeypressed2() {
		return leftkeypressed2;
	}
	
	public boolean isAShootingkeypressed() {
		return a_shooting_key_pressed;
	}
	
	public boolean isBShootingkeypressed() {
		return b_shooting_key_pressed;
	}

}

