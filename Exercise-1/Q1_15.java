public class Q1_15 {
	private int productoOfSeq (int start, int end) {
		if (start < end) return start * productoOfSeq(start + 1, end);
		else return end;
	}
	
	public void ioController () {
		Input in = new Input ();
		int start = in.nextInt();
		int end = in.nextInt();
		System.out.println(productoOfSeq(start, end));
	}

	public static void main (String args[]) {
		new Q1_15().ioController();
	}
}
