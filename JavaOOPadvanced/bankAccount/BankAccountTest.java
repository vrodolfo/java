public class BankAccountTest{
	public static void main(String[] args){
		BankAccount acc1 = new BankAccount();
		acc1.deposit(150000, "checking");
		acc1.deposit(250000, "savings");

		BankAccount acc2 = new BankAccount();
		acc2.deposit(20000, "checking");
		acc2.deposit(10000, "savings");

		BankAccount acc3 = new BankAccount();
		acc3.deposit(800000, "checking");
		acc3.deposit(450000, "savings");

		acc1.showTotal();
		
		acc1.showBal();
		acc2.showBal();
		acc3.showBal();

		acc1.withdraw(66666666, "checking");
		acc1.withdraw(800, "checking");
		acc1.showBal();

		acc1.showTotal();




	}
}