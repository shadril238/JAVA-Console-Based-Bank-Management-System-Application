package BankManagementSystem.bank;
import BankManagementSystem.customer.Customer;

public interface ICustomerOperations {
	public void insertCustomer(Customer c);
	public void removeCustomer(Customer c);
	public void showAllCustomers();
}
