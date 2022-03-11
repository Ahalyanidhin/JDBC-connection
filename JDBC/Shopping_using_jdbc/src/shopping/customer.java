package shopping;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class customer {
public void cust_login()throws SQLException,ClassNotFoundException {
		
		java.sql.Connection con=null;
	int	f=0;
	
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping", "ahalya", "Root@123ahalya");
	Scanner sc=new Scanner(System.in);
	int c=0;
	double price = 0;
	double total=0;
	int id = 0;
		System.out.println("Enter username");
		String username=sc.next();
		System.out.println("Enter password");
		String password=sc.next();
		Statement stmt=(Statement)con.createStatement();
		ResultSet rs=stmt.executeQuery("Select*from customer");
		
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
							
						
							System.out.println("Enter Product name ");
							String name=sc.next();
							System.out.println("Enter Quantity");
							int qty=sc.nextInt();
							ResultSet r=stmt.executeQuery("Select*from addproduct");
							while(r.next()) {
							
								 String nm = r.getString(2);
								
								 if(name.equals(nm)) {
									 price=r.getInt(4); 
									 id=r.getInt(1);
									 
									 
								 }
							}
							 total=qty*price;
							PreparedStatement ps=con.prepareStatement("insert into product(product_name,quantity,price,total,product_id)values(?,?,?,?,?);");
							
							ps.setString(1, name);
							ps.setInt(2, qty);
							ps.setDouble(3, price);
							ps.setDouble(4, total);
							ps.setInt(5, id);
							ps.executeUpdate();
							System.out.println("Product added successfully");
							break;
						case 2:
							ResultSet r1=stmt.executeQuery("Select*from product");
							while(r1.next()) {
								System.out.print(r1.getString(1)+"\t");
								System.out.print(r1.getInt(2)+"\t");
								System.out.print(r1.getDouble(3)+"\t");
								System.out.print(r1.getDouble(4)+"\t");
								System.out.print(r1.getInt(5)+"\n");
								
							}
							break;
						case 3:
							ResultSet rr=stmt.executeQuery("Select*from product");
							while(rr.next()) {
								System.out.print(rr.getString(1)+"\t");
								System.out.print(rr.getInt(2)+"\t");
								System.out.print(rr.getDouble(3)+"\t");
								System.out.print(rr.getDouble(4)+"\t");
								System.out.print(rr.getInt(5)+"\n");
							}
							System.out.println("Enter the product name");
							String i=sc.next();
							ResultSet rd=stmt.executeQuery("Select*from product");
							while(rd.next())
							{
	                         String is=rd.getString(1);
	                          if(is==i) {
	          					f=1;
	          					break;
	          				}
	                          }
	          			if(f==1) {
	          				PreparedStatement ps1=con.prepareStatement("delete from product where product_name=?");
	       		ps1.setString(1,i);
							ps1.executeUpdate();
	          			}else {
	          				
	          				System.out.println("Invalid name");
							}
							
							break;
						case 4:
							ResultSet ru=stmt.executeQuery("Select*from product");
							while(ru.next()) {
								System.out.print(ru.getString(1)+"\t");
								System.out.print(ru.getInt(2)+"\t");
								System.out.print(ru.getDouble(3)+"\t");
								System.out.print(ru.getDouble(4)+"\t");
								System.out.print(ru.getInt(5)+"\n");
							}
							System.out.println("Enter the product id");
							int in=sc.nextInt();
							
//							
	          				System.out.println("Enter the quantity");
	          				int qt=sc.nextInt();
	          				
	          				ResultSet rub=stmt.executeQuery("Select*from addproduct");
							while(rub.next()) {
							
								int id1=rub.getInt(1);
								
								 if(in==id1) {
									 price=rub.getInt(4); 
									 
									 
									 
								 }
							}
							 total=qt*price;
	          				PreparedStatement ps1=con.prepareStatement("update product set quantity=?,price=?,total=? where product_id=?;");
	          					          				ps1.setInt(1, qt);

				             ps1.setInt(4,in);
				             ps1.setDouble(2, price);
				             ps1.setDouble(3, total);
							ps1.executeUpdate();
//	          			
//							
							break;
						case 5:
							return;
							
							
							
							}
				}while(c!=0);
				}
			}
	
}}
