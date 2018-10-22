import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

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
	private MyLinkedList<Integer> empty;
	private MyLinkedList<Integer> repeat;
	private MyLinkedList<Integer> regEquals;
	
	private Collection<Integer> addAll;
	
	
    
	/**
	 * tests
	 */
	@Before
	public void setUp() {
        regular = new MyLinkedList<Integer>();
        addAll = new ArrayList<Integer>();
        regEquals = new MyLinkedList<Integer>();
        for ( Integer i = 1; i < 6; i++ ) {
            regular.add( i );
            addAll.add( i );
            regEquals.add( i );
        }
        
        empty = new MyLinkedList<Integer>();
        
        repeat = new MyLinkedList<Integer>();
        for ( Integer i = 1; i < 6; i++ ) {
            repeat.add( i );
            repeat.add( i );
        }
        
    }
    
    /**
     * tests
     */
	@After
    public void tearDown() {
        regular = null;
        empty = null;
        addAll = null;
        repeat = null;
        regEquals = null;
    }
    
    // add( E e ) tests
    /**
     * test
     */
    @Test
    public void testAdd() {
        assertEquals( "[1, 2, 3, 4, 5]", regular.toString() );
    }
    
    // add( int index, E e ) tests
    /**
     * tests
     */
    @Test
    public void testAddReg() {
        regular.add( 2, 10 );
        assertEquals( "[1, 2, 10, 3, 4, 5]", regular.toString() );
    }
    
    /**
     * tests
     */
    @Test
    public void testAddRegMore() {
        regular.add( 4, 10 );
        assertEquals( "[1, 2, 3, 4, 10, 5]", regular.toString() );
    }
    
    // remove( Object o ) tests
    /**
     * tests
     */
    @Test
    public void testRemoveReg() {
        regular.remove( ( Object )2 );
        assertEquals( "[1, 3, 4, 5]", regular.toString() );
    }
    
    /**
     * tests
     */
    @Test
    public void testRemoveRegNotThere() {
        assertFalse( regular.remove( ( Object ) 10 ) );
        assertEquals( "[1, 2, 3, 4, 5]", regular.toString() );
    }
    
    // remove( int index ) tests
    /**
     * tests
     */
    @Test
    public void testRemoveRegIndex() {
        regular.remove( 1 );
        assertEquals( "[1, 3, 4, 5]", regular.toString() );
    }
    
    /**
     * tests
     */
    @Test
    public void testRemoveRegIndex2() {
        regular.remove( 2 );
        assertEquals( "[1, 2, 4, 5]", regular.toString() );
    }
    
    // get( int index ) tests
    /**
     * tests
     */
    @Test
    public void testGetRegular() {
        assertEquals( 3, ( Object )regular.get( 2 ) );
    }
    
    // set( int index, E obj ) tests
    /**
     * tests
     */
    @Test
    public void testSetRegular() {
        regular.set( 2, 9 );
        assertEquals( "[1, 2, 9, 4, 5]", regular.toString() );
    }
    
    // size() tests
    /**
     * tests
     */
    @Test
    public void testSizeReg() {
        assertEquals( 5, regular.size() );
    }
    
    // contains( Object o ) tests
    /**
     * tests
     */
    @Test
    public void testContainsReg() {
        assertTrue( regular.contains( 3 ) );
    }
    
    /**
     * tests
     */
    @Test
    public void testNoContainsReg() {
        assertFalse( regular.contains( 123 ) );
    }
    
    // isEmpty() tests
    /**
     * tests
     */
    @Test
    public void testIsEmptyReg() {
        assertFalse( regular.isEmpty() );
    }
    
    /**
     * tests
     */
    @Test
    public void testIsEmptyIs() {
        assertTrue( empty.isEmpty() );
    }
    
    // addAll( Collection<E> c ) tests
    /**
     * tests
     */
    @Test
    public void testAddAllRegToReg() {
        regular.addAll( addAll );
        assertEquals( "[1, 2, 3, 4, 5, 1, 2, 3, 4, 5]", regular.toString() );
    }
    
    // clear() tests
    /**
     * tests
     */
    @Test
    public void testClearReg() {
        regular.clear();
        assertEquals( "[]", regular.toString() );
    }
    
    // indexOf( Object o ) tests
    /**
     * tests
     */
    @Test
    public void testIndexOfReg() {
        assertEquals( 2, regular.indexOf( 3 ) );
    }
    
    // lastIndexOf( Object o ) tests
    /**
     * tests
     */
    @Test
    public void testLastIndexOfRepeat() {
        assertEquals( 5, repeat.lastIndexOf( 3 ) );
    }
    
    // removeRange( int from, int to ) tests
    /**
     * tests
     */
    @Test
    public void testRemoveRangeRepeat() {
        repeat.removeRange( 3,  6 );
        // [1, 1, 2, 2, 3, 3, 4, 4, 5, 5]
        assertEquals( "[1, 1, 2, 4, 4, 5, 5]", repeat.toString() );
    }
    
    // toArray() tests
    /**
     * tests
     */
    @Test
    public void testRegToArray() {
        Object[] testing = { 1, 2, 3, 4, 5 };
        assertArrayEquals( testing, regular.toArray() );
    }
    
    // equals( Object o ) tests
    /**
     * tests
     */
    @Test
    public void testRegNotEqual() {
        assertFalse( regular.equals( repeat ) );
    }
    
    /**
     * tests
     */
    @Test
    public void testRegEqual() {
        assertTrue( regular.equals( regEquals ) );
    }
}
