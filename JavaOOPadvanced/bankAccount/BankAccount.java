import java.util.*;

public class BankAccount{
	private String accNumber;
	private double checkingBal;
	private double savingsBal;
	private static int globalAcc = 0;
	private static double totalMoney = 0; 

	public void showTotal(){
		System.out.println("Total in bank: " + totalMoney);
	}

	public BankAccount(){
		accNumber = randomAccountGen();
		globalAcc++;
	}

	public double getSavingBal(){
		return savingsBal;
	}

	public double getCheckingBal(){
		return checkingBal;
	}

	public void deposit(double amount, String account){
		if(account == "checking"){
			checkingBal += amount;
		}
		else{
			savingsBal += amount;
		}
		totalMoney += amount;
	}

	public void withdraw(double amount, String account){
		if(account == "checking"){
			if(amount > checkingBal){
				System.out.println("Insufficient Funds....");
			}
			else{
				checkingBal -= amount;
				totalMoney -= amount;
				System.out.println("Here is your money....");
			}
			
		}
		else{
			if(amount > savingsBal){
				System.out.println("Insufficient Funds....");
			}
			else{
				savingsBal -= amount;
				totalMoney -= amount;
				System.out.println("Here is your money....");
			}
		}
	}

	public void showBal(){
		System.out.println("Acc...." + accNumber);
		System.out.println("Savigns Bal...." + savingsBal);
		System.out.println("Checkings Bal...." + checkingBal);
		System.out.println("********.");
	}

	private String randomAccountGen(){
		Random rand = new Random();
		String acc = "";
		int num;
		//int randomNum = rand.nextInt((max - min) + 1) + min;
		for(int i=0; i <= 10; i++){
			num = rand.nextInt((9) + 1) + 0;
			acc = acc + Integer.toString(num);
		}
		return acc;
	}


}