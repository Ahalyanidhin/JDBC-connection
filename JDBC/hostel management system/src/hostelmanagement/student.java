package hostelmanagement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class student {
	
	public void student()throws SQLException,ClassNotFoundException{
		java.sql.Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "ahalya", "Root@123ahalya");
		Scanner sc=new Scanner(System.in);
		int c;
		String n2 = null;
		
		System.out.println("Enter username");
		String username=sc.next();
		System.out.println("Enter password");
		String password=sc.next();
		Statement stmt=(Statement)con.createStatement();
		ResultSet rs=stmt.executeQuery("Select*from student");
		
		while(rs.next()) {
			int f = 0;
			if(username.equals(rs.getString(1))&&password.equals(rs.getString(2))) {
				f=1;
			}
			
			if(f==1) {
				System.out.println("Login successfull");
				
				do {
					
					System.out.println("1.Display Student details");
					System.out.println("2.Attendance details");
					System.out.println("3.Student Feedback");
					System.out.println("4.Logout");
					System.out.println("Enter your choice");
				    c = sc.nextInt();
					
					switch(c) {
					case 1:
						
						ResultSet r=stmt.executeQuery("Select*from student_data");
						while(r.next()) {
							System.out.print(r.getInt(1)+"\t");
							System.out.print(r.getString(2)+"\t");
							System.out.print(r.getInt(3)+"\t");
							System.out.print(r.getString(4)+"\t");
							System.out.print(r.getInt(5)+"\t");
							System.out.print(r.getString(6)+"\t");
							System.out.print(r.getString(7)+"\t");
							System.out.print(r.getString(8)+"\t");
							System.out.print(r.getString(9)+"\t");
							System.out.print(r.getString(10)+"\t");
							System.out.print(r.getInt(11)+"\t");
							System.out.print(r.getString(12)+"\t");
							System.out.print(r.getString(13)+"\n");
							
						}
						break;
					case 2:
						ResultSet r1=stmt.executeQuery("Select*from attendance");
						while(r1.next()) {
							System.out.print(r1.getInt(1)+"\t");
							System.out.print(r1.getInt(2)+"\t");
							System.out.print(r1.getInt(3)+"\t");
							System.out.print(r1.getFloat(4)+"\n");
						}
						
						
						break;
					case 3:
						
						System.out.println("Enter the Student_id");
						int i=sc.nextInt();
						System.out.println("Enter the Student_name");
						String ns=sc.next();
						System.out.println("Enter the Student Feedback");
						String fd=sc.next();
						PreparedStatement ps1=con.prepareStatement("insert into feedback(student_id,student_name,feedback)values(?,?,?);");
       		            ps1.setInt(1,i);
       		            ps1.setString(2, ns);
       		            ps1.setString(3, fd);
						ps1.executeUpdate();
						
						
						
						break;
					case 4:
						return;
						
					}
					}while(c!=0);
				}
			}
	}

	
}

			
