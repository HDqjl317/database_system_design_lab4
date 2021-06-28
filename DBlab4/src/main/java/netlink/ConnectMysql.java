package netlink;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;


public class ConnectMysql {

	private Connection con;

	public ConnectMysql() throws Exception {
		con = getCon();
	}
	
	public Connection getCon() throws Exception{
		Properties properties = new Properties();
        InputStream in = ConnectMysql.class.getResourceAsStream("jdbc.properties");
        properties.load(in);  
        DataSource ds = DruidDataSourceFactory.createDataSource(properties);  
        Connection conn = ds.getConnection(); 
        in.close(); 
		return conn;
	}
	
	public void connect() throws Exception {	
		ConnectMysql jdcnCon;
		try {
			jdcnCon = new ConnectMysql();
			jdcnCon.getCon();
			System.out.println("�ѳɹ��������ݿ⣡\n");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("�������ݿ�ʧ�ܣ�\n");
		}
	}
	
	
	public void closeConnect() throws Exception{
		if( con != null ) {
			con.close();
		}
		System.out.println("�ѶϿ������ݿ�����ӡ�\n");
	}

}