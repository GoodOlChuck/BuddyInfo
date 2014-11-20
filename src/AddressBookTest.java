import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author charliewright
 *
 */
public class AddressBookTest {
	AddressBook add;
	ArrayList<AddressBook> alist;
	BuddyInfo b1,b2,b3;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		add = new AddressBook("Jimmy the registered sex offender's AddressBook");
		b1 = new BuddyInfo(27, "Joe Blow", "123 Maple St.", "613-737-0000", "Hi im Joe!");
		b2 = new BuddyInfo(21, "Bob Blow", "123 Maple St.", "613-737-0000", "Hi im Bob!");
		b3 = new BuddyInfo(30, "Jenny Blow", "123 Maple St.", "613-737-0000", "Hi im Jenny!");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		
	}

	/**
	 * Test method for {@link AddressBook#clear()}.
	 */
	@Test
	public void test() {
		alist.add(add);
		add.export(alist);
		assertEquals(0,add.size());
	}
	
	/**
	 * Test method for {@link AddressBook#clear()}.
	 */
	@Test
	public void testClear() {
		add.addBuddy(b1);
		add.addBuddy(b2);
		add.addBuddy(b3);
		add.clear();
		assertEquals(0,add.size());
	}

	/**
	 * Test method for {@link AddressBook#size()}.
	 */
	@Test
	public void testSize() {
		add.addBuddy(b1);
		add.addBuddy(b2);
		add.addBuddy(b3);
		assertEquals(3,add.size());
	}

}
