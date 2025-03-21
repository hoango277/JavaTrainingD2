package QLCB;

public class Worker extends Human {
	
	private int level;

	public Worker(String name, Integer age, GenderEnum gender, String address, int level) {
		super(name, age, gender, address);
		this.level = level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
	
	public String toString()
	{
		return "Loại cán bộ công nhân, bậc" + level + ": " + super.getName() + "|" + super.getAddress() + "|" + super.getGender() + "|" + super.getAge() ;
		
	}
	
	

}
