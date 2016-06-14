package others;

import java.sql.*;//sql driver necessary for communicating with sql
import java.io.*;
public class test{
	public static void main(String[] args){
		System.out.println("Insert Image into sql");
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/";
		String dbName = "project";
		String userName = "root";
		String password = "udit";
		Connection con = null;
		try{
		   Class.forName(driverName);
		   con = DriverManager.getConnection(url+dbName,userName,password);
		   File imgfile = new File("C:\\Users\\udit agarwal\\workspace\\project\\prog5.png");//image path
		  
		  FileInputStream fin = new FileInputStream(imgfile);
		 
		   PreparedStatement pre =
		   con.prepareStatement("insert into Image values(?,?,?)");
		 
		   pre.setString(1,"test");//here '1' is for first field in image table and test represents its value
		   pre.setInt(2,3);//here '2' is for second field in image table and 3 represents its value
		   pre.setBinaryStream(3,(InputStream)fin,(int)imgfile.length());//for inserting image
		   pre.executeUpdate();
		   System.out.println("Image added");

		   pre.close();
		   con.close(); 
		}catch (Exception e1){
			System.out.println(e1.getMessage());
		}
	}
}