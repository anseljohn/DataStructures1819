import static org.junit.Assert.*;

import org.junit.*;

public class MyHeapTest {
    private MyHeap test1;
    
    @Before
    public void setup() {
        test1 = new MyHeap();
        for ( int i = 1; i < 11; i++ ) {
            test1.add( i );
        }
    }
    @After
    public void tearDown() {
        test1 = null;
    }
    
    @Test
    public void testAdd() {
        assertEquals( "1, 2, 3, 4, 5, 6, 7, 8, 9, 10", test1.toString() );
    }
    
    @Test
    public void testHeapUp() {
        test1.add( 1 );
        assertEquals( "1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10", test1.toString() );
    }

}
