package shopping;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class admin {
public void admin_login()throws SQLException,ClassNotFoundException {
		
		java.sql.Connection con=null;
	int	f=0;
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping", "ahalya", "Root@123ahalya");
	Scanner sc=new Scanner(System.in);
	int c=0;
		System.out.println("Enter username");
		String username=sc.next();
		System.out.println("Enter password");
		String password=sc.next();
		Statement stmt=(Statement)con.createStatement();
		ResultSet rs=stmt.executeQuery("Select*from admin");
		
		while(rs.next()) {
			if(username.equals(rs.getString(1))&&password.equals(rs.getString(2))) {
				f=1;
			}
			
			if(f==1) {
				System.out.println("Login successfull");
				do {
					System.out.println("1.Add product");
					System.out.println("2.Display");
					System.out.println("3.Remove product");
					System.out.println("4.Update product");
					System.out.println("5.Logout");
					System.out.println("Enter your choice");
					 c=sc.nextInt();
					
					switch(c) {
					case 1:
						
						System.out.println("Enter Product id");
						int id=sc.nextInt();
						System.out.println("Enter Product name ");
						String name=sc.next();
						System.out.println("Enter Quantity");
						int qty=sc.nextInt();
						System.out.println("Enter Price");
						double price=sc.nextDouble();
						PreparedStatement ps=con.prepareStatement("insert into addproduct(product_id,product_name,quantity,price)values(?,?,?,?);");
						ps.setInt(1, id);
						ps.setString(2, name);
						ps.setInt(3, qty);
						ps.setDouble(4, price);
						ps.executeUpdate();
						System.out.println("Product added successfully");
						break;
					case 2:
						ResultSet r=stmt.executeQuery("Select*from addproduct");
						while(r.next()) {
							System.out.print(r.getInt(1)+"\t");
							System.out.print(r.getString(2)+"\t");
							System.out.print(r.getInt(3)+"\t");
							System.out.print(r.getDouble(4)+"\n");
							
						}
						break;
					case 3:
						ResultSet rr=stmt.executeQuery("Select*from addproduct");
						while(rr.next()) {
							System.out.print(rr.getInt(1)+"\t");
							System.out.print(rr.getString(2)+"\t");
							System.out.print(rr.getInt(3)+"\t");
							System.out.print(rr.getDouble(4)+"\n");
						}
						System.out.println("Enter the index number");
						int i=sc.nextInt();
						ResultSet rd=stmt.executeQuery("Select*from addproduct");
						while(rd.next())
						{
                          int is=rd.getInt(1);
                          if(is==i) {
          					f=1;
          					break;
          				}
                          }
          			if(f==1) {
          				PreparedStatement ps1=con.prepareStatement("delete from addproduct where product_id=?");
       		ps1.setInt(1,i);
						ps1.executeUpdate();
          			}else {
          				
          				System.out.println("Invalid index number");
						}
						
						break;
					case 4:
						ResultSet ru=stmt.executeQuery("Select*from addproduct");
						while(ru.next()) {
							System.out.print(ru.getInt(1)+"\t");
							System.out.print(ru.getString(2)+"\t");
							System.out.print(ru.getInt(3)+"\t");
							System.out.print(ru.getDouble(4)+"\n");
						}
						System.out.println("Enter the index number");
						int iu=sc.nextInt();
						
						ResultSet rud=stmt.executeQuery("Select*from addproduct");
						while(rud.next())
						{
                          int isu=rud.getInt(1);
                          if(isu==iu) {
          					f=1;
          					break;
          				}
                          }
          			if(f==1) {
          				 System.out.println("Enter the product_name");
    			         String uname=sc.next();
    			         System.out.println("Enter the quantity");
    			         Double uqty=sc.nextDouble();
    			         System.out.println("Enter the price");
    				     Double uprice=sc.nextDouble();
          				
    				 PreparedStatement ps1=con.prepareStatement("UPDATE addproduct SET product_name=?, quantity=?,price=? WHERE product_id=?");
       		         ps1.setInt(4,iu);
      			     ps1.setString(1,uname);
			         ps1.setDouble(2,uqty);
			         ps1.setDouble(3,uprice);
       		         ps1.executeUpdate();
       		         System.out.println("Updated successfully");
          			}else {
          				
          				System.out.println("Invalid index name");
						}
						
							
						break;
					case 5:
						return;
						
					}
					
					
					
				}while(c!=0);
				System.out.println("Invalid username or password");
			}
		}
	}
	
}
