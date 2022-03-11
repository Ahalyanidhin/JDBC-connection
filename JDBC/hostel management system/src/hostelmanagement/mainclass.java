package hostelmanagement;

import java.sql.SQLException;
import java.util.Scanner;


public class mainclass {
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		Scanner s=new Scanner(System.in);
		
		
		int ch;
		do{
			System.out.println("1.Admin");
			System.out.println("2.Student");
			System.out.println("3.Parent");
			System.out.println("4.Exit");
			System.out.println("Enter your choice");
			ch=s.nextInt();
		// TODO Auto-generated method stub
		if(ch==1) {
		admin ad=new admin();
		ad.admin();
		}else if(ch==2) {
			student sd=new student();
			sd.student();
		}
	    else if(ch==3) {
	    	
	    	parent p=new parent();
	    	p.parent();
		}
	    else if(ch==4) {
		return;
			
		}else {
			System.out.println("Invalid input");
		}
		}while(ch!=0);
	}

}
