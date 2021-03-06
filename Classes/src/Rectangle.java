package testPackage;

class Rectangle {
	private int m_width;
	private int m_height;
	private int m_area;
	private int m_parameter;
	
	// Constructors
	public Rectangle() {}
	public Rectangle(int w, int h) {
		m_width = w;
		m_height = h;
	}
	
	// Getters
	public int getWidth() {
		return m_width;
	}
	public int getHeight() {
		return m_height;
	}
	public int getArea() {
		return m_area;
	}
	public int getParameter() {
		return m_parameter;
	}
}
