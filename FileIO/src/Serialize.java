import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.UUID;

public class Serialize {
    public static void shipObject(BankAcc account) {
    	try {
			account.createAccount();
			String fileExtension = "/"+account.name + ".ser";
			File newFile = new File(fileExtension);
			FileOutputStream output = new FileOutputStream(newFile);
			ObjectOutputStream objOutput = new ObjectOutputStream(output);
			objOutput.writeObject(account);
			objOutput.flush();
			objOutput.close();
			output.close();
			System.out.println("The object is in " + account.name + ".ser");
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
		} catch (IOException e) {
			System.out.println("IOException.");
		}
    }
	public static void main(String[] args) {
		BankAcc bank = new BankAcc();
		Scanner scan = new Scanner(System.in);
		System.out.println("Type in your name.");
		bank.name = scan.nextLine();
		System.out.println("Type in your email.");
		bank.email = scan.nextLine();
		System.out.println("Type in your pin number.");
		bank.pin = scan.nextInt();
		UUID id = UUID.randomUUID();
		bank.account = id.toString();
		
		shipObject(bank);
		scan.close();
	}

}
