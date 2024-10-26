package main;

import object.Chest;
import object.Door;
import object.Key;

public class Assetsetter {
	Gamepanel gp;
	public Assetsetter(Gamepanel gp) {
		this.gp = gp;
		
	}
	public void setobj() {
		gp.obj[0]= new Key();
		gp.obj[0].worldx = 23*gp.tilesize;
		gp.obj[0].worldy = 6*gp.tilesize;
		
		gp.obj[1]= new Key();
		gp.obj[1].worldx = 23*gp.tilesize;
		gp.obj[1].worldy = 40*gp.tilesize;
		
		gp.obj[2]= new Key();
		gp.obj[2].worldx = 37*gp.tilesize;
		gp.obj[2].worldy = 7*gp.tilesize;
		
		gp.obj[3]= new Door();
		gp.obj[3].worldx = 11*gp.tilesize;
		gp.obj[3].worldy = 9*gp.tilesize;
		
		gp.obj[4]= new Door();
		gp.obj[4].worldx = 8*gp.tilesize;
		gp.obj[4].worldy = 28*gp.tilesize;
		
		gp.obj[5]= new Door();
		gp.obj[5].worldx = 12*gp.tilesize;
		gp.obj[5].worldy = 22*gp.tilesize;
		
		gp.obj[6]= new Chest();
		gp.obj[6].worldx = 10*gp.tilesize;
		gp.obj[6].worldy = 7*gp.tilesize;
	}

}
