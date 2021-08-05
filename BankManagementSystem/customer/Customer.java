package BankManagementSystem.customer;
import BankManagementSystem.account.Account;

public class Customer implements IAccountOperations {
	private String name;
	private int nid;
	private Account accounts[]=new Account[2]; 
	public Customer(){

	}
	public Customer(String name,int nid) {
		this.name=name;
		this.nid=nid;
	}
	public Customer(String name,int nid,Account[] accounts){
		this(name,nid);
		this.accounts=accounts;
	}

	public void setName(String name){
		this.name=name;
	}
	public void setNid(int nid){
		this.nid=nid;
	}
	public void setAccounts(Account[] accounts){
		this.accounts=accounts;
	}

	public String getName(){
		return name;
	}
	public int getNid(){
		return nid;
	}
	public Account[] getAccounts(){
		return accounts;
	}
	
	//IAccountOperations implementation
	
	
	@Override
	public void insertAccount(Account acc) {
		int counter=0;
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i]==null) {
				accounts[i]=acc;
				System.out.println("New Account Inserted ...");
				break;
			}
			else if(accounts[i]!=null) {
				counter++;
			}
		}
		if(counter==accounts.length) {
			System.out.println("Account can not be inserted! One user can have only two accounts...");
		}
	}
	
	@Override
	public void removeAccount(Account acc) {
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i]== acc){
				accounts[i]=null;
				System.out.println("Account Removed !");
				break;
			}
	
		}
	}
	@Override
	public void showAllAccounts() {
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i]!=null) {
				System.out.println("---------------------------------------------");
				accounts[i].showDetails();
				System.out.println("---------------------------------------------");	
			}	
		}
		System.out.println("");
	}

}
