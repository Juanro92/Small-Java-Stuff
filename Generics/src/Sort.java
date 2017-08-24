import java.util.Arrays;

public class Sort {
	
	private static <S extends Comparable<S>> Object[] sorter (S[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length; j++) {
				if (array[i].compareTo(array[j]) > 0) {
					S element = array[i];
					array[i] = array[j];
					array[j] = element;
				}
			}
		}
		return array;
	}

	public static void main(String[] args) {
		Integer[] iArray = {8,7,45,62,98,48,75,3};
		String[] sArray = {"Hey","sup","buddy","Cya"};
		Character[] cArray = {'A', 'v', 'e', 'c', 'e', 's'};
		System.out.println(Arrays.toString(sorter(iArray)));
		System.out.println(Arrays.toString(sorter(sArray)));
		System.out.println(Arrays.toString(sorter(cArray)));
	}

}
