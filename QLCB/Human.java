package QLCB;

public class Human {
	private String name;
	private Integer age;
	private GenderEnum gender;
	private String address;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Human(String name, Integer age, GenderEnum gender, String address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}
	
	public Human() {};
	

}
