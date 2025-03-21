package Lab2;

public class Contact {
	private String number;
	private String name;
	public Contact(String name, String number) {
		this.number = number;
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String toString()
	{
		return name + " " + number;
	}
	

}
