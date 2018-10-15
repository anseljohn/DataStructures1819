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
     * @returns true all the time
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
    }

    /**
     * Used to create a visual of the linked list ( readable )
     * 
     * @returns a string version of the linkedlist
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
