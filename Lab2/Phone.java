package Lab2;


import java.util.*;
public abstract class Phone {
	private ArrayList<Contact> listContact;
	
	public Phone()
	{
		listContact = new ArrayList<>();
	}
	
	public abstract void insertContact(String name, String number);
	
	public abstract void removeContact(String name);
	public abstract void updateContact(String name, String newNumber);
	public abstract void searchContact(String name);

	public ArrayList<Contact> getListContact() {
		return listContact;
	}

	

	
	

}
