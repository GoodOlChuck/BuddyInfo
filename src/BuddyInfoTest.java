import static org.junit.Assert.*;

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
public class BuddyInfoTest {
	BuddyInfo b1,b2,b3;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		b1 = new BuddyInfo(27, "Joe Blow", "123 Maple St.", "613-737-0000", "Hi im Joe!");
		b2 = new BuddyInfo(16, "Timmy Blow", "123 Maple St.", "613-737-0000", "Hi im Joe!");
		b3 = new BuddyInfo(27, "Joe Blow", "123 Maple St.", "613-737-0000", "Hi im Joe!");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link BuddyInfo#BuddyInfo(BuddyInfo)}.
	 */
	@Test
	public void testBuddyInfoBuddyInfo() {
		assertEquals(b3, new BuddyInfo(b1) );
	}

	/**
	 * Test method for {@link BuddyInfo#getGreeting()}.
	 */
	@Test
	public void testGetGreeting() {
		assertEquals("Hi im Joe!", b1.getGreeting());
	}

	/**
	 * Test method for {@link BuddyInfo#isOver18(BuddyInfo)}.
	 */
	@Test
	public void testIsOver18() {
		assertEquals(true, b1.isOver18());
		assertEquals(false, b2.isOver18());
	}

	/**
	 * Test method for {@link BuddyInfo#getAge()}.
	 */
	@Test
	public void testGetAge() {
		assertEquals(27, b1.getAge());
		assertEquals(16, b2.getAge());
	}

	/**
	 * Test method for {@link BuddyInfo#setAge(int)}.
	 */
	@Test
	public void testSetAge() {
		b1.setAge(35);
		b2.setAge(2);
		assertEquals(35, b1.getAge());
		assertEquals(2, b2.getAge());
	}

}
