package BankManagementSystem.account;

import BankManagementSystem.TransactionDetails.FileIO;

public class FixedAccount extends Account {
	private int tenureYear;
	FileIO f=new FileIO();
	public FixedAccount(){

	}
	public FixedAccount(int accountNumber,double balance,int tenureYear){
		super(accountNumber,balance);
		this.tenureYear=tenureYear;
	}

	public void setTenureYear(int tenureYear){
		this.tenureYear=tenureYear;
	}
	public int getTentureYear(){
		return tenureYear;
	}
	@Override
	public void showDetails(){
		System.out.println("Account Type : Fixed Account");
		System.out.println("Account Number : "+getAccountNumber());
		System.out.println("Account Balance : "+getBalance());
		System.out.println("Account Tenure Year : "+getTentureYear());
	}
	@Override
	public void deposit(double amount) {
		String str2="Balance before deposit : "+super.balance+" TK.";
		super.balance+=amount;
		String str="Balance "+amount+" tk deposited to account number "+super.getAccountNumber();
		String str1="New balance after deposit : "+super.balance+" TK.";
		System.out.println(str+" successfully.\n"+str1);
		f.WriteInFile("-----------------------------------------------");
		f.WriteInFile(str2+"\n"+str+"\n"+str1);
		f.WriteInFile("-----------------------------------------------");
		
	}
	@Override
	public void withdraw(double amount) {
		if((super.balance-minAmount)>=amount) {
			String str2="Balance before withdraw : "+super.balance+" TK.";
			super.balance-=amount;
			String str="Balance "+amount+" tk withdrawn from account number "+super.getAccountNumber();
			String str1="New balance after withdraw : "+super.balance+" TK.";
			System.out.println(str+" successfully.\n"+str1);
			f.WriteInFile("-----------------------------------------------");
			f.WriteInFile(str2+"\n"+str+"\n"+str1);
			f.WriteInFile("-----------------------------------------------");
		}
		else {
			System.out.println("Account balance is lower than withdraw amount ! ");
		}
	}
	@Override
	public void transfer(Account a,double amount) {
		if((super.balance-minAmount)>=amount) {
			String str2="Balance of account number "+super.getAccountNumber()+" before transfer : "+super.getBalance()+" tk.\nBalance of account number "+a.getAccountNumber()+" before transfer : "+a.getBalance()+" tk.";
			super.balance-=amount;
			a.balance+=amount;
			
			String str="Balance "+amount+" tk. has been transfarred from account number "+super.getAccountNumber()+" to account number "+a.getAccountNumber();
			String str1="Balance of account number "+super.getAccountNumber()+" after transfer : "+super.getBalance()+" tk.\nBalance of account number "+a.getAccountNumber()+" after transfer : "+a.getBalance()+" tk.";
			System.out.println(str+" successfully.\n"+str1);
			f.WriteInFile("-----------------------------------------------");
			f.WriteInFile(str2+"\n"+str+"\n"+str1+"\n");
			f.WriteInFile("-----------------------------------------------");
		}
		else {
			System.out.println("Transfer Failed ! Account balance is lower than transfer amount...\n Try again!");
		}
		
	}

}
