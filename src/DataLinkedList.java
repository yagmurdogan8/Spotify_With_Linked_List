import java.util.Iterator;
import java.util.StringJoiner;

public class DataLinkedList<T> implements Iterable<T>
{
    private Node head;
    private Node tail;
    private int size;

    private class Node
    {
        private T value;
        private Node next;

        public Node(T value)
        {
            this.value = value;
        }
    }
    public void printList(DataLinkedList list)
    {
        Node currNode = list.head;

        System.out.print("\nLinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.value + " ");

            // Go to next node
            currNode = currNode.next;
        }
        System.out.println("\n");

    }
    public int countNode(Node head)
    {
        int count = 0;

        while (head.next != null)
        {

            // Starting from the next node
            Node ptr = head.next;
            while (ptr != null)
            {

                // If some duplicate node is found
                if (head.value == ptr.value)
                {
                    count++;
                    break;
                }
                ptr = ptr.next;
            }

            head = head.next;
        }

        // Return the count of duplicate nodes
        return count;
    }
    public void add(T value)
    {
        Node node = new Node(value);

        if (head == null)
        {
            head = node;
        }
        else
        {
            tail.next = node;
        }

        tail = node;
        ++size;
    }
    public void removeDuplicates() {
        Node ptr1 = null, ptr2 = null, dup = null;
        ptr1 = head;

        /* Pick elements one by one */
        while (ptr1 != null && ptr1.next != null) {
            ptr2 = ptr1;

            /* Compare the picked element with rest
                of the elements */
            while (ptr2.next != null) {

                /* If duplicate then delete it */
                if (ptr1.value == ptr2.next.value) {

                    /* sequence of steps is important here */
                    dup = ptr2.next;
                    ptr2.next = ptr2.next.next;
                    System.gc();
                } else /* This is tricky */ {
                    ptr2 = ptr2.next;
                }
            }
            ptr1 = ptr1.next;
        }
    }
    public boolean remove(T value)
    {
        Node previous = null;
        Node current = head;

        while (head != null)
        {
            if (current.value.equals(value))
            {
                if (previous != null)
                {
                    previous.next = current.next;

                    if (current.next == null)
                    {
                        tail = previous;
                    }
                }
                else
                {
                    head = current.next;

                    if (head == null)
                    {
                        tail = null;
                    }
                }

                --size;
                return true;
            }

            previous = current;
            current = current.next;
        }

        return false;
    }

    public boolean contains(T value)
    {
        Node current = head;

        while (current != null)
        {
            if (current.value.equals(value))
            {
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public void clear()
    {
        head = null;
        tail = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }
    public String getValue(T value){
        return (String) value;
    }

    @Override
    public Iterator<T> iterator()
    {
        return new Iterator<T>()
        {
            private Node current = head;

            @Override
            public boolean hasNext()
            {
                return current != null;
            }

            @Override
            public T next()
            {
                Node next = current;
                current = current.next;
                return next.value;
            }
        };
    }

    @Override
    public String toString()
    {
        StringJoiner joiner = new StringJoiner(", ");

        for (T value : this)
        {
            joiner.add(value.toString());
        }

        return joiner.toString();
    }

}