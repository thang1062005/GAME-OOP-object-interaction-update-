package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

// parent class
public class Entity {
	public int worldx, worldy;
	public int x,y;
	public int speed;
	public BufferedImage up1,up2,down1, down2, left1, left2, right1,right2;
    public String direction;
    public int spritecounter =0;
    public int spritenum = 1;
    public Rectangle solidarea;
    public int sadefaultx, sadefaulty ;
    public boolean collisionon = false;
}    
