import java.util.Collection;

/**
 * Recreation of the LinkedList class
 * 
 * @author AnselmJA20 John Anselmo
 * @version 1.0
 * @param <E> the Object type
 */
public class MyLinkedList<E> {
    private int size;
    private Node<E> head;

    /**
     * Constructs an empty list
     */
    public MyLinkedList() {
        size = 0;
        head = null;
    }

    /**
     * Constructs a MyLinkedList with a collection
     * 
     * @param c the collection to construct the 
     * linkedlist with
     */
    public MyLinkedList( Collection<E> c ) {
        for ( E e : c ) {
            add( e );
        }
    }

    /**
     * adds object to the linkedlist
     * 
     * @param e the element to add to the linkedlist
     * @return true all the time
     */
    public boolean add( E e ) {
        if ( head == null ) {
            head = new Node<E>( e );
        } 
        else {
            Node<E> tail = head;
            while ( tail.next != null ) {
                tail = tail.next;
            }
            tail.next = new Node<E>( e );
        }
        size++;
        return true;
    }
    
    /**
     * adds the object to the specified index
     * @param index the index to add e to
     * @param e the element to add
     */
    public void add( int index, E e ) {
        if ( index < 0 || index > size ) {
            throw new IndexOutOfBoundsException();
        }
        else if ( head == null ) {
            head = new Node<E>( e );
        }
        else if ( index == 0 ) {
            head = new Node<E>( e, head );
        }
        else {
            Node<E> temp = head;
            for ( int i = 0; i < index - 1; i++ ) {
                temp = temp.next;
            }
            temp.next = new Node<E>( e, temp.next );
        }
        size++;
    }
    
    /**
     * removes the specified object
     * @param o the object to remove
     * @return true if the list contains the element
     */
    public boolean remove( Object o ) {
        try {
            remove( indexOf( o ) );
        }
        catch ( IndexOutOfBoundsException e ) {
            return false;
        }
        return true;
    }
    
    /**
     * removes the object at the index
     * @param index the index of the object to remove
     * @return the object at the index
     * @throws IndexOutOfBoundsException when index < 0
     * || index >= size
     */
    public E remove( int index ) {
        Node<E> temp = head;
        E rem = null;
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        else if ( index == 0 ) {
            rem = head.data;
            head = head.next;
        }
        else {
            for ( int i = 0; i < index - 1; i++ ) {
                temp = temp.next;
            }
            rem = temp.next.data;
            temp.next = temp.next.next;
        }
        size--;
        return rem;
    }
    
    /**
     * returns the element at index index
     * @param index the element to get
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException when 
     * index < 0 || index >= size
     */
    public E get( int index ) {
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = head;
        for ( int i = 0; i < index; i++ ) {
            temp = temp.next;
        }
        return temp.data;
    }
    
    /**
     * sets a thing to a thing
     * @param index the index to change
     * @param obj the obj to replace the index w
     * @throws IndexOutOfBoundsException if index < 0 || index >= size
     * @return the previous obj
     */
    public E set( int index, E obj ) {
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        E toReturn = remove( index );
        add( index, obj );
        return toReturn;
    }
    
    /**
     * gives the size of the linkedlist
     * @return the amount of elements in the linkedlist
     */
    public int size() {
        return size;
    }
    
    /**
     * tells whether or not the specified element is 
     * in the linkedlist
     * @param o the object that may or may not be in
     * the list
     * @return whether o is in the list or not
     */
    public boolean contains( Object o ) {
        Node<E> temp = head;
        while ( temp != null ) {
            if ( temp.data.equals( o ) ) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    
    /**
     * says if the list is empty
     * @return if the list contains 0 elements
     */
    public boolean isEmpty() {
        return size == 0;
    }
    
    /**
     * adds all elements in the collection to the linkedlist
     * @param c the collection of elements to add
     */
    public void addAll( Collection<E> c ) {
        for ( E e : c ) {
            add( e );
        }
    }
    
    /**
     * clears the linkedlist
     */
    public void clear() {
        head = null;
        size = 0;
    }
    
    /**
     * returns the index of the first occurrence of the 
     * specified object
     * @param o the object to find the index of
     * @return the object's first index
     */
    public int indexOf( Object o ) {
        int index = 0;
        for ( Node<E> temp = head; temp != null; temp = temp.next ) {
            if ( temp.data.equals( o ) ) {
                return index;
            }
            index++;
        }
        return -1;
    }
    
    /**
     * returns the last occurrence's index
     * @param o the object to find the last index of
     * @return the last index of the object
     */
    public int lastIndexOf( Object o ) {
        int index = -1;
        int curr = 0;
        for ( Node<E> temp = head; temp != null; temp = temp.next ) {
            if ( temp.data.equals( o ) ) {
                index = curr;
            }
            curr++;
        }
        return index;
    }
    
    /**
     * removes all elements between the specified
     * indices non inclusive
     * @param from the first element to remove
     * @param to the index after the last element to
     * remove
     */
    public void removeRange( int from, int to ) {
        for ( int i = to - 1; i >= from; i-- ) {
            remove( i );
        }
    }
    
    /**
     * returns an array version of the linkedlist
     * @return an array of the linkedlist elements
     */
    public Object[] toArray() {
        Object[] toReturn = new Object[ size ];
        int index = 0;
        for ( Node<E> temp = head; temp != null; temp = temp.next ) {
            toReturn[ index ] = ( Object ) temp.data;
            index++;
        }
        return toReturn;
    }
    
    /**
     * returns if the object is equal to the linkedlist
     * @param o the object to test
     * @return if the object is equal to the linkedlist
     */
    public boolean equals( Object o ) {
        if ( o == this ) {
            return true;
        }
        if ( ! (o instanceof MyLinkedList ) ) {
            return false;
        }
        MyLinkedList other = ( MyLinkedList ) o;
        if ( size() == other.size() ) {
            for (int i = 0; i < size; i++ ) {
                if ( ! get( i ).equals( other.get( i ) ) ) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Used to create a visual of the linked list 
     * ( readable )
     * @return a string version of the linkedlist
     */
    public String toString() {
        if ( size == 0 ) {
            return "[]";
        }
        String toReturn = "[";
        Node<E> current = head;
        while ( current.next != null ) {
            toReturn += current.data + ", ";
            current = current.next;
        }
        toReturn += current.data + "]";
        return toReturn;
    }

    /**
     * Node class for the LinkedList class
     * 
     * @author AnselmJA20
     * @version 1.0
     * @param <E> the Object type for the node;
     */
    public class Node<E> {
        private Node<E> next;
        private E data;

        /**
         * Constructs a node with data and next node
         * 
         * @param data the data to set the node's
         * data to
         * @param next the node that this new node 
         * looks to
         */
        public Node( E data, Node<E> next ) {
            this.next = next;
            this.data = data;

        }

        /**
         * constructs a new node with just data and 
         * next as null
         * 
         * @param data the data to set the node to
         */
        public Node( E data ) {
            next = null;
            this.data = data;
        }
    }
}
