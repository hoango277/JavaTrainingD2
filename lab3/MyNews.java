package lab3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class MyNews {
	
	private ArrayList<NewImpl> arr;
	private boolean isRunning;
	
	public MyNews()
	{
		this.arr = new ArrayList<>();
		isRunning = true;
	}
	
	public void insertNews(Scanner sc)
	{
		
		Random rand = new Random();
		int id = rand.nextInt(1000);
		System.out.println("Nhập title");
		String title = sc.nextLine();
		System.out.println("Nhập publishDate");
		String publishDate = sc.nextLine();
		System.out.println("Nhập author");
		String author = sc.nextLine();
		System.out.println("Nhập content");
		String content = sc.nextLine();
		System.out.println("Nhập vào 3 đánh giá");
		int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
		sc.nextLine();
		NewImpl newToAdd = new NewImpl(id, title, publishDate, author, content, a, b, c);
		arr.add(newToAdd);
	}
	
	public void viewListNews()
	{
		for(NewImpl newInList : arr)
		{
			newInList.display();
		}
	}
	
	public void viewAverage(Scanner sc)
	{
		System.out.println("Nhập vào id của news muốn đánh giá");
		int idToFind = sc.nextInt();
		sc.nextLine();
		int indexFound = -1;
		for(int i = 0; i<arr.size(); i++)
		{
			if(arr.get(i).getId() == idToFind)
			{
				indexFound = i;
				break;
			}
		}
		if(indexFound == -1)
		{
			System.out.println("Không tìm thấy new bạn muốn đánh giá, vui lòng quay lại và thêm new mới");
		}
		else
		{
			NewImpl newToCacl = arr.get(indexFound);
			System.out.println("Nhập vào 3 đánh giá");
			int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
			sc.nextLine();
			System.out.println("Đánh giá thành công, điểm trung bình là: " + newToCacl.calculate(a, b, c));
		
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
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");
            System.out.print("Chọn chức năng: ");
            n = Integer.parseInt(sc.nextLine());
            switch(n)
            {
            	case 1:
            		insertNews(sc);
            		break;
            	case 2:
            		viewListNews();
            		break;
            	case 3:
            		viewAverage(sc);
            		break;
            	case 4:
            		exit();
            		break;
            }
		}
	}
	
	
	
	

}
