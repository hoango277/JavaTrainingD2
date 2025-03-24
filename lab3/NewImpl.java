package lab3;

import java.util.ArrayList;
import java.util.List;

public class NewImpl implements INews{
	private int id;
	private String title;
	private String publishDate;
	private String author;
	private String content;
	private Float averageRate;
	public int getId() {
		return id;
	}
	
	
	public NewImpl(int id, String title, String publishDate, String author, String content, int a, int b, int c) {
		super();
		this.id = id;
		this.title = title;
		this.publishDate = publishDate;
		this.author = author;
		this.content = content;
		calculate(a, b, c);
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisDate() {
		return publishDate;
	}
	public void setPublisDate(String publisDate) {
		this.publishDate = publisDate;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Float getAverageRate() {
		return averageRate;
	}
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println(id+ " "+ title + " " + publishDate + " " + author + " " + content + " " + averageRate );
	}
	
	@Override
	public float calculate(int a, int b, int c) {
		// TODO Auto-generated method stub
		ArrayList<Integer> arr = new ArrayList<>(List.of(a, b, c));
		this.averageRate = (float)(arr.get(0) + arr.get(1) + arr.get(2))/3;
		return this.averageRate;
	}
	
	
}
