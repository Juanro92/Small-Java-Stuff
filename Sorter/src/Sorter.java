import java.util.ArrayList;
import java.util.Scanner;

public class Sorter {
	private static ArrayList<String> userInput = new ArrayList<String>();

	private static void reverse(ArrayList<String> array) {
		for (int i = 0; i < array.size(); i++) {
			String element = array.get(i);
			String setter = "";
			for(int k = 0; k < element.length(); k++) {
				char temp = element.charAt(element.length() - k - 1);
				setter += temp;
			}
			array.set(i, setter);
		}
	}
    // Doesnt work with odd numbered inputs
	private static void alphabetize(ArrayList<String> array) {
		int length = array.size();
		for (int i = 0; i < length; i++) {
			int minIndex = i;
			for (int j = i+1; j < length; j++) {
				String indexI = array.get(i);
				String indexJ = array.get(j);
				if (indexJ.compareTo(indexI) < 0) {
					minIndex = j;
				}
			}
			String temp = array.get(i);
			array.set(i, array.get(minIndex));
			array.set(minIndex, temp);
		}
		userInput = array;
	}

	private static void printArray(ArrayList<String> array) {
		for (String line : array) {
			System.out.println(line);
		}
	}
	public static void main(String[] args) {
		System.out.println("Type your input. Enter in \"-h\" if you need help.");
		Scanner in = new Scanner(System.in);
		String input = "";
		boolean reverse = false;
		boolean alphabetize = false;

		while(in.hasNextLine()) {
			input = in.nextLine();
			if (input.contains("-r")) {
				reverse = true;
				break;
			} else if (input.contains("-a")) {
				alphabetize = true;
				break;
			} else if (input.contains("-q")) {
				break;
			} else if (input.contains("-h")) {
				System.out.println("Needed some help?" + "Don't worry, the commands are: \n " 
						+ "\"-q\": end input into program\n"
						+ "\"-r\": reverse input\n"
						+ "\"-a\": alphabetize input\n");
			} else {
				userInput.add(input.toLowerCase());
			}
		}
		in.close();
		if(reverse) {
			reverse(userInput);
			printArray(userInput);
		} else if(alphabetize) {
			alphabetize(userInput);
			printArray(userInput);
		} else {
			printArray(userInput);
		}
		System.out.println("------------------------");
		System.out.println("Yup, thats all it does.");
		System.out.println("------------------------");
	}
}
