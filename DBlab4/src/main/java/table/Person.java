package table;

public class Person {
	
	private String username;
	private String name;
	private Integer age;
	private String teleno;
	
	public Person(String uName, String dname, Integer dage, String dteleNo) {
		this.username = uName;
		this.name = dname;
		this.age = dage;
		this.teleno = dteleNo;
	}
	
	public void setUserName(String uName) {
		this.username = uName;
	}
	
	public String getUserName() {
		return this.username;
	}
	
	public void setName(String pName) {
		this.name = pName;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(Integer pAge) {
		this.age = pAge;
	}
	
	public Integer getAge() {
		return this.age;
	}
	
	public void setTeleNo(String tNo) {
		this.teleno = tNo;
	}
	
	public String getTeleNo() {
		return this.teleno;
	}
	
	public String getPersons() {
		
		String temp = "'" + this.username + "','" + this.name + "'";
		
		if( this.getAge() != 0 ) {
			temp = temp + ",'" + this.getAge() + "'";
		}
		
		if( this.getTeleNo() != null ) {
			temp = temp + ",'" + this.getTeleNo() + "'";
		}
		
		return temp;
	}
	
}