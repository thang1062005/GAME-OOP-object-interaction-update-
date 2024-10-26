package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Key extends Superobject {
	public Key() {
		this.name = "Key";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/key.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
