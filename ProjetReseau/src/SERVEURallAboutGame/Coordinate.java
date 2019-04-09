package SERVEURallAboutGame;

public class Coordinate {

	private int y;
	private int x;

	public Coordinate(int x, int y) {
		this.y = y;
		this.x = x;
	}

	public Coordinate(Coordinate coord) {
		x = coord.getX();
		y = coord.getY();
	}

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;

	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public int compare(Coordinate c) {
		if (y < c.getY())
			return -1;
		else if (y == c.getY()) {
			if (x < c.getX())
				return -1;
			else if (x == c.getX())
				return 0;
			else
				return 1;
		} else
			return 1;

	}
}
