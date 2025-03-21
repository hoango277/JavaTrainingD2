package QLCB;

public class Staff extends Human {
	private String work;

	public Staff(String name, Integer age, GenderEnum gender, String address, String work) {
		super(name, age, gender, address);
		this.work = work;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}
	
	public String toString()
	{
		return "Loại cán bộ nhân viên, công việc " + work + ": " + super.getName() + "|" + super.getAddress() + "|" + super.getGender() + "|" + super.getAge() ;
		
	}

}
