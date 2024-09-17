/*
 * Testcases for the Pay Station system.
 *
 * This source code is from the book "Flexible, Reliable Software: Using
 * Patterns and Agile Development" published 2010 by CRC Press. Author: Henrik B
 * Christensen Computer Science Department Aarhus University
 *
 * This source code is provided WITHOUT ANY WARRANTY either expressed or
 * implied. You may study, use, modify, and distribute it for non-commercial
 * purposes. For any commercial use, see http://www.baerbak.com/
 */
package edu.temple.cis.paystation;

import java.util.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class PayStationImplTest {

    PayStation ps;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setup() {
        ps = new PayStationImpl();
    }

    @After
    public void tearDown() {
    }

    /**
     * Entering 5 cents should make the display report 2 minutes parking time.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void shouldDisplay2MinFor5Cents()
            throws IllegalCoinException {
        ps.addPayment(5);
        assertEquals("Should display 2 min for 5 cents",
                2, ps.readDisplay());
    }

    /**
     * Entering 25 cents should make the display report 10 minutes parking time.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void shouldDisplay10MinFor25Cents() throws IllegalCoinException {
        ps.addPayment(25);
        assertEquals("Should display 10 min for 25 cents",
                10, ps.readDisplay());
    }

    /**
     * Verify that illegal coin values are rejected.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test(expected = IllegalCoinException.class)
    public void shouldRejectIllegalCoin() throws IllegalCoinException {
        ps.addPayment(17);
    }

    /**
     * Entering 10 and 25 cents should be valid and return 14 minutes parking
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void shouldDisplay14MinFor10And25Cents()
            throws IllegalCoinException {
        ps.addPayment(10);
        ps.addPayment(25);
        assertEquals("Should display 14 min for 10+25 cents",
                14, ps.readDisplay());
    }

    /**
     * Buy should return a valid receipt of the proper amount of parking time
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void shouldReturnCorrectReceiptWhenBuy()
            throws IllegalCoinException {
        ps.addPayment(5);
        ps.addPayment(10);
        ps.addPayment(25);
        Receipt receipt;
        receipt = ps.buy();
        assertNotNull("Receipt reference cannot be null",
                receipt);
        assertEquals("Receipt value must be 16 min.",
                16, receipt.value());
    }

    /**
     * Buy for 100 cents and verify the receipt
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void shouldReturnReceiptWhenBuy100c()
            throws IllegalCoinException {
        ps.addPayment(10);
        ps.addPayment(10);
        ps.addPayment(10);
        ps.addPayment(10);
        ps.addPayment(10);
        ps.addPayment(25);
        ps.addPayment(25);

        Receipt receipt;
        receipt = ps.buy();
        assertEquals(40, receipt.value());
    }

    /**
     * Verify that the pay station is cleared after a buy scenario
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void shouldClearAfterBuy()
            throws IllegalCoinException {
        ps.addPayment(25);
        ps.buy(); // I do not care about the result
        // verify that the display reads 0
        assertEquals("Display should have been cleared",
                0, ps.readDisplay());
        // verify that a following buy scenario behaves properly
        ps.addPayment(10);
        ps.addPayment(25);
        assertEquals("Next add payment should display correct time",
                14, ps.readDisplay());
        Receipt r = ps.buy();
        assertEquals("Next buy should return valid receipt",
                14, r.value());
        assertEquals("Again, display should be cleared",
                0, ps.readDisplay());
    }

    /**
     * Verify that cancel clears the pay station
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void shouldClearAfterCancel()
            throws IllegalCoinException {
        ps.addPayment(10);
        ps.cancel();
        assertEquals("Cancel should clear display",
                0, ps.readDisplay());
        ps.addPayment(25);
        assertEquals("Insert after cancel should work",
                10, ps.readDisplay());
    }

    /**
     * Verify that empty returns the total amount collected over several transactions.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void shouldReturnTotalWhenEmptied() throws IllegalCoinException {

        ps.addPayment(10);
        ps.addPayment(10);
        ps.buy();

        ps.addPayment(10);
        ps.addPayment(10);
        ps.buy();

        assertEquals("Empty should return the total amount collected", 40, ps.empty());
    }
    
    /**
     * Verify that the canceled entry does not add to the amount returned by
     * empty.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void cancelShouldNotAddToEmpty() throws IllegalCoinException
    {
        int amountAdded = 25;
        ps.addPayment(amountAdded);
        ps.buy();
        ps.addPayment(amountAdded);
        ps.cancel();
        assertEquals("Canceled coin should not be added to total", amountAdded, ps.empty());
    }
    
    /**
     * Very that the empty method resets the total to zero.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void testEmptyZero() throws IllegalCoinException
    {
        int amountAdded = 10;
        ps.addPayment(amountAdded);
        ps.buy();
        ps.empty();
        assertEquals("Total amount of money should be 0", 0, ps.empty());
    }
    
    /**
     * Verify that cancel returns a map with the correct amount of coins for one
     * coin type.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void test1CoinMapReturn() throws IllegalCoinException
    {
        int amountAdded = 25;
        ps.addPayment(amountAdded);
        assertEquals("Coin map should contain 1 quarter", 1, (int)ps.cancel().get(25)); //Need cast to avoid ambiguous overload error
    }
    
    /**
     * Verify that cancel returns a map that does not contain a key for a coin not entered.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void testNoCoinMapReturn() throws IllegalCoinException
    {
        ps.addPayment(10);
        ps.addPayment(10);
        ps.addPayment(5);
        assertFalse("Coin map should not contain a key for " + 25, ps.cancel().containsKey(25));
    }
    
    /**
     * Verify that cancel returns a map with the correct amount of coins for
     * all coin types.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void testMultipleCoinMapReturn() throws Exception
    {
        ps.addPayment(10);
        ps.addPayment(10);
        ps.addPayment(5);
        ps.addPayment(25);
        Map<Integer, Integer> answer = new HashMap<Integer, Integer>(){{
            put(10, 2);
            put(5, 1);
            put(25,1);
        }};
        assertEquals("Coin map should contain correct number of coins of each type", answer, ps.cancel());
    }
 
    /**
     * Verify that cancel clears the map.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void testCancelClearMap() throws  IllegalCoinException
    {
        ps.addPayment(25);
        ps.addPayment(5);
        ps.addPayment(10);
        ps.addPayment(25);
        ps.cancel();
        assertTrue("Coin map should be empty after cancel", ps.cancel().isEmpty());
    }
    
    /**
     * Verify that buy clears the map.
     * @throws IllegalCoinException if an improper coin is added
     */
    @Test
    public void testBuyClearMap() throws IllegalCoinException
    {
        ps.addPayment(25);
        ps.addPayment(5);
        ps.addPayment(10);
        ps.addPayment(25);
        ps.buy();
        assertTrue("Coin map should be empty after buy", ps.cancel().isEmpty());
    }
}
