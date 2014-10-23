import java.util.ArrayList;
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
	
}
