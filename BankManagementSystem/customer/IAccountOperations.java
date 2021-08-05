package BankManagementSystem.customer;
import BankManagementSystem.account.Account;

public interface IAccountOperations{
	public void insertAccount(Account acc);	
	public void removeAccount(Account acc);
	public void showAllAccounts();
}
