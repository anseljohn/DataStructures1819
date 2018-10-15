import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for MyLinkedList
 * @author AnselmJA20
 * @version 1.0
 */
public class MyLinkedListTest {
	private MyLinkedList<Integer> regular;
	
    
	/**
	 * tests
	 */
	@Before
	public void setUp() {
        regular = new MyLinkedList<Integer>();
        for ( Integer i = 1; i < 6; i++ ) {
            regular.add( i );
        }
        
    }
    
    /**
     * tests
     */
	@After
    public void tearDown() {
        regular = null;
    }
    
    // add( E e ) tests
    /**
     * test
     */
    @Test
    public void testAdd() {
        assertEquals( "[1, 2, 3, 4, 5]", regular.toString() );
    }
}
