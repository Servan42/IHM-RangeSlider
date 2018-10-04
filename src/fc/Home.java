package fc;

public class Home {
	private int roomNumber;
	private double price;
	private int posX;
	private int posY;
	
	public Home(int perimetre) {
		roomNumber = (int)(Math.random()*10) + 1;
		price = Math.random()*950000.0 + 50000.0;
		posX = (int)Math.random()*(perimetre + 1);
		posX = (int)Math.random()*(perimetre + 1);
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
