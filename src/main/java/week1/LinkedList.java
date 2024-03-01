package week1;

import java.util.Iterator;

public class LinkedList<Data> implements Iterable<Data> {
    private Node<Data> head;
    private int size = 0;

    /* Add a new item to the beginning of the list */
    public void addToFront(Data data) {
        Node<Data> newNode = new Node<>();      // Instantiating of the new node
        newNode.data = data;                    // Setting the data of new node to data that was passed as parameter.
        newNode.next = head;                    // Setting the news node next node. It will be previous head node.
        head = newNode;                         // Updating the head node with new node, since we added new node to front.
        size++;                                 // Size increment since we added additional node to our linked list.
    }

    /* Remove an item from the beginning of the list */
    public void removeFromFront() {
        if (head == null) {                                                     // Checking whether we have node.
            throw new IndexOutOfBoundsException("The linked list is empty.");   // If there is no existing node, throw exception
        }                                                                       //
        head = head.next;                                                       // Check passed, we set head node to be the very next node in list, JavaGarbageCollector will do the rest.
        size--;                                                                 // Size decrement since we removed node from linked list.
    }

    /* Add a new item to the end of the list */
    public void addToRear(Data data) {
        Node<Data> newNode = new Node<>();          // 1
        newNode.data = data;                        // 1

        if (head == null) {                         // 2
            head = newNode;                         // 2
        } else {
            Node<Data> current = head;              // 3
            while (current.next != null) {          // 4
                current = current.next;             // 4
            }                                       // 4
            current.next = newNode;                 // 5
        }
        size++;                                     // 6
    }

    /* Remove an item from the end of the list */
    public void removeFromRear() {
        if (head == null) {                                                     // 1
            throw new IndexOutOfBoundsException("The linked list is empty.");   // 1
        } else if (size == 1) {                                                 // 2
            head = null;                                                        // 2
        } else {                                                                // 3
            Node<Data> current = head;                                          // 3
            while (current.next.next != null) {                                 // 4
                current = current.next;                                         // 4
            }                                                                   // 4
            current.next = null;                                                // 5
        }
        size--;                                                                 // 6
    }

    /* Get a linked list node by index (0-indexed) */
    public Data get(int index) {
        if (index < 0 || index >= size) {										// 1
            throw new IndexOutOfBoundsException("Invalid linked list node.");	// 1
        }

        Node<Data> current = head;												// 2
        int i = 0;																// 3
        while (i < index) {														// 4
            current = current.next;												// 4
            i++;																// 4
        }

        return current.data;													// 5
    }

    /* Add an element to a linked list by index (0-index) */
    public void add(int index, Data data) {
        // your code
        Node<Data> dataNode = new Node<>();
        dataNode.data = data;

        if (size == 0) {
            head = dataNode;
            head.next = null;
            size++;
        } else if (size == 1) {
            Node<Data> addedNode = new Node<>();
            addedNode.data = dataNode.data;
            addedNode.next = null;
            head.next = addedNode;
            size++;
        } else {
            Node<Data> current = head;
            int i = 0;
            while (i < index - 1) {
                current = current.next;
                i++;
            }
            dataNode.next = current.next;
            current.next = dataNode;
            size++;
        }
    }

    /* Delete an element from a linked list by index (0-index) */
    public void remove(int index) {
        // your code
        if (index < 0 || index >= size || head == null) {
            throw new IndexOutOfBoundsException("Invalid linked list node.");
        } else if (size == 1) {
            head = null;
            size--;
        } else if (index == 0) {
            head = head.next;
            size--;
        } else {
            Node<Data> current = head;
            int i = 0;
            while (i < index - 1) {
                current = current.next;
                i++;
            }
            current.next = current.next.next;
            size--;
        }
    }

    public void reverse() {
        Node<Data> current = head;                                              // 1
        Node<Data> previous = null;                                             // 1

        while (current != null) {                                               // 2
            Node<Data> next = current.next;                                     // 3
            current.next = previous;                                            // 4
            previous = current;                                                 // 5
            current = next;                                                     // 6
        }
        head = previous;                                                        // 7
    }

    /* Return the size of the linked list */
    public int count() {
        return size;
    }

    /* Define the Iterator class, and hasNext() and next() methods */
    private class LinkedListIterator implements Iterator<Data> {        // 1
        Node<Data> current = head;                                      // 2

        public boolean hasNext() {                                      // 3
            return current != null;                                     // 3
        }                                                               // 3

        public Data next() {                                            // 4
            Data data = current.data;                                   // 4
            current = current.next;                                     // 4
            return data;                                                // 4
        }
    }

    /* Return an Iterator Object */
    public Iterator<Data> iterator() {
        return new LinkedListIterator();
    }
}