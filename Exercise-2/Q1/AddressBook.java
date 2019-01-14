import java.util.ArrayList;

public class AddressBook {
	private ArrayList<AddressBookEntry> addressBook = new ArrayList<>();

	public String addPerson (String name, String phone, String email) {
		addressBook.add(new AddressBookEntry(name, phone, email));
		return "Add Person Successful!";
	}

	public String removePersonByName (String name) {
		for (var entry : addressBook)
			if ( entry.getName().contains(name) ) {
				addressBook.remove(entry);
				return "Remove Successful!";
			}
		return "ERROR : Cannot find name. Remove Failed.";
	}

	public String removePersonByPhone (String phone) {
		for (var entry : addressBook) 
			if ( entry.getPhone().contains(phone) ) {
				addressBook.remove(entry);
				return "Remove Successful!";
			}
		return "ERROR : Cannot find phone. Remove Failed.";
	}

	public String removePersonByEmail (String email) {
		for (var entry : addressBook) 
			if ( entry.getEmail().contains(email) ) {
				addressBook.remove(entry);
				return "Remove Successful!";
			}
		return "ERROR : Cannot find email. Remove Failed.";
	}

	public AddressBookEntry searchPersonByName (String name) {
		for (var entry : addressBook) 
			if ( entry.getName().contains(name) ) return entry;
		return null;
	}

	public AddressBookEntry searchPersonByPhone (String phone) {
		for (var entry : addressBook) 
			if (entry.getPhone().contains(phone)) return entry;
		return null;
	}

	public AddressBookEntry searchPersonByEmail (String email) {
		for (var entry : addressBook) 
			if (entry.getEmail().contains(email)) return entry;
		return null;
	}
}



