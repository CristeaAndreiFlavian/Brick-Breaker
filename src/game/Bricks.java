package game;

import java.awt.Color;
import java.awt.Graphics;
import org.lggl.graphics.Window;
import org.lggl.graphics.objects.Rectangle;

public class Bricks extends Rectangle {
	boolean[][] bricks = new boolean[13][10];

	public Bricks() {
		for (int x = 0; x < bricks.length; x++) {
			for (int y = 0; y < bricks[0].length; y++) {
				bricks[x][y] = true;
			}
		}
	}

	public void paint(Graphics g, Window src) {
		for (int x = 0; x < bricks.length; x++) {
			for (int y = 0; y < bricks[0].length; y++) {
				if (bricks[x][y] == true) {
					g.setColor(Color.RED);
					g.fillRect(x * 50, y * 10, 50, 20);
				}
			}
		}
		if (this.isColliding(Main.ball)) {
			int bx = Main.ball.getX() / 50;
			int by = Main.ball.getY() / 10 - 1;
			try {
				bricks[bx][by] = false;
				Main.goUp = false;
				Main.goDown = true;
			} catch (Exception e) {
				//System.out.println("work");
			}
		}
	}
}
