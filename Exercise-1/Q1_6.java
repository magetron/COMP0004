public class Q1_6 {
	private double a, b;

	private void inputDoubles () {
		Input in = new Input();
		a = in.nextDouble();
		b = in.nextDouble();
	}

	private double sqrtOfSum () {
		return Math.sqrt(a + b);
	}

	public void controller () {
		inputDoubles();
		System.out.println(sqrtOfSum());
	}

	public static void main (String[] args) {
		new Q1_6().controller();
	}
}
