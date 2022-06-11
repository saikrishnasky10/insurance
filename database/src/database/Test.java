package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Statementoperations stdo=new Statementoperations();
		Connection conn=stdo.getConnection();	
		Scanner sc = new Scanner(System.in); 
		System.out.println("enter your option 1.create table,2.insert values,3.upadate values,4.retrive data");
		int x=sc.nextInt();	
			while(x<6&x!=0)
			{
				if(x==1) {
					String i=stdo.createOperation("create table client(client_id int(10),client_name varchar(20),client_salary varchar(20))", conn);
					System.out.println(i);
				}
				if(x==2) {
					String i=stdo.insertOperation("insert into client values(202,'raju',26000)", conn);
					System.out.println(i);
				}
				if(x==3) {
					String i=stdo.updateOperation("update client set client_salary=26 where client_id=105", conn);
					System.out.println(i);
				}
				if(x==4) {
					String i=stdo.updateOperation("delete from agent where client_id in(105)", conn);
					System.out.println(i);
				}
				if(x==5) {
					ResultSet rs1=stdo.selectOperation("Select *from client", conn);
					while(rs1.next()) {
						System.out.println(rs1.getInt(1)+" "+rs1.getString(2)+" "+rs1.getInt(3)+" "+rs1.getString(4));
					}
				}
				System.out.println("enter 1.create table,2.insert values,3.upadate values,4.retrive data or press any number to exit");
				x=sc.nextInt();
		    }
			System.out.println("you are disconnected with database");
			conn.close();
	}
	}


