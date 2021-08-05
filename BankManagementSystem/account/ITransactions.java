package BankManagementSystem.account;

public interface ITransactions {
	double minAmount=500.0d;
	void deposit(double amount);
	void withdraw(double amount);
	void transfer(Account a, double amount);
}
