package QLCB;

public class Engineer extends Human{
	
	private String major;

	public Engineer(String name, Integer age, GenderEnum gender, String address, String major) {
		super(name, age, gender, address);
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public String toString()
	{
		return "Loại cán bộ kĩ sư ngành đạo tạo " + major + ": " + super.getName() + "|" + super.getAddress() + "|" + super.getGender() + "|" + super.getAge() ;
		
	}

}
