package edu.towson.cis.cosc603.project4.rectangle;

// TODO: Auto-generated Javadoc
/**
 * The Class Rectangle.
 */
public class Rectangle {
	
	/** The p2. */
	private Point p1, p2;
	
	
	/**
	 * Instantiates a new rectangle.
	 *
	 * @param p1 the p1
	 * @param p2 the p2
	 */
	Rectangle(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/**
	 * Gets the area.
	 * Parameters were added to see clearly what was being passed.
	 * Local variables height and length were declared and initialized.
	 * @return the area
	 */
	public Double getArea(Point x, Point y) {
		this.p1 = x;
		this.p2 = y;
		double height = (p2.x - p1.x);
		double length = (p2.y - p1.y);
		return Math.abs(height * length);
	}
	
	/**
	 * Gets the diagonal.
	 * Parameters were added to see clearly what was being passed. 
	 * Local variables height and length were declared and initialized.
	 * @return the diagonal
	 */
	public Double getDiagonal(Point x, Point y) {
		this.p1 = x;
		this.p2 = y;
		double height = (p2.x - p1.x);
		double length = (p2.y - p1.y);
		return Math.sqrt(Math.pow(height, 2) + Math.pow(length, 2));
	}

	
	
	/*
	 * Test to see which are X points and which are Y points 
	 * to avoid confusion and spot the bug. 
	 * 
	public static void main (String[] args){
		Point x = new Point (2.0, 2.0);
		Point y = new Point (4.0, 7.0);
		Rectangle rect1 = new Rectangle(x, y);
		System.out.println("area is:" + rect1.getArea( x , y));
		System.out.println ("p1.x is:" + rect1.p1.x +"\n"+ "p1.y is:" + rect1.p1.y);
		System.out.print("p2.x is:" + rect1.p2.x +"\n"+ "p2.y is:" + rect1.p2.y);		
	}
	*/
}
