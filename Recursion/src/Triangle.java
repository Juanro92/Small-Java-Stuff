import java.util.Scanner;

public class Triangle {
	
	static void print(int n) {
		for (int i = 0; i < n; i++) {
			System.out.format("%" + (n-i)*2 +"s","");
			for (int j = 0; j <= i; j++) {
				System.out.format("%4d", compute(i,j));
			}
			System.out.println();
		}
	}
	
	private static int compute (int i, int j) {
		if(j == 0) {
			return 1;
		} else if (i == j) {
			return 1;
		} else {
			return compute(i-1, j-1) + compute(i-1, j);
		}
	}

	public static void main(String[] args) {
		System.out.println("What row would you like to compute?");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		print(n);
	}

}
