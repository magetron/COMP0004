import java.util.ArrayList;

public class Range {
	
	private int lower;
	private int upper;

	Range (int lower, int upper) throws Exception {
		if (lower > upper) throw new Exception ("ERROR : invalid Range.");
		this.lower = lower;
		this.upper = upper;
	}

	int getLower () {
		return lower;
	}

	int getUpper () {
		return upper;
	}

	boolean contains (int n) {
		if ( (n >= lower) && (n <= upper) ) return true;
		else return false;
	}
	
	public ArrayList<Integer> getValues () {
		ArrayList<Integer> numberArray = new ArrayList<>();
		for (int i = lower; i <= upper; i++) numberArray.add(i);
		return numberArray;
	}

}
