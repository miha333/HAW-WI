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
public class CustomerSortByIDTest extends CustomerSortByID {

	/**
	 * Testmethode für {@link CustomerSortByID#compare(Customer, Customer)}.
	 */
	@Test
	public void testCompare() {
		Customer kunde1 = new Customer("Flick", "Hansi");
		Customer kunde2 = new Customer("Jögi", "Löw");
		int result1 = compare(kunde1, kunde2);
		int expectedResult1 = -1;
		assertEquals("Fehler", result1, expectedResult1);

		Customer kunde3 = new Customer("Marco", "Reus");
		int result2 = compare(kunde3, kunde1);
		int expectedResult2 = 1;
		assertEquals("Fehler", result2, expectedResult2);

		
		int result3 = compare(kunde2, kunde2);
		int expectedResult3 = 0;
		assertEquals("Fehler", result3, expectedResult3);
		
		

	}
}
