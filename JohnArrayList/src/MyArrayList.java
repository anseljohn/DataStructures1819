import java.util.Collection;

/**
 * Making the ArrayList class woot woot
 * 
 * @author AnselmJA20
 * @param E the Object type
 * @version 3.14159
 */

public class MyArrayList<E> {
    private int size;
    private Object[] vals;

    /**
     * Default constructor setting the size to 0
     *  and the size to 8
     */
    public MyArrayList() {
        size = 0;
        vals = new Object[8];
    }

    /**
     * Another constructor except it sets the size to a 
     * user inputted value
     * 
     * @param startCapacity the capacity to start at
     */
    public MyArrayList( int startCapacity ) {
        size = 0;
        vals = new Object[startCapacity];
    }
    
    /**
     * Constructor adding in all the elements in Collection c
     * @param c is the collection to build the arraylist at
     */
    public MyArrayList( Collection<E> c ) {
        this( c.size() );
        addAll( c );
    }

    /**
     * Adds an object to the end of the array
     * 
     * @param obj the object to add
     * @return true no matter what
     */
    public boolean add( E obj ) {
        ensureCapacity( size + 2);
        size++;
        vals[size - 1] = obj;
        return true;
    }

    /**
     * Adds an object to a certain index in the array
     * 
     * @param index the index to add the obj at
     * @param obj the object to add
     */
    public void add( int index, E obj ) {
        ensureCapacity( size + 2 );
        for ( int i = size + 1; i > index; i-- ) {
            vals[i] = vals[i - 1];
        }
        size++;
        vals[index] = obj;
    }

    /**
     * Removes the first occurrence of Object o
     * 
     * @param o the object to remove
     * @return true no matter what
     */
    public boolean remove( Object o ) {
        remove( indexOf( o ) );
        return true;
    }

    /**
     * Remove the Object at index index
     * 
     * @param index the index at which to remove the object
     * @return the Object that was removed
     */
    @SuppressWarnings("unchecked")
    public E remove( int index ) {
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        Object toReturn = vals[index];
        for ( int i = index; i < size - 1; i++ ) {
            vals[i] = vals[i + 1];
        }
        vals[--size] = null;
        return (E) toReturn;
    }

    /**
     * Returns the Object o's last occurence's index
     * 
     * @param o the object to return the index of
     * @return the Object o's last occurence's index
     */
    public int indexOf( Object o ) {
        for ( int i = 0; i < size; i++ ) {
            if ( vals[i].equals( o ) ) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the Object o's last occurence's index
     * 
     * @param o the object to find the last index of
     * @return -1 or the last index of the object
     */
    public int lastIndexOf( Object o ) {
        for ( int i = size - 1; i >= 0; i-- ) {
            if ( vals[i].equals( o ) )
                return i;
        }
        return -1;
    }

    /**
     * Returns  the object at the index
     * @param index the index to get the object at
     * @return the object at the index
     */
    @SuppressWarnings("unchecked")
    public E get( int index ) {
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        else
            return (E) vals[index];
    }

    
    /**
     * sets a certain index to a certain object
     * @param index the index to change
     * @param o the object to replace the object at index index
     * @return the object replaced
     */
    @SuppressWarnings("unchecked")
    public E set( int index, E o ) {
        Object toReturn = vals[index];
        vals[index] = o;
        return (E) toReturn;
    }

    /**
     * gets the amount of objects
     * @return the amount of objects
     */
    public int size() {
        return size;
    }

    /**
     * says if the array contains a certain object
     * @param o the object to find
     * @return if Object o exists in the array 
     */
    public boolean contains( Object o ) {
        return java.util.Arrays.asList( vals ).indexOf( o ) > -1;
    }

    /**
     * Makes sure the array is at a certain length
     * @param minCap the minimum capacity for the array to be at
     */
    public void ensureCapacity( int minCap ) {
        Object[] temp = new Object[vals.length];
        // if ( minCap < 0 )
        // {
        // temp = new Object[Integer.MAX_VALUE];
        // }
        if ( minCap > vals.length ) {
            temp = new Object[minCap];
            for ( int i = 0; i < vals.length; i++ ) {
                temp[i] = vals[i];
            }
            vals = new Object[minCap];
            for ( int i = 0; i < vals.length; i++ ) {
                vals[i] = temp[i];
            }
        }

    }

    /**
     * Returns the array as a String
     * 
     * @return the array as a String
     */
    public String toString() {
        if ( size != 0 ) {
            String toReturn = "[";
            for ( int i = 0; i < size - 1; i++ ) {
                toReturn += vals[i] + ", ";
            }
            toReturn += vals[size - 1] + "]";
            return toReturn;
        }
        else {
            return "[]";
        }
    }
    
    /**
     * Returns if the array is empty
     * @return true of the array is empty or false if it isn't
     */
    public boolean isEmpty() {
        return vals.length == 0;
    }
    
    /**
     * Adds all collection values to the array
     * @throws NullPointerException if the collection is empty
     * @param c the collection to add
     */
    public void addAll( Collection<E> c ) {
        if ( c == null ) {
            throw new NullPointerException();
        }
        for ( E elem : c ) {
            add( elem );
        }
    }
    
    /**
     * trims to size
     */
    public void trimToSize() {
        Object[] temp = new Object[size];
        for ( int i = 0; i < size; i++ ) {
            temp[i] = vals[i];
        }
        vals = new Object[size];
        for ( int i = 0; i < temp.length; i++ ) {
            vals[i] = temp[i];
        }
    }
    
    /**
     * Removes all elements from the array
     */
    public void clear() {
        vals = new Object[0];
        size = 0;
    }
    
    /**
     * @param from is the starting index of what to remove
     * @param to is the ending index of what to remove
     * @throws IndexOutOfBoundsException if from or 
     * to is out of the index range
     */
    public void removeRange( int from, int to ) {
        if( from < 0 || to > size || from > size ) {
            throw new IndexOutOfBoundsException();
        }
        for ( int i = to; i >= from; i-- ) {
            remove( i );
        }
    }
    
    /**
     * @return Object array of the arraylsitasatop
     */
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        for ( int i = 0; i < newArray.length; i++ ) {
            newArray[i] = vals[i];
        }
        return newArray;
    }
    
    /**
     * tests to see if the array is equals to the araryl[
     * @throws NullPointerException if the parameter is null
     * @return if the arraylist equals the inputted arraylist
     */
    public boolean equals( MyArrayList<E> m ) {
        if ( m == null ) {
            throw new NullPointerException();
        }
        for ( int i = 0; i < size; i++ ) {
            if ( !( vals[i].equals( m.get( i ) ) ) ) {
                return false;
            }
        }
        return true;
    }
    
}