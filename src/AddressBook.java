import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
public class AddressBook implements Serializable{
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
	
	public BuddyInfo getBuddy(int index){
		return addressbook.get(index);
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
	    String[] test;
	    //BuddyInfo b1 =null;
	    for(int x=1; x<stringArr.length -1; x++){
	    	String temp = stringArr[x];
	    	List<String> items = Arrays.asList(temp.split(","));
	    	System.out.println(stringArr[1]);
	    	//test = temp.split("\\s*,\\s*");
	    	System.out.println(items.get(0));
	    	System.out.println(items.get(1));
	    	//b1 = new BuddyInfo(test[0],test[1],test[2]);
	    	BuddyInfo b1 = new BuddyInfo(items.get(0), items.get(1), items.get(2));
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
		out.println(alist.get(size()-3).toString());
		out.close();
		//setText("Address Book Saved");
		
	
	}
	
	public void export(ArrayList<AddressBook> alist, AddressBook abook, int currentPos){
		PrintWriter out = null;
		try {
			out = new PrintWriter(alist.get(currentPos).getName()+".txt");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		out.println(abook.toString());
		out.close();
		//setText("Address Book Saved");
		
	}
	
	public String toXML(){
		String xml = "";
		
		xml += "<AddressBook>\n" + "<aname>" + getName() + "</aname>\n";
		for(BuddyInfo buddy: addressbook){
			xml += "<BuddyInfo>\n";
			
			xml+= "<name>" + buddy.getName() + "</name>\n";
			xml+= "<address>" + buddy.getAddress() + "</address>\n";
			xml+= "<phonenumber>" + buddy.getPhonenumber() + "</phonenumber>\n";
					
			xml += "</BuddyInfo>\n";
		}
		xml += "</AddressBook>";
		return xml;
	}
	
	public void exportToXmlFile(String name){
		PrintWriter writer = null;
		String xml = toXML();
		try {
			writer = new PrintWriter(name + ".xml", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println(xml);
		writer.close();
	}
	
	public void importFromXmlFileSAX(AddressBook abook, File f){
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder d = null;
		abook.clear();
		
		try {
			d = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc = null;
		try {
			doc = d.parse(f);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("Root: " + doc.getDocumentElement().getNodeName());
		NodeList lst = doc.getDocumentElement().getChildNodes();
		for(int ii=0; ii<lst.getLength();ii++){
			Node n = lst.item(ii);
			System.out.println("Child: " + n.getNodeName() + " ==> " + n.getTextContent());
			if(n.getNodeName().equals("BuddyInfo")){
				BufferedReader reader = new BufferedReader(new StringReader(n.getTextContent()));
				//reader.readLine();
				try {
					reader.readLine();
					BuddyInfo newBuddy = new BuddyInfo(reader.readLine(),reader.readLine(),reader.readLine());
					abook.addBuddy(newBuddy);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}
