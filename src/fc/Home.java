package fc;

public class Home {
	public static int perimetre = 500;
	
	private int roomNumber;
	private double price;
	private int posX;
	private int posY;

	public Home() {
		roomNumber = (int)(Math.random()*10) + 1;
		price = Math.random()*950000.0 + 50000.0;
		posX = (int)(Math.random()*(perimetre + 1));
		posY = (int)(Math.random()*(perimetre + 1));
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public double getPrice() {
		return price;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}
