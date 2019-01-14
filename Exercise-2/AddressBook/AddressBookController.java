public class AddressBookController {
	private AddressBook addressBook = new AddressBook();
	
	private void printInstructions () {
		System.out.println("1. Add");
		System.out.println("2. Remove");
		System.out.println("3. Search");
		System.out.println("4. Quit");
	}

	private int getInt () {
		Input in = new Input ();
		if (in.hasNextInt()) return in.nextInt();
		return 0;
	}

	private String getString () {
		Input in = new Input ();
		if (in.hasNextLine()) return in.nextLine();
		return "";
	}

	private String addController () {
		System.out.println("Name ?");
		String name = getString();
		System.out.println("Phone ?");
		String phone = getString();
		System.out.println("Email ?");
		String email = getString();
		return addressBook.addPerson(name, phone, email);
	}
	
	private void printRemoveInstructions () {
		System.out.println("1. Remove by Name");
		System.out.println("2. Remove by Phone");
		System.out.println("3. Remove by Email");
	}

	private String removeController () {
		printRemoveInstructions();
		int removeOperation = getInt();
		switch (removeOperation) {
			case 1 : return addressBook.removePersonByName(getString());
			case 2 : return addressBook.removePersonByPhone(getString());
			case 3 : return addressBook.removePersonByEmail(getString());
		}
		return "ERROR : unknown. Remove Failed.";
	}

	private void printSearchInstructions () {
		System.out.println("1. Search by Name");
		System.out.println("2. Search by Phone");
		System.out.println("3. Search by Email");
	}
	
	private boolean foundPerson (AddressBookEntry entry) {
		return (entry == null) ? false : true;
	}

	private String searchController () {
		printSearchInstructions();
		int searchOperation = getInt();
		AddressBookEntry entry;
		switch (searchOperation) {
			case 1 : entry = addressBook.searchPersonByName(getString());
				 return foundPerson(entry) ? entry.toString() : "ERROR : Person not found.";
			case 2 : entry = addressBook.searchPersonByPhone(getString());
				 return foundPerson(entry) ? entry.toString() : "ERROR : Person not found.";
			case 3 : entry = addressBook.searchPersonByEmail(getString());
				 return foundPerson(entry) ? entry.toString() : "ERROR : Person not found.";
		}
		return "ERROR : unknown. Search Failed.";
	}

	public void ioController () {
		int op = 0;
		while (op != 4) {
			printInstructions();
			op = getInt();
			switch (op) {
				case 1 : System.out.println(addController());
					 break;
				case 2 : System.out.println(removeController());
					 break;
				case 3 : System.out.println(searchController());
					 break;
			}
		}
	}

	public static void main (String args[]) {
		new AddressBookController().ioController();
	}
}
