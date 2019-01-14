import java.util.ArrayList;

public class AddressBookEntry {
	
	private String name;
	private String phone;
	private String email;

	AddressBookEntry (String name, String phone, String email) {
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	String getName () {
		return name;
	}

	String getPhone () {
		return phone;
	}

	String getEmail () {
		return email;
	}

	@Override
	public String toString() {
		return "Name : " + getName() + "\nPhone : " + getPhone() + "\nEmail : " + getEmail();

	}
}

	
