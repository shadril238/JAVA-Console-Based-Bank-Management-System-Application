package BankManagementSystem.bank;

import BankManagementSystem.customer.Customer;
import BankManagementSystem.employee.Employee;

public class Bank implements ICustomerOperations, IEmployeeOperations {
	public static final String bankName="VOID Bank";
	private Customer[] customers;
	private Employee[] employees;

	public Bank(){

	}
	public Bank(Customer[] customers,Employee[] employees){
		this.customers=customers;
		this.employees=employees;
	}
	public void setCustomers(Customer[] customers){
		this.customers=customers;
	}
	public void setEmployees(Employee[] employees){
		this.employees=employees;
	}

	public Customer[] getCustomers(){
		return customers;
	}
	public Employee[] getEmployees(){
		return employees;
	}

	// ICustomerOperations implementation
	
	@Override
	public void insertCustomer(Customer c) {
		for(int i=0;i<customers.length;i++) {
			if(customers[i]==null) {
				customers[i]=c;
				System.out.println("New Customer Inserted - Serial NO : "+(i+1));
				break;
			}
		}
	}
	
	@Override
	public void removeCustomer(Customer c) {
		for(int i=0;i<customers.length;i++) {
			if(customers[i]== c){
					customers[i]=null;
					System.out.println("Customer Removed !");
					break;
			}
		}
	}
	
	@Override
	public void showAllCustomers() {
		int customerSerialNo=1;
		System.out.println("");
		System.out.println("Details of All Customers --->");
		for(int i=0;i<customers.length;i++) {
			if(customers[i]!=null) {
				System.out.println("---------------------------------------------");
				System.out.println("Customer Serial NO - "+(customerSerialNo));
				System.out.println("Customer Name : "+customers[i].getName());
				System.out.println("Customer NID : "+customers[i].getNid());
				System.out.println("---------------------------------------------");	
			}	
			customerSerialNo++;
		}
		System.out.println("");
	}
	
	// IEmployeeOperations implementation

	@Override
	public void insertEmployee(Employee e) {
		for(int i=0;i<employees.length;i++) {
			if(employees[i]==null) {
				employees[i]=e;
				System.out.println("New Employee Inserted - Serial NO : "+(i+1));
				break;
			}
		}
		
	}
	
	@Override
	public void removeEmployee(Employee e) {
		for(int i=0;i<employees.length;i++) {
			if(employees[i]== e){
				employees[i]=null;
					System.out.println("Employee Removed !");
					break;
			}
		}
	}
	
	@Override
	public void showAllEmployees() {
		int employeeSerialNo=1;
		System.out.println("");
		System.out.println("Details of All Employees --->");
		for(int i=0;i<employees.length;i++) {
			if(employees[i]!=null) {
				System.out.println("---------------------------------------------");
				System.out.println("Employee Serial NO - "+(employeeSerialNo));
				System.out.println("Employee Name : "+employees[i].getName());
				System.out.println("Employee ID : "+employees[i].getEmployeeId());
				System.out.println("Employee Salary : "+employees[i].getSalary()+" Tk.");
				System.out.println("---------------------------------------------");
				
			}	
			employeeSerialNo++;
		}
		System.out.println("");
	}
}
