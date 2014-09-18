import java.util.ArrayList;
public class AddressBook {
	ArrayList<BuddyInfo> addressbook;

	public AddressBook(ArrayList<BuddyInfo> addressbook) {
		super();
		this.addressbook = addressbook;
	}
	
	public void addBuddy(BuddyInfo buddy){
		addressbook.add(buddy);
	}
	
	public void removeBuddy(BuddyInfo buddy){
		addressbook.remove(buddy);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello?");
		
	}
}
