import java.util.*;

public class MyHeap {
    private List<Integer> heap;
    
    public MyHeap() {
        heap = new ArrayList<Integer>();
    }
    
    public void heapDown() {
        int index = 1;
        int nextIndex = index;
        while ( heap.get( index * 2 ) != null ) {
            nextIndex = index * 2;
            if ( heap.get( nextIndex ) < heap.get( index ) ) {
                if ( heap.get( nextIndex + 1 ) < heap.get( nextIndex ) ) {
                    heap.set( 0, heap.get( nextIndex + 1 ) );
                    heap.set( nextIndex + 1, heap.get( 1 ) );
                    heap.set( 1, heap.get( 0 ) );
                    index = index * 2 + 1;
                } else {
                    heap.set( 0, heap.get( nextIndex ) );
                    heap.set( nextIndex, heap.get( 1 ) );
                    heap.set( 1, heap.get( 0 ) );
                    index *= 2;
                }
            }
            System.out.println(index);
        }
    }
    
    public void heapUp( int index ) {
        while ( heap.get( index / 2 ) < heap.get( index ) ) {
            heap.set( 0, heap.get( index ) );
            heap.set( index, heap.get( index / 2 ) );
            heap.set( index / 2, heap.get( 0 ) );
        }
    }
    
    public void add( int value ) {
        if ( heap == null ) {
            heap.set( 0, null );
            heap.set( 1, value );
        }
        else {
            heap.add( value );
            heapUp( heap.indexOf( value ) );
        }
    }
    
    public int remove() {
        int toReturn = heap.get( 1 );
        heap.set( 1, null );
        heapDown();
        return toReturn;
    }
    
    public String toString() {
        String toReturn = "";
        for ( int i = 1; i < heap.size() - 1; i++ ) {
            toReturn += heap.get( i ) + ", ";
        }
        toReturn += heap.get( heap.size() - 1 );
        return toReturn;
    }
    
    public int size() {
        return heap.size() - 1;
    }
}
