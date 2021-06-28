package table;

public class User {
	
	private String username;
	private String pass;
	
	public User(){
		super();
	}
	
	public User(String uName, String password) {
		super();
		this.username = uName;
		this.pass = password;
	}
	
	public void setUserName(String uName) {
		this.username = uName;
	}
	
	public String getUserName() {
		return this.pass;
	}
	
	public void setPass(String passWord) {
		this.pass = passWord;
	}
	
	public String getPass() {
		return this.pass;
	}
	
	public String getUser() {
		String temp = "'" + this.username + "','" + this.pass + "'";
		return temp;
	}
}