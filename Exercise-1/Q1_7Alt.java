public class Q1_7Alt {
	private String toBase(int n, int b) {
		return Integer.toString(n, b);
	}
	
	public void controller () {
		Input in = new Input();
		int n = in.nextInt();
		int b = in.nextInt();
		System.out.println(toBase(n, b).toUpperCase());
	}
	
	public static void main (String[] args) {
		new Q1_7Alt().controller();
	}
}
