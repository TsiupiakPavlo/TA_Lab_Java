package second;

public class Plants {
	private static int n;
	private int id;
	private int size;
	private Color color;
	private Type type;

	public Plants(int size, Color color, Type type) {
		this.size = size;
		this.color = color;
		this.type = type;
		n++;
		id = n;
	}

	public static int getN() {
		return n;
	}

	public int getId() {
		return id;
	}

	public int getSize() {
		return size;
	}

	public Color getColor() {
		return color;
	}

	public Type getType() {
		return type;
	}

	public String getTypeString() {
		return type.name();
	}

	@Override
	public String toString() {
		return id + ". Size of Plants: " + size + ", Color of plants: " + color + ", Type of plants: " + type;
	}

}
