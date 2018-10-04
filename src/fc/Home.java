package fc;

public class Home {
	private int roomNumber;
	private double price;
	private int posX;
	private int posY;

	public Home() {
		roomNumber = (int) (Math.random() * 10);
		price = Math.random() * 950000.0 + 50000.0;
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
