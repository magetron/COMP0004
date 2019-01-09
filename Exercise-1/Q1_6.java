public class Q1_6 {
	public double a, b;

	public void inputDoubles () {
		Input in = new Input();
		a = in.nextDouble();
		b = in.nextDouble();
	}

	public double sqrtOfSum () {
		return Math.sqrt(a + b);
	}

	public static void main (String[] args) {
		Q1_6 q1_6 = new Q1_6();
		q1_6.inputDoubles();
		System.out.println(q1_6.sqrtOfSum());
	}
}
