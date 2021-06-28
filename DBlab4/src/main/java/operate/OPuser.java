package operate;

import java.sql.*;
import table.*;
import netlink.*;

public class OPuser {
	private ConnectMysql con;
	public OPuser(ConnectMysql conn) {
		super();
		this.con = conn;
	}
	public boolean createTable() throws Exception {
        String sql = "create table users"
                + "( "
                + "username varchar(10) not null,"
                + "pass varchar(8) not null,"
                + "primary key (username)"
                + ");"; 
        Statement state=con.getCon().createStatement();
        state.executeUpdate(sql);
        state.close();
        System.out.println("创建users表成功！");
        return true;
    }
	
	public boolean drop() throws SQLException, Exception {
		Statement state =con.getCon().createStatement();
		String sql="drop table users;";
		state.executeUpdate(sql);
		state.close();
		System.out.println("已删除users表。");
		return true;
	}

	public boolean add(User user) throws SQLException, Exception {
		Statement state=con.getCon().createStatement();
		String sql="insert into users(username,pass) values ('"+user.getUserName()+"','"+user.getPass()+"');";
		state.executeUpdate(sql);
		state.close();
		System.out.println("添加user成功！");
		return true;
	}

	
	public int delete(String mark, int option) throws SQLException, Exception {
		Statement state=con.getCon().createStatement();
		if( option==1) {
			String sql = "delete from users where username like '"+mark+"%';";
	        state.executeUpdate(sql);
	        String sql2 = "delete from persons where username like '"+mark+"%';";
	        state.executeUpdate(sql2);
		}
		int flag=1;
		if( option==2) {
			String sql="delete from users where username = '"+mark+"';";
			flag=state.executeUpdate(sql);
	        String sql2 = "delete from persons where username like '"+mark+"%';";
	        state.executeUpdate(sql2);
			if(flag>0)
				System.out.println("删除"+mark+"成功！");
			else
				System.out.println("不存在，删除"+mark+"失败！");
			
		}
        state.close();
		return flag;
	}

	
	public void show() throws SQLException, Exception {
		Statement state =con.getCon().createStatement();
		System.out.println("表users:");
		System.out.printf("%-10s","userName");
		System.out.printf("%-10s","pass");
		System.out.println();
		
		String sql = "select * from users;";			
		ResultSet rs = state.executeQuery(sql);

		while(rs.next()) {
			String s1 = rs.getString(1);
			System.out.printf("%-10s",s1);
			String s2 = rs.getString(2);
			System.out.printf("%-10s",s2);
			System.out.println();
		}
		System.out.println();
		rs.close();
		state.close();
	}
}
