package game;

import org.lggl.graphics.objects.Oval;
import org.lggl.graphics.objects.Rectangle;
import org.lggl.input.Keyboard;
import org.lggl.game.SimpleGame;
import org.lggl.graphics.Window;
import java.awt.Color;
import java.util.Random;

  //@SuppressWarnings("unused")
  public class Main extends SimpleGame {
  protected static final int BALL_SPEED = 3;
  public static boolean goRight = false;
  public static boolean goLeft = false;
  public static boolean goUp = false;
  public static boolean goDown = true;
  public static Oval ball = new Oval(310, 200, 15, 15, Color.YELLOW); 
  //Oval ball = new Oval(310, 200, 15, 15, Color.YELLOW); 
  Rectangle slider = new Rectangle(310, 400, 100, 4, Color.GREEN);
  public static void main(String[] args) {
    new Main().start();
  }

  public void update(Window win) {
	@SuppressWarnings("unused")
	Bricks brick = new Bricks();
	if (win.getKeyboard().isKeyDown(Keyboard.KEY_D)) {
		slider.setX(slider.getX() + 5);
	}
	if (win.getKeyboard().isKeyDown(Keyboard.KEY_A)) {
		slider.setX(slider.getX() - 5);
	}
	if (slider.getX() >= 510) {
		slider.setX(510);
	}
	if (slider.getX() < 0) {
		slider.setX(0);
	}
	win.setViewport(0, 0, win.getWidth(), win.getHeight());
    if (win.isClosed()) {
      System.exit(0);
    }
  }

  public void init(Window win) {
	Bricks brick = new Bricks();
	win.add(brick);
	brick.setWidth(620);
	brick.setHeight(200);
	//brick.setColor(Color.BLACK);
	ball.setFilled(true);
    win.setTitle("Brick Breaker");
    win.setSize(620, 480);
    win.setResizable(false);
    win.getEventThread().runAlways(new Runnable() {
    	public void run() {
    		if (goLeft) {
    			ball.setX(ball.getX() - BALL_SPEED);
    			}
    			if (goDown) {
    			ball.setY(ball.getY() + BALL_SPEED);
    			}
    			if (goUp) {
    			ball.setY(ball.getY() - BALL_SPEED);
    			}
    			if (goRight) {
    			ball.setX(ball.getX() + BALL_SPEED);
    			}
    			if (ball.getX() < 0) {
    				goRight = true;
    				goLeft = false;
    			}
    			if (ball.getX() > 620) {
    				goRight = false;
    				goLeft = true;
    			}
    			if (ball.getY() < 1) {
    				goUp = false;
    				goDown = true;
    			}
    			if (ball.isColliding(slider)) {
    				goLeft = false;
    				goRight = false;
    				goUp = true;
    				goDown = false;
    				Random r = new java.util.Random();
    						boolean left = r.nextBoolean();
    						if (left) {
    						goLeft = true;
    						}
    						else {
    						goRight = true;
    				}
    		}
    	}
    });
    win.add(ball);
    win.add(slider);
  }

}