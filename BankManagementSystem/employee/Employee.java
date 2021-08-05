package BankManagementSystem.employee;

public class Employee {
	private String name,employeeId;
	private double salary;
	public Employee(){

	}
	public Employee(String name,String employeeId,double salary){
		this.name=name;
		this.employeeId=employeeId;
		this.salary=salary;
	}

	public void setName(String name){
		this.name=name;
	}
	public void setEmployeeId(String employeeId){
		this.employeeId=employeeId;
	}   
	public void setSalary(double salary){
		this.salary=salary;
	}

	public String getName(){
		return name;
	}
	public String getEmployeeId(){
		return employeeId;
	}
	public double getSalary(){
		return salary;
	}
	public void showAllEmployees() {
		System.out.println("Employee Name : "+name+" Employee ID : "+employeeId+" Employee Salary : "+salary);
	}
}
