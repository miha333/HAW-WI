import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Mihail Weiland (mihail.weiland@haw-hamburg.de) <br>
 * @author Edmund Schauer (edmund.schauer@haw-hamburg.de) <br>
 * 
 * @version <br>
 * 
 *          Praktikum Programmieren 2, SS2014/WI <br>
 *          Praktikumsgruppe 1 <br>
 *          Aufgabenblatt 1, "Benutzerverwaltung" <br>
 *          Verwendete Quellen: Quelle (Begriff: )
 */
public class CustomerSortByNameTest extends CustomerSortByName {

	/**
	 * Testmethode für {@link CustomerSortByName#compare(Customer, Customer)}.
	 */
	@Test
	public void testCompare() {
		Customer kunde1 = new Customer("A", "B");
		Customer kunde2 = new Customer("A", "A");
		Customer kunde3 = new Customer("C", "B");
		Customer kunde4 = new Customer("A", "C");

		int result1 = compare(kunde1, kunde2);
		int expectedResult1 = 1;
		assertEquals("Fehler", result1, expectedResult1);

		int result2 = compare(kunde2, kunde4);
		int expectedResult2 = -2;
		assertEquals("Fehler", result2, expectedResult2);

		int result3 = compare(kunde1, kunde3);
		int expectedResult3 = -2;
		assertEquals("Fehler", result3, expectedResult3);

		int result4 = compare(kunde2, kunde4);
		int expectedResult4 = -2;
		assertEquals("Fehler", result4, expectedResult4);

		int result5 = compare(kunde2, kunde2);
		int expectedResult5 = 0;
		assertEquals("Fehler", result5, expectedResult5);

	}

}
