import java.util.ArrayList;

import java.util.Collections;

public class Ex1_4 {
	private ArrayList<Integer> a = new ArrayList<>();

	private void showArray () {
		for (int i : a) System.out.print(i + " ");
		System.out.println();
	}

	private void readArray () {
		Input in = new Input();
		while (in.hasNextInt()) {
			int tmp = in.nextInt();
			a.add(tmp);
		}
	}

	private void sortArray () {
		Collections.sort(a);
	}

	public void run () {
		readArray();
		sortArray();
		showArray();
	}

	public static void main (String[] args) {
		new Ex1_4().run();
	}
}

	
