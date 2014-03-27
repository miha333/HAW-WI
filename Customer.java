import java.util.Comparator;

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

public class Customer {
	/* ***** Variablen ***** */
	private String firstName;
	private String surName;
	/* eindeutige ID */
	private final int id;
	private static int counter = 0;

	/* ***** Konstruktor ***** */
	/**
	 * Custom constructor
	 * 
	 * @param Vorname
	 * @param Nachname
	 */
	public Customer(String firstName, String surName) {
		this.firstName = firstName;
		this.surName = surName;
		id = counter++;
	}

	/* ***** Getter und Setter ***** */

	/**
	 * @return Vorname
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return Nachname
	 */
	public String getSurName() {
		return surName;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/* ***** Standard-Methoden ***** */
	/**
	 * Standardisierte Ausgabe
	 */
	@Override
	public String toString() {
		return getId() + ": " + getSurName() + ", " + getFirstName();
	}

}

/**
 * Vergleich von zwei Customer-Objekten nach Nachname, Vorname.
 */
class CustomerSortByName implements Comparator<Customer> {
	public int compare(Customer customer1, Customer customer2) {
		/*
		 * Wenn die Nachnamen und Vornamen gleich sind, wird der Wert der
		 * Variable result nicht geändert.
		 */int result = 0;
		/* Die Nachnamen sind verschieden */
		if (!customer1.getSurName().equals(customer2.getSurName())) {
			result = customer1.getSurName().compareTo(customer2.getSurName());
			/* Die Nachnamen sind gleich, aber die Vornamen sind verschieden */
		} else if (!customer1.getFirstName().equals(customer2.getFirstName())) {
			result = customer1.getFirstName().compareTo(
					customer2.getFirstName());
		}
		return result;
	}
}

/**
 * Vergleich von zwei Customer-Objekten nach ID.
 */
class CustomerSortByID implements Comparator<Customer> {
	public int compare(Customer customer1, Customer customer2) {
		int result = 0;
		if (customer1.getId() > customer2.getId()) {
			result = 1;
		}
		if (customer1.getId() < customer2.getId()) {
			result = -1;
		}
		return result;
	}
}
