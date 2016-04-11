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
public class VendingMachineTest {

	/**
	 * @throws java.lang.Exception
	 */
	VendingMachine myMachine;
	VendingMachineItem snickers;
	VendingMachineItem butterfinger;
	VendingMachineItem milkyway;
	VendingMachine myBalance1;
	VendingMachine myBalance2;
	VendingMachine myBalance3;
	VendingMachineException machineException;
	
	
	
	
	@Before
	public void setUp() throws Exception {
		myMachine = new VendingMachine();
		snickers = new VendingMachineItem ("Snickers", 1.0);
		milkyway = new VendingMachineItem (null, 2.00);
		
		myMachine.addItem (snickers, VendingMachine.A_CODE);
		myBalance1 = new VendingMachine(20.00);
		myBalance2 = new VendingMachine(0.00);
		
		machineException = new VendingMachineException();

		
	}


	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#VendingMachine()}.
	 * Test the constructor to see that the snickers object has been initialized
	 */
	@Test
	public final void testVendingMachine() {
		assertNotNull(snickers);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#VendingMachine()}.
	 * Test the constructor for negative values
	 */
	@Test (expected = VendingMachineException.class)
    public void testConstructorNegativeValues() {
	//	assertSame(machineException, new VendingMachineItem("snack", -1.0));
		myBalance3 = new VendingMachine (-10.00);
    }

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem, java.lang.String)}.
	 * Test the addItem() by adding VendingMachine objects occupying one slot each
	 */
	@Test 
	public final void testAddItem() {
		myMachine.addItem(snickers, VendingMachine.B_CODE);
		myMachine.addItem(snickers, VendingMachine.C_CODE);
		myMachine.addItem(snickers, VendingMachine.D_CODE);	
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem, java.lang.String)}.
	 * Test the addItem() for unknown values
	 */
	@Test (expected = VendingMachineException.class)
	public final void testAddItemUnknown(){
		myMachine.addItem(snickers, "F");
		assertNotEquals( snickers, myMachine.getItem("F"));
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc603.project4.vendingmachine.VendingMachineItem, java.lang.String)}.
	 * Test a known exception when an item occupies the same slot.
	 */
	@Test (expected = VendingMachineException.class)
	public final void testAddItemThrowsExceptionWhenOccupiedSlot(){
		myMachine.addItem(snickers, VendingMachine.A_CODE);
	//	assertSame (machineException, myMachine.Item(VendingMachine.A_CODE));
		//assertEquals(machineException, myMachine.addItem(snickers, VendingMachine.A_CODE));
		
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#getItem(java.lang.String)}.
	 * Test the GetItem() to see if the code is the same.
	 */
	@Test
	public final void testGetItem() {
		assertSame("A", VendingMachine.A_CODE);
	
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 * Test RemoveItem to see that after removing an item, that item is not there so it is null
	 */
	@Test
	public final void testRemoveItem() {
		myMachine.removeItem(VendingMachine.A_CODE);
		assertNull(myMachine.getItem(VendingMachine.A_CODE));	
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 * Test RemoveItem() for exception when an unknown item is removed.
	 * In this case it would be an undeclared item because "B" actually exists.
	 */
	@Test (expected = VendingMachineException.class)
	public final void testRemoveItemThrowsExceptionForUndeclaredItem() {
		myMachine.removeItem("F");	
		//assertNull(myMachine.getItem("B"));	
		//assertNotNull(myMachine.getItem("B"));
		//assertNotEquals("B", myMachine.getItem("B"));
	//assertSame (machineException, myMachine.removeItem(null));
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 * Test RemoveItem() for exception when an item is removed twice.
	 */
	@Test (expected = VendingMachineException.class)
	public final void testRemoveItemThrowsExceptionForItemRemovedTwice() {
		myMachine.removeItem(VendingMachine.A_CODE);	
		myMachine.removeItem(VendingMachine.A_CODE);
		//assertNull(myMachine.getItem(VendingMachine.A_CODE));	
		//assertSame(machineException, myMachine.removeItem(VendingMachine.A_CODE));
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#insertMoney(double)}.
	 * Test InsertMoney() to see one transaction and without a purchase
	 * the balance is the same.
	 */
	
	@Test
	public final void testInsertMoney() {
		myMachine.insertMoney(10.0);
		assertEquals(10.0, myMachine.getBalance(), 0.01);	
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#insertMoney(double)}.
	 * Test InsertMoney() by adding more money and see how the balance has changed
	 * to reflect the new amount.
	 */
	@Test
	public final void testInsertMoneyComplex(){
		myMachine.insertMoney(20.00);
		myMachine.insertMoney(30.00);
		assertEquals(50.0, myMachine.getBalance(), 0.01);
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#insertMoney(double)}.
	 * Test InsertMoney() to check for exception when money inserted is less than zero
	 */
	@Test (expected = VendingMachineException.class)
	public final void testInsertMoneyLessThanZeroBalance(){
		myMachine.insertMoney(-20.00);	
		assertEquals(-20.00 , myMachine.getBalance(), 0.01);
		
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#insertMoney(double)}.
	 * Test InsertMoney() to see when money inserted is zero
	 */
	@Test 
	public final void testInsertMoneyWithZeroBalance(){
		myMachine.insertMoney(0.00);	
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#getBalance()}.
	 * Test GetBalance() after inserting money 
	 */
	@Test
	public final void testGetBalanceAfterInsertingMoney() {
		myMachine.insertMoney(10.0);
		assertEquals(10.0, myMachine.getBalance(), 0.01);
		
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#getBalance()}.
	 * Test GetBalance() for  values > 0
	 */
	@Test
	public final void testGetBalanceForPositiveBalance() {
		assertEquals (20.00, myBalance1.getBalance(), 0.01);
	}
	
	
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#getBalance()}.
	 * Test GetBalance() for value = 0
	 */
	@Test 
	public final void testGetBalanceWithValueZero() {
		assertEquals(0.00, myBalance2.getBalance(), 0.01);
	}
	
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 * Test MakePurchase to see that an item can be purchased. 
	 */
	@Test
	public final void testMakePurchase() {
		myMachine.insertMoney(10.00);
		assertTrue(myMachine.makePurchase(VendingMachine.A_CODE));
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 * Test MakePurchase() to see that there is not possible to make a purchase 
	 * without inserting money.
	 */
	@Test
	public final void testMakePurchaseWithNOMoneyInserted() {
		assertFalse(myMachine.makePurchase(VendingMachine.A_CODE));
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 * Test MakePurchase to see that an item can not be purchased with money less than zero 
	 */
	@Test (expected = VendingMachineException.class)
	public final void testMakePurchaseWithMoneyLessThanZero() {
		myMachine.insertMoney(-10.00);
		assertFalse(myMachine.makePurchase(VendingMachine.A_CODE));
		
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 * Test MakePurchase to see that an item can not be purchased with zero money 
	 */
	@Test 
	public final void testMakePurchaseWithZeroMoneyInserted() {
		myMachine.insertMoney(0.00);
		assertFalse(myMachine.makePurchase(VendingMachine.A_CODE));
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 * Test MakePurchase to see that an empty item can not be purchased.
	 */
	@Test 
	public final void testMakePurchaseOfANullItem() {
		myMachine.insertMoney(10.00);
		assertFalse(myMachine.makePurchase(VendingMachine.D_CODE));	
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#returnChange()}.
	 * Test returnChange() to see the correct change after making a purchase
	 */
	@Test
	public final void testReturnChangeAfterMakingAPurchase() {
		myMachine.insertMoney(10.00);
		myMachine.makePurchase(VendingMachine.A_CODE);
		assertEquals(9.0, myMachine.returnChange(), 0.01);	
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#returnChange()}.
	 * Test returnChange() to see that returned change is the same
	 * as inserted money if not making a purchase
	 */
	@Test
	public final void testReturnChangeAfterMoneyInsertedAndNotMakingAPurchase() {
		myMachine.insertMoney(9.00);
		assertEquals(9.0, myMachine.returnChange(), 0.01);	
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc603.project4.vendingmachine.VendingMachine#returnChange()}.
	 * Test returnChange() to see that change is not returned when inserted money
	 * is less than price of item.
	 */
	@Test
	public final void testReturnChangeWhenMoneyIsLessThanThePrice() {
		myMachine.insertMoney(0.50);
		assertFalse(myMachine.makePurchase(VendingMachine.A_CODE));	
	}
	
	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		 myMachine = null;
		 snickers = null;
		 myBalance1 = null;
		 myBalance2 = null;
		 myBalance3 = null;
		machineException = null;
	//	System.out.println("after");
	}
	
}
