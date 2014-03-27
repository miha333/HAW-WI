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
public class WebShopAnwendung {
	public static void main(String[] args) {
		try {
			/* 1. Teil */
			System.out.println("Liste nach Nachnamen, Vornamen sortiert");
			WebShop webShop = new WebShop();
			webShop.addCustomer("Jogi", "L�w");
			webShop.addCustomer("Uli", "Hoene�");
			webShop.addCustomer("Hansi", "Flick");
			webShop.addCustomer("Dieter", "Hoene�");
			webShop.addCustomer("Hansi", "Flick");
			webShop.addCustomer("Mehmet", "Scholl");
			webShop.addCustomer("Marco", "Reus");
			webShop.printListOfCustomer(WebShop.SortingCriterion.SORT_BY_SURNAME_FIRSTNAME);

			/* 2. Teil */
			System.out.println("Liste nach ID sortiert");
			webShop.printListOfCustomer(WebShop.SortingCriterion.SORT_BY_ID);

			/* 3. Teil */
			System.out.println("Liste nach ID (nach dem L�schen) sortiert");
			webShop.removeCustomer("Mehmet", "Scholl");
			webShop.removeCustomer("Hansi", "Flick");
			webShop.printListOfCustomer(WebShop.SortingCriterion.SORT_BY_ID);

		} catch (WebShopException e) {
			System.out.print("Fehlermeldung! ");
			e.printStackTrace();
		} finally {
			System.out.println("Ende");
		}
	}
}
