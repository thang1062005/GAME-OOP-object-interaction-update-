package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.Gamepanel;

public class Superobject {
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int worldx, worldy;
	public Rectangle solidarea = new Rectangle(0,0,48,48);
	public int sdefaultx = 0;
	public int sdefaulty = 0;
	
	public void draw(Graphics2D g2, Gamepanel gp) {
		
	
		int screenx1 = worldx - gp.player.worldx + gp.player.screenx;
		int screeny1 = worldy - gp.player.worldy + gp.player.screeny;
		
		if (worldx>gp.player.worldx-gp.player.screenx&& worldx <gp.player.worldx+gp.player.screenx &&
				worldy <gp.player.worldy+gp.player.screeny&&worldy <gp.player.worldy+gp.player.screeny) {
			
			g2.drawImage(image, screenx1, screeny1,gp.tilesize,gp.tilesize,null);
		}
		
		
	}

}
