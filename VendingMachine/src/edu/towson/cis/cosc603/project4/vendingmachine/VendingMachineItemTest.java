/**
 * 
 */
package edu.towson.cis.cosc603.project4.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author JQ
 *
 */
public class VendingMachineItemTest {
	
	VendingMachineItem item;
	VendingMachineItem snickers;
	VendingMachineItem freeCandy;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before 
	public void setUp() throws Exception {
		
		item = new VendingMachineItem ("butterfinger", 1.00);
		snickers = new VendingMachineItem ("Snickers", 1.00);
		freeCandy = new VendingMachineItem ("free", 0.00);
		
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem#VendingMachineItem(java.lang.String, double)}.
	 * Test the constructor
	 */
	@Test
	public final void testVendingMachineItem() {
		assertNotNull(item);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem#getName()}.
	 * Test GetName() to see if it returns the name of the item.
	 */
	@Test
	public final void testGetName() {
		assertEquals("butterfinger", item.getName());
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem#getPrice()}.
	 * Test GetPrice() to see if correct price is returned with a positive number for price
	 */
	@Test
	public final void testGetPricePositiveNumber() {
		assertEquals(1.00, snickers.getPrice(), 0.01);
	}	
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem#getPrice()}.
	 * Test GetPrice() to see if correct price is returned with a zero number for price
	 */
	@Test 
		public final void testGetPriceWithZeroNumber() {	
		assertEquals(0.00, freeCandy.getPrice(), 001);	
	}
	

	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		item = null;
		snickers = null;
		freeCandy = null;
	}
}
