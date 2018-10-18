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
     * @param c the collection to construct the linkedlist with
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
        } else {
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
        if ( index < 0 || index >= size ) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> temp = head;
        for ( int i = 0; i < index - 1; i++ ) {
            temp = temp.next;
        }
        temp.next = new Node<E>( e, temp.next );
        size++;
    }
    
    /**
     * removes the specified object
     * @param o the object to remove
     * @return true if the list contains the element
     */
    public boolean remove( Object o ) {
        Node<E> temp = head;
        while( ! temp.next.data.equals( o ) ) {
            temp = temp.next;
            if ( temp.next == null ) {
                return false;
            }
        }
        size--;
        
        temp.next = temp.next.next;
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
       E rem;
       for ( int i = 0; i < index; i++ ) {
           temp = temp.next;
       }
       rem = temp.data;
       temp.next = temp.next.next;
       size--;
       return rem;
       // 1 -> 2 -> 3
   }
    
    /**
     * returns the element at index index
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException when index < 0 || index >= size
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
    
    public E set( int index, E obj ) {
        E toReturn = remove( index );
        add( index, obj );
        return toReturn;
    }

    /**
     * Used to create a visual of the linked list ( readable )
     * @return a string version of the linkedlist
     */
    public String toString() {
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
         * @param data the data to set the node's data to
         * @param next the node that this new node looks to
         */
        public Node( E data, Node<E> next ) {
            this.next = next;
            this.data = data;

        }

        /**
         * constructs a new node with just data and next as null
         * 
         * @param data the data to set the node to
         */
        public Node( E data ) {
            next = null;
            this.data = data;
        }
    }
}
