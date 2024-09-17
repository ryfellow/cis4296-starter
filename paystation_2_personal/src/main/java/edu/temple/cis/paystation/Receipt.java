/**
 * The receipt returned from a pay station. Responsibilities:
 *
 * 1) Know the minutes parking time the receipt represents
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

public interface Receipt {

    /**
     * Return the number of minutes this receipt is valid for.
     *
     * @return number of minutes parking time
     */
    public int value();
}
