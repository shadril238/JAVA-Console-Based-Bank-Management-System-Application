package BankManagementSystem.account;

public abstract class Account implements ITransactions {
	private int accountNumber;
	protected double balance;

	public Account(){

	}
	public Account(int accountNumber,double balance){
		this.accountNumber=accountNumber;
		this.balance=balance;
	}

	public void setAccountNumber(int accountNumber){
		this.accountNumber=accountNumber;
	}
	public void setBalance(double balance){
		this.balance=balance;
	}
	public int getAccountNumber(){
		return accountNumber;
	}
	public double getBalance(){
		return balance;
	}
	public abstract void showDetails();

}
