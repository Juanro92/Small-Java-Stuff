
public class Plotter {

	public static <P> void printArray(P[] array) {
		for (P block : array) {
			System.out.printf("%s ", block);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Integer[] iArray = {1,2,3,4,5};
		String[] sArray = {"Hey","sup","buddy","Cya"};
		Double[] dArray = {1.0,2.0,3.0,4.0,5.0};
		Character[] cArray = {'A', 'v', 'e', 'c', 'e', 's'};
		printArray(iArray);
		printArray(sArray);
		printArray(dArray);
		printArray(cArray);
	}

}
