import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class AddressBook {
	private ArrayList<BuddyInfo> addressbook;
	String name;

	public AddressBook(String name){
		this.name=name;
		addressbook= new ArrayList<BuddyInfo>();
	}
	public String getName() {
		return name;
	}
	public void clear(){
		addressbook.clear();
	}
	public void setName(String name) {
		this.name = name;
	}
	public void addBuddy(BuddyInfo buddy){
		addressbook.add(buddy);
	}
	
	public void removeBuddy(BuddyInfo buddy){
		addressbook.remove(buddy);
	}
	
	public void editBuddy(BuddyInfo buddy, String name, String address, String pnumber){
		
		buddy.setAddress(address);
		buddy.setName(name);
		buddy.setPhonenumber(pnumber);
	}
	
	public String toString(){
		String b= (name+"\r\n");
		for(BuddyInfo buddy:addressbook){
			b+= buddy.toString() + "\r\n";
		}
		
		return b;
	}
	
	public int size(){
		return addressbook.size();
	}
	
	public AddressBook importBook(String filename){
		AddressBook book;
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String str = null;

        List<String> list = new ArrayList<String>();
        try {
			while((str = in.readLine()) != null){
			    list.add(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        String[] stringArr = list.toArray(new String[0]);
	    //newBook = new AddressBook(stringArr[0]);
        ArrayList<BuddyInfo> newBook = new ArrayList<BuddyInfo>();
        book = new AddressBook(stringArr[0]);
	    //String[] test;
	    BuddyInfo b1 =null;
	    for(int x=1; x<stringArr.length; x++){
	    	String[] test = stringArr[x].trim().split("\\s*,\\s*");
	    	b1 = new BuddyInfo(test[0],"","");
	    	book.addBuddy(b1);
	    	newBook.add(b1);
	    }
	    addressbook = newBook;
	    return book;
	}
	
	public void export(ArrayList<AddressBook> alist){
		
		//if(size() == 0)
			//abook=alist.get(alist.size()-1);
		
		PrintWriter out = null;
		try {
			out = new PrintWriter(getName()+".txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		out.println(alist.get(size()-1).toString());
		out.close();
		//setText("Address Book Saved");
		
	
	}
	
}
