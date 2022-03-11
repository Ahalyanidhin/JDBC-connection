package hostelmanagement;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class admin {
	
	public void admin()throws SQLException,ClassNotFoundException{
		java.sql.Connection con=null;
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "ahalya", "Root@123ahalya");
		Scanner sc=new Scanner(System.in);
		int c;
		float atper=0;
		int t=0;
		System.out.println("Enter username");
		String username=sc.next();
		System.out.println("Enter password");
		String password=sc.next();
		Statement stmt=(Statement)con.createStatement();
		ResultSet rs=stmt.executeQuery("Select*from admin");
		
		while(rs.next()) {
			int f = 0;
			if(username.equals(rs.getString(1))&&password.equals(rs.getString(2))) {
				f=1;
			}
			
			if(f==1) {
				System.out.println("Login successfull");
				
				do {
					System.out.println("1.Add Student");
					System.out.println("2.Display Student details");
					System.out.println("3.Remove Student details");
					System.out.println("4.Update Student details");
					System.out.println("5.Other Details");
					System.out.println("6.View Feedback");
					System.out.println("7.Logout");
					System.out.println("Enter your choice");
				c = sc.nextInt();
					
					switch(c) {
					case 1:
						
						System.out.println("Enter Student id");
						int id=sc.nextInt();
						System.out.println("Enter Student name ");
						String name=sc.next();
						System.out.println("Enter Age");
						int age=sc.nextInt();
						System.out.println("Enter  Mail_id");
						String mail=sc.next();
						System.out.println("Enter Contact number");
						int conumber =sc.nextInt();
					    System.out.println("Enter  College");
						String college=sc.next();
						System.out.println("Father name");
						String fname=sc.next();
						System.out.println("Mother name");
						String mname=sc.next();
						System.out.println("caste/religion");
						String cstreg=sc.next();
						System.out.println("Enter  Marital status");
						String marial=sc.next();
						System.out.println("Enter Room number");
						int room=sc.nextInt();
						System.out.println("Enter the Block");
						String block=sc.next();
						System.out.println("Enter  Mess");
						String mess=sc.next();
						
						PreparedStatement ps=con.prepareStatement("insert into student_data(student_id,student_name,age,mail_id,contact_number,college,father_name,mother_name,caste_religion,marital_status,room_number,block,mess)values(?,?,?,?,?,?,?,?,?,?,?,?,?);");
						ps.setInt(1, id);
						ps.setString(2, name);
						ps.setInt(3,age);
						ps.setString(4, mail);
						ps.setInt(5, conumber);
						ps.setString(6,college);
						ps.setString(7, fname);
						ps.setString(8, mname);
						ps.setString(9, cstreg);
						ps.setString(10, marial);
						ps.setInt(11, room);
						ps.setString(12, block);
						ps.setString(13,mess);
						ps.executeUpdate();
						System.out.println("Details added successfully");
						break;
					case 2:
					
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
						break;
					case 3:
						ResultSet rr=stmt.executeQuery("Select*from student_data");
						
						while(rr.next()) {
							System.out.print(rr.getInt(1)+"\t");
							System.out.print(rr.getString(2)+"\t");
							System.out.print(rr.getInt(3)+"\t");
							System.out.print(rr.getString(4)+"\t");
							System.out.print(rr.getInt(5)+"\t");
							System.out.print(rr.getString(6)+"\t");
							System.out.print(rr.getString(7)+"\t");
							System.out.print(rr.getString(8)+"\t");
							System.out.print(rr.getString(9)+"\t");
							System.out.print(rr.getString(10)+"\t");
							System.out.print(rr.getInt(11)+"\t");
							System.out.print(rr.getString(12)+"\t");
							System.out.print(rr.getString(13)+"\n");
						}
						System.out.println("Enter the Student_id");
						int i=sc.nextInt();
						ResultSet rd=stmt.executeQuery("Select*from student_data");
						while(rd.next())
						{
                          int is=rd.getInt(1);
                          if(is==i) {
          					f=1;
          					break;
          				}
                          }
          			if(f==1) {
          				PreparedStatement ps1=con.prepareStatement("delete from student_data where student_id=?");
       		ps1.setInt(1,i);
						ps1.executeUpdate();
          			}else {
          				
          				System.out.println("Invalid student_id");
						}
						
						break;
					case 4:
						ResultSet ru=stmt.executeQuery("Select*from student_data");
						while(ru.next()) {
							System.out.print(ru.getInt(1)+"\t");
							System.out.print(ru.getString(2)+"\t");
							System.out.print(ru.getInt(3)+"\t");
							System.out.print(ru.getString(4)+"\t");
							System.out.print(ru.getInt(5)+"\t");
							System.out.print(ru.getString(6)+"\t");
							System.out.print(ru.getString(7)+"\t");
							System.out.print(ru.getString(8)+"\t");
							System.out.print(ru.getString(9)+"\t");
							System.out.print(ru.getString(10)+"\t");
							System.out.print(ru.getInt(11)+"\t");
							System.out.print(ru.getString(12)+"\t");
							System.out.print(ru.getString(13)+"\n");
						}
						System.out.println("Enter the student_id");
						int iu=sc.nextInt();
						
						ResultSet rud=stmt.executeQuery("Select*from student_data");
						while(rud.next())
						{
                          int isu=rud.getInt(1);
                          if(isu==iu) {
          					f=1;
          					break;
          				}
                          }
          			if(f==1) {
          				System.out.println("Enter Student name ");
						String name1=sc.next();
						System.out.println("Enter Age");
						int age1=sc.nextInt();
						System.out.println("Enter  Mail_id");
						String mail1=sc.next();
						System.out.println("Enter Contact number");
						int conumber1 =sc.nextInt();
					    System.out.println("Enter  College");
						String college1=sc.next();
						System.out.println("Father name");
						String fname1=sc.next();
						System.out.println("Mother name");
						String mname1=sc.next();
						System.out.println("caste/religion");
						String cstreg1=sc.next();
						System.out.println("Enter  Marital status");
						String marial1=sc.next();
						System.out.println("Enter Room number");
						int room1=sc.nextInt();
						System.out.println("Enter the Block");
						String block1=sc.next();
						System.out.println("Enter  Mess");
						String mess1=sc.next();
          				
    				 PreparedStatement ps1=con.prepareStatement("UPDATE student_data SET student_name=?,age=?,mail_id=?,contact_number=?,college=?,father_name=?,mother_name=?,caste_religion=?,marital_status=?,room_number=?,block=?,mess=? WHERE student_id=?");
       		         ps1.setInt(13,iu);
       		     
					ps1.setString(1, name1);
					ps1.setInt(2,age1);
					ps1.setString(3, mail1);
					ps1.setInt(4, conumber1);
					ps1.setString(5,college1);
					ps1.setString(6, fname1);
					ps1.setString(7, mname1);
					ps1.setString(8, cstreg1);
					ps1.setString(9, marial1);
					ps1.setInt(10, room1);
					ps1.setString(11, block1);
					ps1.setString(12,mess1);
       		         ps1.executeUpdate();
       		         System.out.println("Updated successfully");
          			}else {
          				
          				System.out.println("Invalid Student_id");
						}
						
							
						break;
					case 5:
				        System.out.println("Student_id");
 				        int id2=sc.nextInt();
                        System.out.println("no.of working days");
					    int day=sc.nextInt();
						System.out.println("Leave days");
						int lev=sc.nextInt();
			   t=day-lev;
					 double n,a = 0;
					
					   n=day;
					   a=t/n;
					    atper=(float) (a*100);
					   
						PreparedStatement ps1=con.prepareStatement("insert into attendance(student_id,no_of_workingdays,leavedays,attendance_percentage)values(?,?,?,?);");
				      	ps1.setInt(1, id2);
						
						ps1.setInt(2, day);
						ps1.setInt(3, lev);
						ps1.setFloat(4,atper);
						ps1.executeUpdate();
						System.out.println("data added successfully");
						break;
					case 6:
						ResultSet rf=stmt.executeQuery("Select*from feedback");
						while(rf.next()) {
							System.out.print(rf.getInt(1)+"\t");
							System.out.print(rf.getString(2)+"\t");
							System.out.print(rf.getString(3)+"\n");
							
							
						}
						
						break;
					case 7:
						return;
						
					}
					
					System.out.println("Invalid username or password");
					
				}while(c!=0);
				
			}
			}
	}

}
