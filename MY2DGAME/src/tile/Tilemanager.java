package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.Gamepanel;

public class Tilemanager {
	
	Gamepanel gp;
	
	public Tile[] tile = new Tile[6];
    public int maptilenum[][];
	
	public Tilemanager(Gamepanel gp) {
		this.gp= gp;
		tile = new Tile[10];
		maptilenum = new int[gp.maxworldcol][gp.maxworldrow];
		gettileimage();
		loadmap();
	}
	public void gettileimage() {
		try {
			// 0: sand, 1:wall, 2: water, 3:grass, 4: tree, 5: earth
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
			
	
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[2].collision= true;
			
			tile[3]= new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
	
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			tile[4].collision= true;
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water.png"));
			tile[5].collision= true;
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water2.png"));
			tile[6].collision= true;
		}catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void loadmap() {
		try {
			InputStream is = getClass().getResourceAsStream("/map/world01.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			int col = 0;
			int row =0;
			while (col<gp.maxworldcol && row < gp.maxworldrow) {
				String line = br.readLine();
				//????????
				while (col < gp.maxworldcol) {
					String numbers[]= line.split(" ");
					int num = Integer.parseInt(numbers[col]);
					maptilenum[col][row] = num;
					col ++;
					
				}
				if (col == gp.maxworldcol) {
					col = 0;
					row ++;
				}
			}
			br.close();
		}catch (Exception e) {
			
		}
	}
    public void draw(Graphics2D g2) {
    	int worldcol = 0;
    	int worldrow = 0;
 
    	while (worldcol<gp.maxworldcol &&  worldrow<gp.maxworldrow) {
    		
    		int tilenum = maptilenum[worldcol][worldrow]; // lấy ra số hiệu của tile (0,1,2,3,4,5)
    		
    		
    		int worldx1 = worldcol*gp.tilesize;// tilesize là kích cỡ 1 cột
    		int worldy1 = worldrow*gp.tilesize;// worldx, worldy: tọa độ pix trên hàng/cột
    		
    		int screenx1 = worldx1 - gp.player.worldx + gp.player.screenx;
    		int screeny1 = worldy1 - gp.player.worldy + gp.player.screeny;
    		
    		if (worldx1>gp.player.worldx-gp.player.screenx&& worldx1 <gp.player.worldx+gp.player.screenx &&
    				worldy1 <gp.player.worldy+gp.player.screeny&&worldy1 <gp.player.worldy+gp.player.screeny) {
    			
    			g2.drawImage(tile[tilenum].image, screenx1, screeny1,gp.tilesize,gp.tilesize,null);
    		}
    		
    		worldcol ++;

    		if (worldcol == gp.maxworldcol) {
    			worldcol = 0;
   
    			worldrow ++;
   
    		}
    	}
    	
    	
    }
}
