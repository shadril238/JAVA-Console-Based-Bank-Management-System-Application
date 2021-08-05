package BankManagementSystem;

import java.util.Scanner;
import BankManagementSystem.TransactionDetails.FileIO;
import BankManagementSystem.account.Account;
import BankManagementSystem.account.FixedAccount;
import BankManagementSystem.account.SavingsAccount;
import BankManagementSystem.bank.Bank;
import BankManagementSystem.bank.IEmployeeOperations;
import BankManagementSystem.customer.Customer;
import BankManagementSystem.employee.Employee;
import BankManagementSystem.security.LogIn;
import java.io.*;


public class BankMain {
	
	//main method
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		Employee emp1=new Employee("Shadril","20-42451-1",50000.0d);
		Employee emp2=new Employee("Shifat","20-42444-2",40000.0d);
		Employee emp3=new Employee("Hassan","20-42415-1",45000.0d);
		Employee emp4=new Employee("Pritom","20-123425-3",45000.0d);
		Employee emp5=new Employee("Aftab","10-12345-1",65000.0d);
		Employee emp6=new Employee("Prithy","20-23444-1",47000.0d);
		Employee emp7=new Employee("Piash","20-56778-1",52000.0d);
		
		Employee empArray[]=new Employee[30]; //Assume in VOID Bank there are 30 employees
		empArray[0]=emp1;
		empArray[1]=emp2;
		empArray[2]=emp3;
		empArray[3]=emp4;
		empArray[4]=emp5;
		empArray[5]=emp6;
		empArray[6]=emp7;

    	Customer customer=new Customer();
		
		Customer cst1=new Customer("Nehal",2012412);
		Customer cst2=new Customer("Pritom",301323);
		Customer cst3=new Customer("Apon",456745);
		Customer cst4=new Customer("Sardar",23456);
		Customer cst5=new Customer("Rafayet",12543);
		Customer cst6=new Customer("Farid",29876);
		Customer[] arrCust=new Customer[1000];
		arrCust[0]=cst1;
		arrCust[1]=cst2;
		arrCust[2]=cst3;
		arrCust[3]=cst4;
		arrCust[4]=cst5;
		arrCust[5]=cst6;
		
		Bank bank=new Bank(arrCust,empArray);
		bank.setCustomers(arrCust);
		
	    LogIn login=new LogIn();//Log In
		
		System.out.println(" ");
		System.out.println("Welcome to VOID Bank ");
		System.out.println("Logged In as, Human - ");
		
		int exception=0;
		int decision=0;
		
