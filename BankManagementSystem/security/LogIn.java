package BankManagementSystem.security;
import java.util.Scanner;
public class LogIn {
	Scanner sc=new Scanner(System.in);
	public LogIn() {
		System.out.println("Log In ID : admin\nPassword : admin\n");
		System.out.println("********** Log In **********");
		int loginTime=2;
		while(loginTime+1>0) {
			System.out.print("Enter your Log In ID : ");
			String adminId=sc.nextLine();
			System.out.print("Enter your password : ");
			String adminPass=sc.nextLine();
			String admin="admin";
			if(adminId.equals(admin) && adminPass.equals(admin)) {
				System.out.println("Successfully Logged In ...");
				break;
			}
			else if(adminId.equals(admin) && !(adminPass.equals(admin))){
				System.out.println("You've Entered Wrong Password...Please Try again ! ");
				if(loginTime==0) {
					System.out.println("");
					System.out.println("You've Entered Invalid ID or Password 3 Times...Please Run The Program Again & Try Again With Valid Log In ID and Password...");
					System.exit(0); 			
				}
				System.out.println("You've "+loginTime+" times left...");
			}
			else if(adminPass.equals(admin) && !(adminId.equals(admin))) {
				System.out.println("You've Entered Wrong Log In ID...Please Try again ! ");
				if(loginTime==0) {
					System.out.println("");
					System.out.println("You've Entered Invalid ID or Password 3 Times...Please Run The Program Again & Try Again With Valid Log In ID and Password...");
					System.exit(0); 			
				}
				System.out.println("You've "+loginTime+" times left...");
			}
			else {
				System.out.println("You've Entered Wrong Log In ID and Wrong Password...Please Try again ! ");
				if(loginTime==0) {
					System.out.println("");
					System.out.println("You've Entered Invalid ID or Password 3 Times...Please Run The Program Again & Try Again With Valid Log In ID and Password...");
					System.exit(0); 			
				}
				System.out.println("You've "+loginTime+" times left...");
			}
			loginTime--;
		}
	}
}
