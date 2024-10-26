package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Door extends Superobject {
	public Door() {
		this.name = "Door";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/objects/door.PNG"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}

}