		while(true) {
			System.out.println(" ");
			System.out.println("User Options:-");
			System.out.println("\t 1.Employee Management\t\t 2.Customer Management");
			System.out.println("\t 3.Customer Account Management\t 4.Account Transactions");
			System.out.println("\t 5.Log Out");
			System.out.println("");

			while(true) {
				System.out.print("Enter choice :");
				Scanner input=new Scanner(System.in);
				try {
					decision=input.nextInt();
					break;
				}catch(Exception e) {
					System.out.println("Please enter an integer number...");
					System.out.println("");
				}
			}
			
			switch(decision) {
			case(1):{
				System.out.println("Options for Employee Management :");
				System.out.println("\t 1.Insert New Employee\t 2.Remove Existing Employee\t 3.Show All Employees");
				while(true) {
					System.out.print("Enter choice :");
					Scanner input=new Scanner(System.in);
					try {
						decision=input.nextInt();
						break;
					}catch(Exception e) {
						System.out.println("Please enter an integer number...");
						System.out.println("");
					}
				}
				switch(decision) {
				case(1):{
					String name=null,id=null;
					double salary=0d;
					while(true) {
						System.out.print("Enter Employee Name : ");
						Scanner input=new Scanner(System.in);
						try {
							name=input.nextLine();
							break;
						}catch(Exception e) {
							System.out.println("Invalid Input...");
							System.out.println("");
						}	
					}
					while(true) {
						System.out.print("Enter Employee ID : ");
						Scanner input=new Scanner(System.in);
						try {
							id=input.nextLine();
							break;
						}catch(Exception e) {
							System.out.println("Invalid Input...");
							System.out.println("");
						}	
					}
					
					while(true) {
						System.out.print("Enter Employee Salary : ");
						Scanner input=new Scanner(System.in);
						try {
							salary=input.nextDouble();
							break;
						}catch(Exception e) {
							System.out.println("Invalid Input...");
							System.out.println("");
						}	
					}
					Employee insertEmployee=new Employee(name,id,salary);
					bank.insertEmployee(insertEmployee);
					//insertNewEmployee;
					break;
				}
				case(2):{
					int removeEmployeeFlag=0;
					System.out.print("Which employee do you want to remove? Enter employee ID : ");
					String id=sc.nextLine();
					for(int i=0;i<bank.getEmployees().length;i++){
						if(bank.getEmployees()[i]!=null) {
							if(bank.getEmployees()[i].getEmployeeId().equals(id)) {
								bank.removeEmployee(bank.getEmployees()[i]);
								break;
							}
							else{
								removeEmployeeFlag++;
							}
						}       
						else if(bank.getEmployees()[i]==null) {
							removeEmployeeFlag++;
						}
					}
					if(removeEmployeeFlag==bank.getEmployees().length) {
						System.out.println("Employee ID not matched...");
						break;
					}
					break;
				}
				case(3):{
					bank.showAllEmployees();
					//showAllEmployees();
					break;
				}
				default:
					System.out.println("Wrong Input...");
				}
				break;
			}
				
			case(2):{
				System.out.println("Options for Customer Management :");
				System.out.println("\t 1.Insert New Customer\t 2.Remove Existing Customer\t 3.Show All Customers");
				while(true) {
					System.out.print("Enter choice :");
					Scanner input=new Scanner(System.in);
					try {
						decision=input.nextInt();
						break;
					}catch(Exception e) {
						System.out.println("Please enter an integer number...");
						System.out.println("");
					}
				}
				switch(decision) {
				case(1):{
					
					String name=null;
					int nid=0;
					while(true) {
						System.out.print("Enter Customer Name : ");
						Scanner input=new Scanner(System.in);
						try {
							name=input.nextLine();
							break;
						}catch(Exception e) {
							System.out.println("Invalid Input...");
							System.out.println("");
						}	
					}
					while(true) {
						System.out.print("Enter Customer NID : ");
						Scanner input=new Scanner(System.in);
						try {
							nid=input.nextInt();
							break;
						}catch(Exception e) {
							System.out.println("Invalid Input...");
							System.out.println("");
						}	
					}
					Customer insertCustomer=new Customer(name,nid);
					bank.insertCustomer(insertCustomer);
					
					//insertNewCustomer();
					break;
				}
				case(2):{
					
					int removeCustomerFlag=0;
					int nid=0;
					while(true) {
						Scanner input=new Scanner(System.in);
						System.out.print("Which customer do you want to remove? Enter NID number of the customer : ");
						try {
							nid=input.nextInt();
							break;
						}catch(Exception e) {
							System.out.println("Invalid Input...");
							System.out.println("");
						}
					}
			
					for(int i=0;i<bank.getCustomers().length;i++){
						if(bank.getCustomers()[i]!=null) {
							if(bank.getCustomers()[i].getNid()==nid) {
								bank.removeCustomer(bank.getCustomers()[i]);
								break;
							}
							else if(bank.getCustomers()[i].getNid()!=nid){
								removeCustomerFlag++;
							}
						}       
						else if(bank.getCustomers()[i]==null) {
							removeCustomerFlag++;
						}
					}
					if(removeCustomerFlag==bank.getCustomers().length) {
						System.out.println("NID not matched...");
						break;
					}
					break;
				}
				case(3):{
					bank.showAllCustomers();
					break;
				}
				default:
					System.out.println("Wrong Input...");
				}
				break;
			}
			case(3):{
				System.out.println("Options for Customer Account Management :");
				System.out.println("\t 1.Insert New Account\t 2.Remove Existing Account\t 3.Show All Accounts");
				while(true) {
					System.out.print("Enter choice :");
					Scanner input=new Scanner(System.in);
					try {
						decision=input.nextInt();
						break;
					}catch(Exception e) {
						System.out.println("Please enter an integer number...");
						System.out.println("");
					}
				}
				switch(decision) {
				case(1):{
					int nid=0;
					int accountManagementCounter=0;
					while(true) {
						System.out.print("Enter customer NID : ");
						Scanner input=new Scanner(System.in);
						try {
							nid=input.nextInt();
							break;
						}catch(Exception e) {
							System.out.println("Invalid Input...");
							System.out.println("");
						}
					}
						for(int i=0;i<bank.getCustomers().length;i++) {
							if(bank.getCustomers()[i]!=null) {
								if(bank. getCustomers()[i].getNid()==nid) {
									System.out.println("");
									System.out.println("Customer found...");
									System.out.println("Customer Name : "+bank.getCustomers()[i].getName());
									System.out.println("Which type of account do you want to create?\n\t 1. Savings Account\n\t 2. Fixed Account");
									while(true) {
										System.out.print("Enter Choice : ");
										Scanner input=new Scanner(System.in);
										try {
											decision=input.nextInt();
											break;
										}catch(Exception e) {
											System.out.println("Invalid Input...");
											System.out.println("");
										}
									}
									switch(decision) {
									case(1):{
										int accNum=0;
										double amount=0d,interestRate=0d;
										
										while(true) {
											System.out.print("Enter account number : ");
											Scanner input=new Scanner(System.in);
											try {
												accNum=input.nextInt();
												break;
											}catch(Exception e) {
												System.out.println("Account number not valid...Enter integer as account number...");
												System.out.println("");
											}
										}
										
										while(true) {
											System.out.print("Enter balance : ");
											Scanner input=new Scanner(System.in);
											try {
												amount=input.nextDouble();
												break;
											}catch(Exception e) {
												System.out.println("Amount not valid...Enter double as amount...");
												System.out.println("");
											}
										}
										while(true) {
											System.out.print("Enter interest rate : ");
											Scanner input=new Scanner(System.in);
											try {
												interestRate=input.nextDouble();
												break;
											}catch(Exception e) {
												System.out.println("Intesest rate not valid...Enter double as account number...");
												System.out.println("");
											}
										}
										Account sa=new SavingsAccount(accNum,amount,interestRate);
										bank.getCustomers()[i].insertAccount(sa);// Savings Account Inserted
										break;
									}
									case(2):{
										int accNum=0,tenureYear=0;
										double amount=0d;
										
										while(true) {
											System.out.print("Enter account number : ");
											Scanner input=new Scanner(System.in);
											try {
												accNum=input.nextInt();
												break;
											}catch(Exception e) {
												System.out.println("Account number not valid...Enter integer as account number...");
												System.out.println("");
											}
										}
										
										while(true) {
											System.out.print("Enter balance : ");
											Scanner input=new Scanner(System.in);
											try {
												amount=input.nextDouble();
												break;
											}catch(Exception e) {
												System.out.println("Amount not valid...Enter double as amount...");
												System.out.println("");
											}
										}
										while(true) {
											System.out.print("Enter tenure year : ");
											Scanner input=new Scanner(System.in);
											try {
												tenureYear=input.nextInt();
												break;
											}catch(Exception e) {
												System.out.println("Tenure year not valid...Enter integer as tenure year...");
												System.out.println("");
											}
										}
										Account fa=new FixedAccount(accNum,amount,tenureYear);
										bank.getCustomers()[i].insertAccount(fa);//Fixed account inserted
										break;
									}
									}
									break;
								}
								else {
									accountManagementCounter++;
								}
							}
							else if(bank.getCustomers()[i]==null) {
								accountManagementCounter++;
							}
						}
						if(accountManagementCounter==bank.getCustomers().length) {
							System.out.println("Customer not found...");
						}

					//insertNewAccount();
					break;
				}
				case(2):{
					int accNo = 0,x=0;
					int removeAccCounter1=0,removeAccCounter2=0;
					while(true) {
						System.out.print("Which account do you want to remove? Enter the Account Number : ");
						Scanner input=new Scanner(System.in);
						try {
							accNo=input.nextInt();
							break;
						}catch(Exception e) {
							System.out.println("Invalid Input...");
						}						
					}
					for(int i=0;i<bank.getCustomers().length;i++) {
						if(bank.getCustomers()[i]!=null) {
							for(int j=0;j<bank.getCustomers()[i].getAccounts().length;j++) {
								if(bank.getCustomers()[i].getAccounts()[j]!=null) {
									if(bank.getCustomers()[i].getAccounts()[j].getAccountNumber()==accNo) {
										bank.getCustomers()[i].removeAccount(bank.getCustomers()[i].getAccounts()[j]);//remove account
										x++;
										break;
									}
									else {
										removeAccCounter1=i+1;
										removeAccCounter1=j+1;
										
									}
								}
								else if(bank.getCustomers()[i].getAccounts()[j]==null) {
									removeAccCounter1=i+1;
									removeAccCounter1=j+1;
								}
								if(x==1) {
									break;
								}
							}	
							if(x==1) {
								break;
							}
						}
						else if(bank.getCustomers()[i]==null) {
							removeAccCounter1=i+1;
						}
					}			
					if((bank.getCustomers().length*customer.getAccounts().length)==removeAccCounter1*removeAccCounter2 || bank.getCustomers().length==removeAccCounter1) {
						System.out.println("Account Number not found...");
					}
					//removeExistingAccount();
					break;
				}
				case(3):{
					for(int i=0;i<bank.getCustomers().length;i++) {
						if(bank.getCustomers()[i]!=null) {
							bank.getCustomers()[i].showAllAccounts();
						}
					}
					
					break;
				}
				default:
					System.out.println("Wrong Input...");
				}
				break;
			}
			case(4):{
				System.out.println("Options for Account Transactions :");
				System.out.println("\t 1.Deposit Money\t 2.Withdraw Money\t 3.Transfer Money\t 4.Show Transaction History");
				while(true) {
					System.out.print("Enter choice :");
					Scanner input=new Scanner(System.in);
					try {
						decision=input.nextInt();
						break;
					}catch(Exception e) {
						System.out.println("Please enter an integer number...");
						System.out.println("");
					}
				}
				switch(decision) {
				case(1):{
					int accNo=0,nid=0;
					double amt=0d;
					boolean counter=false;
					while(true) {
						System.out.print("Enter Account Number : ");
						Scanner input=new Scanner(System.in);
						try {
							accNo=input.nextInt();
							break;
						}catch(Exception e) {
							System.out.println("Invalid input...");
							System.out.println("");
						}
					}
					while(true) {
						System.out.print("Enter NID Number : ");
						Scanner input=new Scanner(System.in);
						try {
							nid=input.nextInt();
							break;
						}catch(Exception e) {
							System.out.println("Invalid input...");
							System.out.println("");
						}
					}
					for(int i=0;i<bank.getCustomers().length;i++) {
						if(counter==true){
							break;
						}
						if(bank.getCustomers()[i]!=null) {
							for(int j=0;j<bank.getCustomers()[i].getAccounts().length;j++) {
								if(counter==true){
									break;
								}
								if(bank.getCustomers()[i].getAccounts()[j]!=null) {
									if(bank.getCustomers()[i].getAccounts()[j].getAccountNumber()==accNo && bank.getCustomers()[i].getNid()==nid) {
										System.out.println("Account found...");
										System.out.println("Name of customer of the account : "+bank.getCustomers()[i].getName());
										System.out.println("");
										while(true) {
											System.out.print("How much amount do you want to deposit : ");
											Scanner input=new Scanner(System.in);
											try {
												amt=input.nextDouble();
												break;
											}catch(Exception e) {
												System.out.println("Invalid input...");
												System.out.println("");
											}
										}
										bank.getCustomers()[i].getAccounts()[j].deposit(amt); //Deposited
										counter=true;
										break;
									}
									else {
										
									}
								}
								else if(bank.getCustomers()[i].getAccounts()[j]==null) {
									
								}
								
							}
						}
						else if(bank.getCustomers()[i]!=null) {
							
						}
						
					}
					if(counter==false){
						System.out.println("NID and Account Number not matched or Account not found...");
					}
					//depositMoney;
					break;
				}
				case(2):{   
					int accNo=0,nid=0;
					double amt=0d;
					boolean counter=false;
					while(true) {
						System.out.print("Enter Account Number : ");
						Scanner input=new Scanner(System.in);
						try {
							accNo=input.nextInt();
							break;
						}catch(Exception e) {
							System.out.println("Invalid input...");
							System.out.println("");
						}
					}
					while(true) {
						System.out.print("Enter NID Number : ");
						Scanner input=new Scanner(System.in);
						try {
							nid=input.nextInt();
							break;
						}catch(Exception e) {
							System.out.println("Invalid input...");
							System.out.println("");
						}
					}
					for(int i=0;i<bank.getCustomers().length;i++) {
						if(counter==true){
							break;
						}
						if(bank.getCustomers()[i]!=null) {
							for(int j=0;j<bank.getCustomers()[i].getAccounts().length;j++) {
								if(counter==true){
									break;
								}
								if(bank.getCustomers()[i].getAccounts()[j]!=null) {
									if(bank.getCustomers()[i].getAccounts()[j].getAccountNumber()==accNo && bank.getCustomers()[i].getNid()==nid) {
										System.out.println("Account found...");
										System.out.println("Name of customer of the account : "+bank.getCustomers()[i].getName());
										System.out.println("");
										while(true) {
											System.out.print("How much amount do you want to withdraw : ");
											Scanner input=new Scanner(System.in);
											try {
												amt=input.nextDouble();
												break;
											}catch(Exception e) {
												System.out.println("Invalid input...");
												System.out.println("");
											}
										}
										bank.getCustomers()[i].getAccounts()[j].withdraw(amt);; //Withdraw
										counter=true;
										break;
									}
									else {
										
									}
								}
								else if(bank.getCustomers()[i].getAccounts()[j]==null) {
									
								}
							}
						}
						else if(bank.getCustomers()[i]!=null) {
							
						}
					}
					if(counter==false){
						System.out.println("NID and Account Number not matched or Account not found...");
					}
					//withdrawMoney;
					break;
				}
				case(3):{
					
					int accNo=0,nid=0;
					double amt=0d,wAccNo=0;
					boolean counter1=false,counter2=false;
					while(true) {
						System.out.print("Enter Sender's Account Number : ");
						Scanner input=new Scanner(System.in);
						try {
							accNo=input.nextInt();
							break;
						}catch(Exception e) {
							System.out.println("Invalid input...");
							System.out.println("");
						}
					}
					while(true) {
						System.out.print("Enter NID Number : ");
						Scanner input=new Scanner(System.in);
						try {
							nid=input.nextInt();
							break;
						}catch(Exception e) {
							System.out.println("Invalid input...");
							System.out.println("");
						}
					}
					
					for(int i=0;i<bank.getCustomers().length;i++) {
						if(counter1==true){
							break;
						}
						if(bank.getCustomers()[i]!=null) {
							for(int j=0;j<bank.getCustomers()[i].getAccounts().length;j++) {
								if(counter1==true){
									break;
							}
								if(bank.getCustomers()[i].getAccounts()[j]!=null) {
									if(bank.getCustomers()[i].getAccounts()[j].getAccountNumber()==accNo && bank.getCustomers()[i].getNid()==nid) {
										System.out.println("Account found...");
										System.out.println("Name of customer of the account : "+bank.getCustomers()[i].getName());
										counter1=true;
										System.out.println("");
										while(true) {
											System.out.print("Enter Reciever Account Number : ");
											Scanner input=new Scanner(System.in);
											try {
												wAccNo=input.nextDouble();
												break;
											}catch(Exception e) {
												System.out.println("Invalid input...");
												System.out.println("");
											}
										}
										for(int k=0;k<bank.getCustomers().length;k++) {
											if(counter2==true){
												break;
											}
											if(bank.getCustomers()[k]!=null) {
												for(int l=0;l<bank.getCustomers()[k].getAccounts().length;l++) {
													if(counter2==true){
														break;
													}
													if(bank.getCustomers()[k].getAccounts()[l]!=null) {
														if(bank.getCustomers()[k].getAccounts()[l].getAccountNumber()==wAccNo) {
															while(true) {
																System.out.print("Enter amount you want to transfer : ");
																Scanner input=new Scanner(System.in);
																try {
																	amt=input.nextDouble();
																	break;
																}catch(Exception e) {
																	System.out.println("Invalid Input...");
																	System.out.println("");
																}
															}
															//System.out.println("Amount "+amt+" transferred from account No - "+bank.getCustomers()[i].getAccounts()[j].getAccountNumber()+" to account no - "+bank.getCustomers()[i].getAccounts()[j].getAccountNumber()+" successfully!");
															bank.getCustomers()[i].getAccounts()[j].transfer(bank.getCustomers()[k].getAccounts()[l], amt);//transfer
															counter2=true;
															break;
														}
														else {
															
														}
													}
													else if(bank.getCustomers()[k].getAccounts()[l]==null) {
														
													}
													
												}
											}
											
											else if(bank.getCustomers()[k]==null) {
												
											}
											
										}
										if(counter2==false){
											System.out.println("Reciever Account not found...");
											break;
										}
									}
									else {
										
									}
								}
								else if(bank.getCustomers()[i].getAccounts()[j]==null) {
									
								}
								
							}
						}
						else if(bank.getCustomers()[i]!=null) {
							
						}
						
					}
					if(counter1==false){
						System.out.println("Sender Account not found...");
					}
					//transferMoney();
					break;
				}
				case(4):{
					FileIO f=new FileIO();
					System.out.println("");
					System.out.println("Transaction History -->");
					System.out.println("");
					f.ReadFromFile();
					System.out.println("");
					break;
				}
				default:
					System.out.println("Wrong Input...");
				}
				break;
			}
			case(5):{
				System.out.println("Successfully Logged Out...");
				System.exit(0);
				
			}
			default:
				System.out.println("Invalid Input...");
				break;
			}
		}
	}
}

