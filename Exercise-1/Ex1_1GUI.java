class Ex1_1GUI {
	public int sumOfDigits (int n) {
		int s = 0;
		n = Math.abs(n);
		while (n > 0) {
			s += n % 10;
			n /= 10;
		}
		return s;

	}

	public void inputAndProcess () {
		GUIInput in = new GUIInput();
		int n = in.readInt("Enter Here : ");
		System.out.println(sumOfDigits(n));
	}

	public static void main (String[] args) {
		new Ex1_1GUI().inputAndProcess();
	}
}
		
	
