package LearnJava;

public class SinhVien  {
	
	private int diem;
	public SinhVien(int diem) {
		this.diem = diem;
	}
	public int getDiem() {
		return diem;
	}
	public void setDiem(int diem) {
		this.diem = diem;
	}
	
	public String toString()
	{
		return ""+this.diem;
	}
	
	
	
}
