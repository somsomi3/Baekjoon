public class Main {
	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(new java.io.BufferedReader(new java.io.InputStreamReader(System.in)).readLine());

		int count = 0;
		int num = 666;

		while (true) {
			if (has666(num)) {
				count++;
				if (count == n) {
					System.out.println(num);
					break;
				}
			}
			num++;
		}
	}

	public static boolean has666(int num) {
		while (num >= 666) {
			if (num % 1000 == 666) return true;
			num /= 10;
		}
		return false;
	}
}
