package operate;

import java.sql.*;
import netlink.*;
import table.*;

public class OPperson {
	
	private ConnectMysql con;
	public OPperson(ConnectMysql conn) {
		super();
		this.con = conn;
	}
	public boolean createTable() throws SQLException, Exception {
	      String sql ="create table persons("
					+"username varchar(10) not null,"
					+"name varchar(20) not null,"
					+"age int,"
					+"teleno char(11)," 
					+"primary key(name)"
					+");";  
	       Statement state=con.getCon().createStatement();
	       state.executeUpdate(sql);
	       state.close();
	       System.out.println("创建persons表成功！");
	       return true;
	}
	
	public boolean drop() throws SQLException, Exception {
		Statement state =con.getCon().createStatement();
		String sql="drop table persons;";
		state.executeUpdate(sql);
		state.close();
		System.out.println("已删除persons表。");
		return true;
	}
	
	public int addPersons(Person people) throws Exception {
		Statement state=con.getCon().createStatement();
		int flag = 0;
		String temp2 = "select * from users where username='" + people.getUserName() + "';";
		ResultSet rs=state.executeQuery(temp2);
		rs.last();
		if( rs.getRow() == 0 ) {
			String temp3 = "insert into users(username,pass) values ('" + people.getUserName() + "','888888');";
			state.execute(temp3);
			System.out.println("插入user成功!\n");
		}	
		String sql = "";
		
		if( people.getAge() != 0 && people.getTeleNo() != null ) {
			sql = "insert into persons(username,name,age,teleno) values (" + people.getPersons() + ");";
		}
		
		else if( people.getAge() != 0 && people.getTeleNo() == null ) {
			sql = "insert into persons(username,name,age) values (" + people.getPersons() + ");";
		}
		
		else if( people.getAge() == 0 && people.getTeleNo() != null) {
			sql = "insert into persons(username,name,teleno) values (" + people.getPersons() + ");";
		}
		
		else {
			sql = "insert into persons(username,name) values (" + people.getPersons() + ");";
		}		
		
		String temp = "select * from persons where name='" + people.getName() + "';";
		rs = state.executeQuery(temp);
		
		if( !rs.next()) {
			state.executeUpdate(sql);
			System.out.println("插入成功！");
			flag=2;
		}
		else {
			this.delete(people.getName());
			state.executeUpdate(sql);
			System.out.println("更新完毕！\n");
			flag=1;
		}
		
		rs.close();
		state.close();
		return flag;
	}
	
	
	public boolean delete(String atrribute) throws SQLException, Exception {	
		Statement state=con.getCon().createStatement();
		String sql="delete from persons where name = '"+atrribute+"';";
		state.executeUpdate(sql);
        state.close();
		return true;
	}
	
	public void show() throws SQLException, Exception {
		Statement state =con.getCon().createStatement();
		System.out.println("表persons：");
		System.out.printf("%-10s","username");
		System.out.printf("%-10s","name");
		System.out.printf("%-10s","age");
		System.out.printf("%-12s","teleno");
		System.out.println();

		String query="select * from persons";
		ResultSet rs=state.executeQuery(query);
		while(rs.next()) {
			String s1 = rs.getString("username");
			System.out.printf("%-10s",s1);
			String s2 = rs.getString("name");
			System.out.printf("%-10s",s2);
			Integer s3 = rs.getInt("age");
			if( s3 != -1 ) {
				s3=null;
				
			}
			System.out.printf("%-10s",s3);
			String s4 = rs.getString(4);
			if( s4.length()==0 ) {
				s4=null;
				
			}	
			System.out.printf("%-10s",s4);
			System.out.println();
		}
		System.out.println();
		rs.close();
		state.close();
	}
}
