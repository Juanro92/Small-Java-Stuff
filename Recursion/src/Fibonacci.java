import java.util.Scanner;

public class Fibonacci {

	static int fibby(int number) {
		if (number == 0) {
			return 0;
		} else if (number == 1) {
			return 1;
		} else {
			return fibby(number - 1) + fibby(number -2);
		}
	}
	
	public static void main(String[] args) {
		System.out.print("Enter in a number to compute:");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		System.out.println("The fibbonaci number is: " + fibby(n));
	}

}
