import java.util.ArrayList;
import java.util.Collections;

public class Q1_3 {
	private ArrayList<String> strs = new ArrayList<>();
	
	private String readString () {
		Input in = new Input();
		String tmp = in.nextLine();
		return tmp;
	}

	private void readUsrInput () {
		for (int i = 0; i < 10; i++) strs.add(readString());
	}

	private void sortStringArray () {
		Collections.sort(strs);
	}

	private void displayStringArray () {
		System.out.println("---------------");
		for (int i = 9; i >= 0; i--) 
			System.out.println(strs.get(i));
		System.out.println("---------------");
	}

	public void controller () {
		readUsrInput();
		sortStringArray();
		displayStringArray();
	}

	public static void main (String[] args) {
		new Q1_3().controller();
	}
}
