package Lab2;

import java.util.Scanner;

public class VietnamesePhone extends Phone {
	private boolean isRunning;
	
	public VietnamesePhone()
	{
		super();
		this.isRunning = true;
	}

	@Override
	public void insertContact(String name, String number) {
		Contact newContact = new Contact(name, number);
		super.getListContact().add(newContact);
	}

	@Override
	public void removeContact(String name) {
		int index = -1;
		for(int i = 0; i<super.getListContact().size(); i++)
		{
			if(super.getListContact().get(i).getName().equalsIgnoreCase(name))
			{
				index = i;
				break;
			}
		}
		if(index == -1)
		{
			System.out.println("Không tìm thấy contact");
		}
		else
		{
			super.getListContact().remove(index);
			System.out.println("Xóa contact thành công");
		}
	}

	@Override
	public void updateContact(String name, String newNumber) {
		int index = -1;
		for(int i = 0; i<super.getListContact().size(); i++)
		{
			if(super.getListContact().get(i).getName().equalsIgnoreCase(name))
			{
				index = i;
				break;
			}
		}
		if(index == -1)
		{
			System.out.println("Không tìm thấy contact");
		}
		else {
			super.getListContact().get(index).setName(name);
			super.getListContact().get(index).setNumber(newNumber);
			System.out.println("Update contact thành công");
		}
	}

	@Override
	public void searchContact(String name) {
		int index = -1;
		for(int i = 0; i<super.getListContact().size(); i++)
		{
			if(super.getListContact().get(i).getName().equalsIgnoreCase(name))
			{
				index = i;
				break;
			}
		}
		if(index == -1)
		{
			System.out.println("Không tìm thấy contact");
		}
		else
		{
			System.out.println("Tìm thấy contact");
			System.out.println(super.getListContact().get(index).toString());
		}	
	}
	
	public void showAllContact()
	{
		for(int i = 0; i<super.getListContact().size(); i++)
		{
			System.out.println(super.getListContact().get(i).toString());
		}
	}
	
	public void exit()
	{
		isRunning = false;
	}
	
	public void showMenu()
	{
		Scanner sc = new Scanner(System.in);
		int n;
		while(this.isRunning)
		{
			System.out.println("=== MENU ===");
            System.out.println("1. insertContact");
            System.out.println("2. removeContact");
            System.out.println("3. updateContact");
            System.out.println("4. searchContact");
            System.out.println("5. Thoát");
            System.out.println("6: showAllContact");
            System.out.print("Chọn chức năng: ");
            n = Integer.parseInt(sc.nextLine());
            switch(n)
            {
            	case 1:
            		String name = "";
            		String number = "";
            		System.out.println("Nhập tên");
            		name = sc.nextLine();
            		System.out.println("Nhập sdt");
            		number = sc.nextLine();
            		insertContact(name, number);
            		break;
            	case 2:
            		System.out.println("Nhập tên");
            		name = sc.nextLine();
            		removeContact(name);
            		break;
            	case 3:
            		System.out.println("Nhập tên");
            		name = sc.nextLine();
            		System.out.println("Nhập sdt");
            		number = sc.nextLine();
            		updateContact(name, number);
            		break;
            	case 4:
            		System.out.println("Nhập tên");
            		name = sc.nextLine();
            		searchContact(name);
            		break;
            	case 5:
            		exit();
            		break;
            	case 6:
            		showAllContact();
            }
		}
	}
	

}
