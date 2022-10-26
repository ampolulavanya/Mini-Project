package student_management_system;

import java.sql.*;
import java.util.Scanner;

public class SMS_Program 
{
	public static void main(String[] args) 
	{
 int choice = 0;
 
   while(choice!=8008)
   {
	   System.out.println("Welcome to SMS(Student Management System)");
	   System.out.println("Please Aunthenticate System"); 
	   
	 System.out.println("Enter Choice : \n 1: Login \n 2: Signup \n 3: Exit \n");
	 int menu = 0;
	 Scanner sc = new Scanner(System.in);
	 menu = sc.nextInt();
	 switch(menu)
	 {
	 case 1:
		         boolean result =login();
		         if(result)
		         {
		        	 System.out.println("Login success");
		         }
		         else
		         {
		        	 System.out.println("wrong creditials or not record found: ");
		         }
		         break;
	 case 2:
		       signup();
		        break;
	 case 3:
	           choice =8008;
	           break; 
	 }
   }	 
	}
	 static boolean login()
	 {
		boolean loginSuccess =  false;
		String id1 = "", password = "";
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter ID : ");
		id1 = sc.nextLine();
		System.out.println("Enter Pinciode : ");
		password = sc.nextLine();
		
		try {
			class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SMS","root", "root");
			Statement st = con.createStatement();
			Result re = st.executeQuery("select * from login");
			
			while(rs.next())
			{
				id1 = rs.getString(1);
				pin = rs.getString(2);
			}
			if(id.equals(id1) &&  pin.equals(pin))
				loginSuccess = true;
			else
				loginSuccess = false;
			
		} catch (Exception e)
		{
			System.out.println(e);
		}
		
		
		
		return loginSuccess ;
	 }
	 static void signup()
	 {
		 int loop=0;
		 int code = 0;
		 String id="", pincode="", name="";
		 while(loop!=8008)
		 {
	 Scanner sc = new Scanner(System.in);			
	System.out.println("signup : Two-Step verification : \n");
	 code = sc.nextInt();
	 if(code==8008)
	 {
		 Scanner data = new Scanner(System.in);
		 System.out.println("Enter ID : ");
		 id = data.nextLine();
		 System.out.println("Enter pincode : ");
		 pincode = data.nextLine();
		 System.out.println("Enter Name : ");
		 name = data.nextLine();
		  
		 
try {
	 class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/SMS","root", "root");
		String query = "insert into signup (id, pincode, name)"+"values(?,?,?)"; 
	String query1 ="insert into login(id, pincode)" + "values(?,?)";
		PreparedStatement ps= con.prepareStatement(query);
		PreparedStatement ps1 = con.prepareStatement(query1);

	ps.setString(1, id);
	ps.setString(2, pincode);
	ps.setString(3, name);
	ps1.setString(1, id);
	ps1.setString(2, pincode);
	int i= ps.executeUpdate();
	ps1.executeUpdate();
	
	if (i>0)
	{
      System.out.print("\n\nData inserted...\n\n");
	}
	else
	{
		System.out.print("\n\nData not inserted...");
	}
	
		 }catch(Exception e)
		 {
			System.out.println(e); 
		 }
		 
	 } else
	 {
		System.out.println("\nwrong pin_code : ");
		return;
	 }
		 }
	 }
}


 




