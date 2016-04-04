package edu.towson.cis.cosc603.project4.rectangle;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The unit test Class for Rectangle.
 */
public class RectangleTest {
	
	/** 
	 * Declaring necessary test objects for {@link Rectangle} 
	 * This way there is more clarity in seeing all the points
	  */
	
	Rectangle rect1, rect2;
	Point x1;
	Point y1;
	Point x2;
	Point y2;
	/**
	 * Initializes the necessary test objects for the test cases to use.
	 * The values for all the points can be seen here and not in the method
	 * causing confusion
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		
		rect1 = new Rectangle(x1, y1);
		rect2 = new Rectangle(x2, y2);
		x1 = new Point (2.0, 2.0);
		y1 = new Point (4.0, 7.0);
		x2 = new Point (2.0, 6.0);
		y2 = new Point (4.0, 3.0);
	}

	/**
	 * Test for the getArea() method of the {@link Rectangle} class.
	 */
	@Test
	public void testGetArea() {
		assertEquals(10.0, rect1.getArea(x1, y1),0.001);
		assertEquals(6.0, rect2.getArea(x2, y2),0.001);
	}

	/**
	 * Test for the getDiagonal() method of the {@link Rectangle} class.
	 */
	@Test
	public void testGetDiagonal() {
		assertEquals(5.3852, rect1.getDiagonal(x1, y1), 0.0001);
		assertEquals(3.6056, rect2.getDiagonal(x2, y2), 0.0001);
	}
	
	/**
	 * Cleans up test objects after a test case is executed.
	 */
	@After
	public void tearDown(){
		rect1 = null;
		rect2 = null;
		x1 = null;
		y1 = null;
		x2 = null;
		y2 = null;			
	}
}
