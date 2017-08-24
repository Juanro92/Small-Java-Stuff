import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class FileReverser {
    
	private void readFile() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("book.txt"));
			PrintWriter writer = new PrintWriter(new FileWriter("reader output.txt"));
			String readFromFile = "";
			String writeToFile = "";
			
			while((readFromFile = reader.readLine()) != null) {
				writeToFile = reverseWord(readFromFile);
				writer.write(writeToFile);
				writer.write("\n");
			}
			
			reader.close();
			writer.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("IOException caught.");
		}
	}
	
	private String reverseWord(String fileLine) {
		int len = fileLine.length();
		String reversed = "";
		for (int i = 0; i < len/2; i++) {
			char element = fileLine.charAt(len - i - 1);
			reversed += element;
		}
		return reversed;
	}
	
	
	public static void main(String[] args) {
		FileReverser reverser = new FileReverser();
        reverser.readFile();
        System.out.println("File should be reversed.");
	}

}
