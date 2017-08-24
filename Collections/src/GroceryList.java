import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class GroceryList {
	
	
	public static LinkedList<String> linkedList = new LinkedList<>(); 
	
	public void getGroceries() {
		System.out.println("Enter in your groceries, type -q to end input.");
		Scanner scan = new Scanner(System.in);
		while (scan.hasNextLine()) {
			String grocery = scan.nextLine();
			if (grocery.contains("-q")) {
				break;
			} else {
				linkedList.add(grocery);
			}
		}
	}
	
	public LinkedList<String> quickSort(LinkedList<String> list){
		if(!list.isEmpty()) {
			String pivot = list.get(0);
			LinkedList<String> before = new LinkedList<>();
			LinkedList<String> current = new LinkedList<>();
			LinkedList<String> after = new LinkedList<>();
			
			for (String word : list) {
				if (word.compareTo(pivot) < 0) {
					before.add(word);
				} else if (word.compareTo(pivot) > 0 ) {
					after.add(word);
				} else {
					current.add(word);
				}
			}
			
			before = quickSort(before);
			after = quickSort(after);
			
			before.addAll(current);
			before.addAll(after);
			return before;
		}
		return list;
	}
    
	public void exportGroceries() {
		try {
			PrintWriter printWriter = new PrintWriter("Files\\Groceries.txt");
			for (String line : linkedList) {
				printWriter.println(line);
				printWriter.flush();
			}
			printWriter.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		}
		
	}
	public static void main(String[] args) {
		GroceryList objList = new GroceryList();
		objList.getGroceries();
		linkedList = objList.quickSort(linkedList);
		objList.exportGroceries();

	}

}
