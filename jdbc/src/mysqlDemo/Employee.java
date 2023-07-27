package mysqlDemo;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Employee {
	public static void main (String[] agrs)throws Exception{
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emp?characterEncoding=utf8","root","T*9758@pqr");
		Statement stmt=con.createStatement();
		ResultSet rs;
		PreparedStatement st;
		String qry="";
		int id, age,choice, salary;
		String name,city;
		Scanner in=new Scanner(System.in);
		Scanner str=new Scanner(System.in);
		while(true) {
			System.out.println("Employee details");
			System.out.println("1.INSERT");
			System.out.println("2.UPDATE");
			System.out.println("3.DELETE");
			System.out.println("4.SELECT");
			System.out.println("5.EXIT");
			System.out.println("Enter your choice:");
			choice=in.nextInt();
			System.out.println("---------------------------------------------------------");
			switch(choice){
			case 1:
				System.out.println("1.INSERT NEW DATA");
				System.out.println("Employee Name:");
				name=str.nextLine();
				System.out.println("Employee age:");
				age=in.nextInt();
				System.out.println("Employee salary:");
				salary=in.nextInt();
				System.out.println("Employee city");
				city=str.nextLine();
				qry="insert into employee(name,age,salary,city) values(?,?,?,?,)";
				st=con.prepareStatement(qry);
				st.setString(1,name);
				st.setInt(2, age);
				st.setInt(3, salary);
				st.setString(4, city);
				
				st.executeUpdate();
				System.out.println("successfully employee details insert");
				break;
			case 2:
				System.out.println("2.UPDATE EMPLOYEE DATA");
				System.out.println("Employee ID:");
				id= in.nextInt();
				System.out.println("Employee Name:");
				name=str.nextLine();
				System.out.println("Employee age:");
				age=in.nextInt();
				System.out.println("Employee salary:");
				salary=in.nextInt();
				System.out.println("Employee city");
				city=str.nextLine();
				qry="update employee set name=?,age=?,salary=?,city=?where ID=?";
				st=con.prepareStatement(qry);
				st.setString(1,name);
				st.setInt(2, age);
				st.setInt(3, salary);
				st.setString(4, city);
				st.setInt(5, id);
				st.executeUpdate();
				System.out.println("successfully employee details update");
				break;
			case 3:
				System.out.println("3.DELETE EMPLOYEE DETAILS");
				System.out.println("Enter ID:");
				id=in.nextInt();
				qry="delete from employee where ID=?";
				st=con.prepareStatement(qry);
				st.setInt(1, id);
				st.executeUpdate();
				System.out.println("successfully employee deatils delete");
				break;
			case 4:
				System.out.println("4. SELECT ALL DETAILS");
				qry="SELECT ID,NAME,AGE,SALARY,CITY from employee";
				rs=stmt.executeQuery(qry);
				while(rs.next()) {
					id=rs.getInt("ID");
					name=rs.getString("NAME");
					age=rs.getInt("AGE");
					salary=rs.getInt("SALARY");
					city=rs.getString("CITY");
					System.out.print(id+"");
					System.out.print(name+"");
					System.out.print(age+"");
					System.out.print(salary+"");
					System.out.print(city+"");
				}
				break;
			case 5:
				System.out.println("Thank you");
				System.exit(0);
				break;
				default:
					System.out.println("INVALID EMPLOYEE SELECTION");
					break;
			}
			System.out.println("--------------------------------------------");
		}
		
		
	}

}
