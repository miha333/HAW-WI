import java.util.ArrayList;
import java.util.Collections;

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
public class WebShop {
	/**
	 * Aufzählungstyp für die Art der Sortierung. enum-Elemente werden als
	 * Methodenparameter für die Sortierkriterien in der Methode
	 * printListOfCustomer verwendet.
	 */
	public enum SortingCriterion {
		SORT_BY_SURNAME_FIRSTNAME, SORT_BY_ID
	}

	/* Listendeklaration */
	private ArrayList<Customer> webShop = new ArrayList<Customer>();

	/* Ein- und Ausschalten der Ausgaben zu Testzwecken */
	private static final boolean TEST = false;

	/* ***** Hauptmethoden ***** */

	/**
	 * Hinzufügen eines neuen Kunden, falls noch nicht vorhanden.
	 * 
	 * @param firstName
	 * @param surName
	 */
	public void addCustomer(String firstName, String surName)
			throws WebShopException {
		Customer customer = getCustomerFromList(firstName, surName);
		/* Kunde bereits vorhanden */
		/* if(customer!=null) */
		/*
		 * Vorgabe siehe AufgabenBlatt. Übergehen der Exception im Falle der
		 * Übereinstimmung von Vor- und Nachname
		 */
		if (firstName == "" || surName == "") {
			throw new WebShopException("Eingabe unvollständig! " + surName
					+ ", " + firstName);
		} else {
			/* Neues Customer-Objekt erzeugen */
			customer = new Customer(firstName, surName);
			appendCustomerToList(customer);
			if (TEST)
				System.out.println("Kunde hinzugefügt");

		}
	}

	public void removeCustomer(String firstName, String surName)
			throws WebShopException {
		Customer customer = getCustomerFromList(firstName, surName);
		if (customer != null) {
			for (int i = 0; i < webShop.size(); i++) {
				/* Lösche alle Objekte mit dem übergebenem Namen */
				webShop.remove(getCustomerFromList(firstName, surName));
			}
			if (TEST)
				System.out.println("Kunde gelöscht");
		} else {
			throw new WebShopException("Kunde nicht vorhanden!");
		}
	}

	public int getID(String firstName, String surName) {
		Customer customer = getCustomerFromList(firstName, surName);
		return customer.getId();
	}

	public void printListOfCustomer(SortingCriterion crit) {
		if (crit == SortingCriterion.SORT_BY_SURNAME_FIRSTNAME) {
			Collections.sort(webShop, new CustomerSortByName());
		} else {
			Collections.sort(webShop, new CustomerSortByID());
		}

		for (Customer e : webShop) {
			System.out.println(e.toString());
		}
	}

	/* ***** Hilfsmethoden ***** */

	/*
	 * Suche nach einem Kunden. Liefert das Customer-Objekt zu dem übergebenen
	 * Vornamen, Nachnamen; oder null.
	 */
	private Customer getCustomerFromList(String firstName, String surName) {
		Customer result = null;
		/*
		 * Durchlaufen des webShop als ArrayList mit dem Element e des Typs
		 * Customer, bis Objekt gefunden ist.
		 */
		for (Customer e : webShop) {
			if (e.getFirstName().equals(firstName)
					&& e.getSurName().equals(surName)) {
				/* Vorname und Nachname stimmen überein, Objekt gefunden */
				result = e;
				break;
			}
		}
		return result;
	}

	/*
	 * Anhängen eines neuen Kunden an das Ende der Liste. Parameter: Vorname,
	 * Nachname.
	 */
	private void appendCustomerToList(Customer customer) {
		if (customer != null) {
			webShop.add(customer);
		}
	}
}
