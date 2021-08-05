package BankManagementSystem.bank;
import BankManagementSystem.employee.Employee;

public interface IEmployeeOperations {
	public void insertEmployee(Employee e);
	public void removeEmployee(Employee e);
	public void showAllEmployees();
}
