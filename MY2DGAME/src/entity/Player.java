package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Gamepanel;
import main.Keyhandler;

public class Player extends Entity {
	Gamepanel gp;
	Keyhandler keyH;
	public final int screenx; // position of camera
	public final int screeny;
	int haskey = 0; // so luong vat pham
	public Player(Gamepanel gp, Keyhandler keyH ) {
		this.gp = gp;
		this.keyH = keyH;
		
		// screenwidth là độ rộng màn hình
		// screenheight là độ cao màn hình
		screenx = gp.screenwidth/2-(gp.tilesize/2);
		screeny = gp.screenheight/2-(gp.tilesize/2);
		
		
		solidarea = new Rectangle();
		solidarea.x = 8;
		solidarea.y = 16;
		sadefaultx =solidarea.x; // default, vì sẽ thay đổi solidareax sau
		sadefaulty = solidarea.y;
		
		solidarea.width = 32;
		solidarea.height = 32;
		setdefaultval();
		getPlayerImage();
	}
	public void setdefaultval() {
		worldx = gp.tilesize*23; // not screen posi, its the world map
		worldy = gp.tilesize*21;// the starting position
		speed = 4;
		direction= "down";
	}
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/penup1.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/penup2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/pendown1.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/pendown1.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/penright1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/penright2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/penleft1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/penleft2.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	// update method get call 60times per sec
	public void update() {
		if (keyH.upPressed== true||keyH.downPressed== true||keyH.leftPressed== true||keyH.rightPressed== true) {
			if (keyH.upPressed == true) {
				direction = "up";
			}
			else if (keyH.downPressed== true) {
				direction = "down";
			}	
			else if (keyH.leftPressed == true) {
				direction = "left";
				
			}
			else if (keyH.rightPressed == true) {
				direction = "right";
				
			}
			// check tile collision
			collisionon = false;
			gp.ccheck.checkTile(this);
			
			// object collision
	
			int objid = gp.ccheck.checkobj(this, true);
			pickobj(objid);
			if (collisionon==false) {
				switch(direction) {
				case "up":
					worldy -= speed;
					break;
				case "down":
					worldy += speed;
					break;
				case "left":
					worldx -= speed;
					break;
				case "right":
					worldx += speed;
					break;
				}
			}
			}
		    
			spritecounter ++;
			if (spritecounter >15) {
				if (spritenum==1) {
					spritenum = 2;
				}
				else if (spritenum==2) {
					spritenum =1;
				}
				spritecounter =0;
			}
		}
	public void pickobj(int i) {	
		if (i != 999) {
			String objname = gp.obj[i].name;
			switch(objname) {
			case "Key":
				haskey ++;
				gp.obj[i]= null;
				System.out.println("Key:"+haskey);
				break;
			case "Door":
				if (haskey >0) {
					gp.obj[i]= null;
					haskey --;
				}
				System.out.println("Key:"+haskey);
				break;
				
			}
		}
	}

	public void draw(Graphics2D g2) {
		g2.setColor(new Color(0,0,0,0));
		g2.fillRect(x, y, gp.tilesize, gp.tilesize);
		BufferedImage image = null;
		switch (direction) {
		case "up":
			if (spritenum ==1) {
			    image = up1;
			}
			if (spritenum ==2) {
				image = up2;
			}
			break;
		case "down":
			if (spritenum ==1) {
			    image = down1;
			}
			if (spritenum ==2) {
				image = down2;
			}
			break;
		case "left":
			if (spritenum ==1) {
			    image = left1;
			}
			if (spritenum ==2) {
				image = left2;
			}
			break;
		case "right":
			if (spritenum ==1) {
			    image = right1;
			}
			if (spritenum ==2) {
				image = right2;
			}
			break;
		}
		g2.drawImage(image, screenx, screeny,gp.tilesize,gp.tilesize,null);
		
	}

}
