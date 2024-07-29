class JavaLoopsII {

    public static void main(String[] argh) {
		int a = 0;
		int b = 2;
		int n = 10;

		int total = a;

		for (int j = 0; j < n; j++) {
			total = total + (powerNum(2, j) * b);
			System.out.print(total + " ");
		}
		System.out.println(' ');
    }

    public static int powerNum(int num1, int num2) {
        if (num2 == 0) {
            return 1;
        } else if (num2 == 1) {
            return num1;
        }
        int result = num1;
        for (int i = 1; i < num2; i++) {
            result = result * num1;
        }
        return result;
    }
}
