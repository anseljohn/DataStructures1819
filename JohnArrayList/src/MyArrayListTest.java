import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test methods for MyArrayList class
 * 
 * @author AnselmJA20
 * @version 9.13.18
 */
public class MyArrayListTest {
    private MyArrayList<Integer> regular;
    private MyArrayList<Integer> ranRepet;
    private MyArrayList<Integer> tooSmall;
    private MyArrayList<Integer> empty;
    private MyArrayList<Integer> sizeLen;
    private MyArrayList<Integer> testCollection;
    private MyArrayList<Integer> regToTest;

    /**
     * Set up the field variable MyArrayLists
     */
    @Before
    public void setUp() {
        regular = new MyArrayList<Integer>( 5 );
        regToTest = new MyArrayList<Integer>( 5 );
        for ( int i = 1; i < 6; i++ ) {
            regular.add( i );
            regToTest.add( i );
        }

        ranRepet = new MyArrayList<Integer>();
        for ( int i = 1; i <= 3; i++ ) {
            ranRepet.add( i );
            ranRepet.add( i );
            ranRepet.add( i );
        }

        tooSmall = new MyArrayList<Integer>( 2 );
        for ( int i = 0; i < 3; i++ ) {
            tooSmall.add( i );
        }
        
        empty = new MyArrayList<Integer>( 0 );
        
        sizeLen = new MyArrayList<Integer>( 3 );
        for ( int i = 0; i < 3; i++ ) {
            sizeLen.add( i );
        }
        
        Collection<Integer> tempCollection = new ArrayList<Integer>();
        for ( int i = 1; i < 6; i++ ) {
            tempCollection.add( i );
        }
        testCollection = new MyArrayList<Integer>( tempCollection );
    }

    /**
     * Set the fields back to null between methods
     */
    @After
    public void tearDown() {
        regular = null;
        ranRepet = null;
        tooSmall = null;
        empty = null;
        sizeLen = null;
    }

    
    // add( Object o ) tests
    /**
     * Test
     */
    @Test
    public void testAddRegObj() {
        regular.add( 6 );
        assertEquals( "[1, 2, 3, 4, 5, 6]", regular.toString() );
    }

    /**
     * test
     */
    @Test
    public void testAddTooSmall() {
        tooSmall.add( 2 );
        assertEquals( "[0, 1, 2, 2]", tooSmall.toString() );
    }

    
    // add( int index, Object obj ) tests
    /**
     * test
     */
    @Test
    public void testAddToRegIndex() {
        regular.add( 0, 0 );
        assertEquals( "[0, 1, 2, 3, 4, 5]", regular.toString() );
    }

    /**
     * test
     */
    @Test
    public void testAddToRegRandomIndex() {
        regular.add( 2, 23 );
        assertEquals( "[1, 2, 23, 3, 4, 5]", regular.toString() );
    }

    
    // remove( Object o ) tests
    /**
     * test
     */
    @Test
    public void testRemoveObjectReg() {
        regular.remove( new Integer( 2 ) );
        assertEquals( "[1, 3, 4, 5]", regular.toString() );
    }
    

    // remove( int index ) tests
    /**
     * test
     */
    @Test
    public void testRemoveIndexReg() {
        regular.remove( 0 );
        assertEquals( "[2, 3, 4, 5]", regular.toString() );
    }
    
    /**
     * test
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testRemoveIndexLessThanZero() {
        regular.remove( -1 );
        assertEquals( regToTest, regToTest );
    }
    
    /**
     * test
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testRemoveIndexLargerThanSize() {
        regular.remove( 100 );
        assertEquals( regToTest, regToTest );
    }

    
    // indexOf( Object o ) tests
    /**
     * test
     */
    @Test
    public void testIndexOfReg() {
        assertEquals( 1, regular.indexOf( 2 ) );
    }
    
    /**
     * test
     */
    @Test
    public void testIndexNotThere() {
        assertEquals( -1, regular.indexOf( 123123 ) );
    }

    
    // lastIndexOf( Object o ) tests
    /**
     * test
     */
    @Test
    public void testRandomRepetitive() {
        assertEquals( 5, ranRepet.lastIndexOf( 2 ) );
    }
    
    /**
     * test
     */
    @Test
    public void testLastIndexOfNotThere() {
        assertEquals( -1, regular.lastIndexOf( 123182124 ) );
    }

    
    // get( index i ) tests
    /**
     * test
     */
    @Test
    public void testGetReg() {
        assertEquals( new Integer( 2 ), regular.get( 1 ) );
    }
    
