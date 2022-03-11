package shopping;

import java.sql.SQLException;
import java.util.Scanner;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		
	
		int ch;
		do{
			System.out.println("1.Admin");
			System.out.println("2.Customer");
			System.out.println("3.Exit");
			System.out.println("Enter your choice");
			ch=s.nextInt();
		// TODO Auto-generated method stub
		if(ch==1) {
		admin ad=new admin();
		ad.admin_login();
		}else if(ch==2) {
			customer cd=new customer();
			cd.cust_login();
		}else if(ch==3) {
			
			return;
			
		}else {
			System.out.println("Invalid input");
		}
		}while(ch!=0);
	}

}
