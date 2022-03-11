package hostelmanagement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class parent {
public void parent()throws SQLException,ClassNotFoundException {
		
		java.sql.Connection con=null;
	int	f=0;
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "ahalya", "Root@123ahalya");
	Scanner sc=new Scanner(System.in);
	int c=0;
		System.out.println("Enter username");
		String username=sc.next();
		System.out.println("Enter password");
		String password=sc.next();
		Statement stmt=(Statement)con.createStatement();
		ResultSet rs=stmt.executeQuery("Select*from parents");
		
		while(rs.next()) {
			if(username.equals(rs.getString(1))&&password.equals(rs.getString(2))) {
				f=1;
			}
			
			if(f==1) {
				System.out.println("Login successfull");
				do {
					System.out.println("1.Student details");
					System.out.println("2.Add review");
					System.out.println("3.Exit");
					System.out.println("Enter your choice");
					 c=sc.nextInt();
					
					switch(c) {
					case 1:
						
						System.out.println("Enter Student_id");
						int id=sc.nextInt();
						ResultSet rd=stmt.executeQuery("Select*from student_data");
						while(rd.next())
						{
                          int is=rd.getInt(1);
                          if(is==id) {
          					f=1;
          					break;
          				}
                          }
          			if(f==1) {
          				ResultSet r=stmt.executeQuery("SELECT student_id,student_name,age,mail_id,contact_number,college,father_name,mother_name,caste_religion,marital_status,room_number,block,mess,no_of_workingdays,leavedays,attendance_percentage FROM student_data INNER JOIN attendance USING (student_id);");
    					
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
							System.out.print(r.getString(13)+"\t");
					        System.out.print(r.getInt(14)+"\t");
						    System.out.print(r.getInt(15)+"\t");
							System.out.print(r.getInt(16)+"\n");
								
							
							
						}
          			}else {
          				
          				System.out.println("Invalid student_id");
						}
						break;
					case 2:
						System.out.println("Enter the Student_id");
						int i=sc.nextInt();
						System.out.println("Enter the Student_name");
						String ns=sc.next();
						System.out.println("Add review");
						String rw=sc.next();
						PreparedStatement ps1=con.prepareStatement("insert into review(student_id,student_name,review)values(?,?,?);");
       		            ps1.setInt(1,i);
       		            ps1.setString(2, ns);
       		            ps1.setString(3, rw);
						ps1.executeUpdate();
						break;
					case 3:
						return;
						}
				}
				while(c!=0);
				}
			}

}}
