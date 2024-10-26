package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Chest extends Superobject {
	public Chest() {
		this.name = "Chest";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/chest.PNG"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
