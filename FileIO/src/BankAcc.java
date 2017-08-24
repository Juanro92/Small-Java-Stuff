import java.io.Serializable;

public class BankAcc implements Serializable{
	String name;
	String email;
	String account;
	int pin;
	
	public void createAccount() {
		System.out.format("Creating an account number %s under the name %s with the email: %s.\n", account, name, email);
		
	}
}
