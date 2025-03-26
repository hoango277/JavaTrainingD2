package LearnJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<SinhVien> arr = new ArrayList<>();
		SinhVien a = new SinhVien(6);
		SinhVien b = new SinhVien(5);
		arr.add(a);
		arr.add(b);
		Comparator<SinhVien> cmp = new Comparator<SinhVien>() {
		    @Override
		    public int compare(SinhVien sv1, SinhVien sv2) {
		        return Integer.compare(sv1.getDiem(), sv2.getDiem());
		    }
		};
		Collections.sort(arr, cmp);
		for(SinhVien sv: arr)
		{
			System.out.println(sv.toString());
		}
	}
	
	
	

}