    /**
     * test
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testGetIndexLessThanZero() {
        regular.get( -1 );
        assertEquals( regToTest, regToTest );
    }
    
    /**
     * test
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testGetIndexGreaterEqualToSize() {
        regular.get( 5 );
        assertEquals( regToTest, regToTest );
    }

    
    // set( int Index, E o ) tests
    /**
     * test
     */
    @Test
    public void testSetReg() {
        regular.set( 1, 234 );
        assertEquals( "[1, 234, 3, 4, 5]", regular.toString() );
    }

    
    // size() tests
    /**
     * test
     */
    @Test
    public void testSize() {
        assertEquals( 5, regular.size() );
    }

    
    // contains( Object o ) tests
    /**
     * test
     */
    @Test
    public void testContainsReg() {
        assertTrue( regular.contains( 1 ) );
    }
    
    /**
     * test
     */
    @Test
    public void testContainsNot() {
        assertFalse( regular.contains( 7423847 ) );
    }
    
    
    // isEmpty() tests
    /**
     * test
     */
    @Test
    public void testIsEmptyWithEmpty() {
        assertTrue( empty.isEmpty() );
    }
    
    /**
     * test
     */
    @Test
    public void testIsEmptyNotEmpty() {
        assertFalse( regular.isEmpty() );
    }
    
    
    // toString tests
    /**
     * test
     */
    @Test
    public void testToString() {
        assertEquals( "[1, 2, 3, 4, 5]", regular.toString() );
    }

    
    // addAll tests
    /**
     * test
     */
    @Test
    public void testAddAll() {
        Collection<Integer> vals = new ArrayList<Integer>();
        for ( int i = 1; i < 6; i++ ) {
            vals.add( i );
        }
        empty.addAll( vals );
        assertEquals( "[1, 2, 3, 4, 5]", empty.toString() );
    }
    
    /**
     * test
     */
    @Test ( expected = NullPointerException.class )
    public void testAddAllNull() {
        regToTest.addAll( null );
    }
    
    
    // trimToSize() tests
    /**
     * test
     */
    @Test
    public void testTrimToSize() {
        ranRepet.trimToSize();
        assertEquals( "[1, 1, 1, 2, 2, 2, 3, 3, 3]", 
                    ranRepet.toString() );
    }
    
    /**
     * test
     */
    @Test
    public void testTrimSizeLen() {
        sizeLen.trimToSize();
        assertEquals( "[0, 1, 2]", sizeLen.toString() );
    }
    
    
    // clear() tests
    /**
     * test
     */
    @Test
    public void testClear() {
        regular.clear();
        assertEquals( "[]", regular.toString() );
    }
    
    
    // removeRange( int from, int to ) tests
    /**
     * tests
     */
    @Test
    public void testRemoveRangeReg() {
        // 1, 2, 3, 4, 5
        //1, 5
        regular.removeRange( 1, 3 );
        assertEquals( "[1, 5]", regular.toString() );
    }
    
    /**
     * test
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testRemoveRangeFromZero() {
        regToTest.removeRange( -123, 2 );
    }
    
    /**
     * test
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testRemoveRangeToSize() {
        regToTest.removeRange( 0, 1231231 );
    }
    
    /**
     * test
     */
    @Test ( expected = IndexOutOfBoundsException.class )
    public void testRemoveRangeToFrom() {
        regToTest.removeRange( 213123123, 3 );
    }
    
    
    // toArray() tests
    /**
     * tests
     */
    @Test
    public void testToArrayReg() {
        assertArrayEquals( new Object[] {1, 2, 3, 4, 5},
                    regular.toArray() );
    }
    
    
    // equals() tests
    /**
     * tests
     */
    @Test ( expected = NullPointerException.class )
    public void testEqualsNull() {
        regular.equals( null );
    }
    
    /**
     * tests
     */
    @Test
    public void testEqualsRegs() {
        assertTrue( regular.equals( regToTest ) );
    }
    
    /**
     * tests
     */
    @Test
    public void testEqualsNotEquals() {
        assertFalse( regular.equals( tooSmall ) );
    }
    
    // addCollection tests
    /**
     * test
     */
    @Test
    public void testToStringCollection() {
        assertEquals( "[1, 2, 3, 4, 5]", testCollection.toString() );
    }
}
