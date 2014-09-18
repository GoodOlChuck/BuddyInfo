import java.util.ArrayList;
public class AddressBook {
	private static ArrayList<BuddyInfo> addressbook= new ArrayList<BuddyInfo>();

	public static void addBuddy(BuddyInfo buddy){
		addressbook.add(buddy);
	}
	
	public static void removeBuddy(BuddyInfo buddy){
		addressbook.remove(buddy);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BuddyInfo buddy = new BuddyInfo("Jim", "123 Maple Street","613-123-1234");
		
		addBuddy(buddy);
		removeBuddy(buddy);
		System.out.println("Hello?");
		
	}
}
