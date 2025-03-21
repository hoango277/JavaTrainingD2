package QLCB;

import java.util.*;

public class QLCB {
	
	private ArrayList<Human> listEmployee;
	private boolean isRunning = true;
	
	public QLCB()
	{
		listEmployee = new ArrayList<>();
	}
	
	public void addEmployee(Human newEmployee)
	{
		this.listEmployee.add(newEmployee);
	}

	public void findEmployeeByName(String name)
	{
		for(Human e : this.listEmployee)
		{
			if(e.getName().equalsIgnoreCase(name))
			{
				System.out.println("Tìm thấy cán bộ:");
				System.out.println(e.toString());
				return;
			}
		}
		System.out.println("Không tìm thấy cán bộ trong danh sách");
	}
	
	public void getAllEmployee()
	{
		System.out.println("Danh sách cán bộ: ");
		for(Human e : this.listEmployee)
		{
			System.out.println(e.toString());
		}
	}
	
	public void deleteEmployeeByName(String name)
	{
		int index = -1;
		for(int i = 0; i<listEmployee.size(); i++)
		{
			if(listEmployee.get(i).getName().equalsIgnoreCase(name))
			{
				index = i;
				break;
			}
		}
		if(index != -1)
		{
			listEmployee.remove(index);
			System.out.println("Xóa cán bộ thành công");
		}
		else
			System.out.println("Không tìm thấy cán bộ trong danh sách");
	}
	
	public void showMenu()
	{
		Scanner sc = new Scanner(System.in);
		int n;
		while(this.isRunning)
		{
			System.out.println("\n=== MENU ===");
            System.out.println("1. Thêm mới cán bộ");
            System.out.println("2. Tìm kiếm theo họ tên");
            System.out.println("3. Hiển thị danh sách cán bộ");
            System.out.println("4. Xóa cán bộ theo tên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            try {
            	n = Integer.parseInt(sc.nextLine());
            	
            	switch(n)
            	{
            		case 1:
            			String name = "";
            			int age = -1;
            			GenderEnum gender = GenderEnum.OTHER;
            			String address = "";
            			boolean validInput = false;
            			int type = -1;
            			
            			System.out.println("Nhập tên");
            			name = sc.nextLine();
            			
            			while (!validInput) {
            			    try {
            			        System.out.print("Nhập tuổi: ");
            			        age = Integer.parseInt(sc.nextLine());
            			        if(age > 0)
            			        {
            			        	validInput = true;
            			        }		        
            			    } catch (NumberFormatException e) {
            			        System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ!");
            			    }
            			}
            			System.out.println("Nhập địa chỉ");
            			address = sc.nextLine();
            			
            			System.out.println("Chọn giới tính của bạn: MALE, FEMALE, OTHER");
            			validInput = false;
            			String genderInput = "";
            			while(!validInput)
            			{
            				try {
            					genderInput =  sc.nextLine().toUpperCase().trim();
            					gender = GenderEnum.valueOf(genderInput);
            					validInput = true;
            				}
            				catch(IllegalArgumentException e)
            				{
            					System.out.println("Nhập sai giới tính, vui lòng chỉ chọn 1 trong 3 giới tính đã được nêu trên");
            				}
            			}
            			
            			System.out.println("Chọn loại cán bộ: ");
                        System.out.println("1. Công nhân");
                        System.out.println("2. Kỹ sư");
                        System.out.println("3. Nhân viên");
                        validInput = false;
                        while (!validInput) {
            			    try {
            			        
            			        type = Integer.parseInt(sc.nextLine());
            			        validInput = true;	        
            			    } catch (NumberFormatException e) {
            			        System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ!");
            			    }
            			}
                        switch(type) {
                        case 1:
                        	System.out.println("Nhập level của công nhân:");
                        	validInput = false;
                        	int level = -1;
                        	while (!validInput) {
                			    try {
                			        
                			        level = Integer.parseInt(sc.nextLine());
                			        validInput = true;	        
                			    } catch (NumberFormatException e) {
                			        System.out.println("Lỗi: Vui lòng nhập một số nguyên hợp lệ!");
                			    }
                			}
                        	Worker worker = new Worker(name, age, gender, address, level);
                        	listEmployee.add(worker);
                        	break;
                        case 2:
                        	System.out.println("Nhập ngành đào tạo của kỹ sư:");
                        	String major = sc.nextLine();
                        	Engineer engineer = new Engineer(name, age, gender, address, major);
                        	listEmployee.add(engineer);
                        	break;
                        case 3:
                        	System.out.println("Nhập công việc của nhân viên");
                        	String work = sc.nextLine();
                        	Staff staff = new Staff(name, age, gender, address, work);
                        	listEmployee.add(staff);
                        }
                        break;
            		case 2:
            			System.out.println("Nhập họ tên cán bộ muốn tìm kiếm");
            			String nameToFind = sc.nextLine().trim();
            			findEmployeeByName(nameToFind);
            			break;
            		case 3:
            			getAllEmployee();
            			break;
            		case 4:
            			System.out.println("Nhập họ tên cán bộ muốn xóa");
            			String nameToDelete = sc.nextLine().trim();
            			deleteEmployeeByName(nameToDelete);
            			break;
            		case 5:
            			exit();
            			
                      
                        
                        
            		
            	}
            }
            catch (NumberFormatException e){
            	System.out.println("Nhập sai lựa chọn, vui lòng chọn lại");
            }
            
		}
	}
	
	public void exit()
	{
		this.isRunning = false;
	}
	
	
	

}
