package com.company;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class linkedlists {
    //Class for custom exceptions
    public class linkedlistexception extends Exception {
        public linkedlistexception(String errorMessage) {
            super(errorMessage);
        }

        public linkedlistexception(String errorMessage, Throwable error) {
            super(errorMessage, error);
        }
    }

    //Class for nodes
    class node {
        public Integer data;
        public node next;

        node() //creating node
        {
            next = null; //this will act as the sentinel value that points to the end of the list
        }

        node(Integer value) //creating node
        {
            data = value;
            next = null;
        }

    }


    class LinkedList implements Iterable<Integer>
    {
        ListIterator<Integer> iterator = null;

        @Override
        public ListIterator<Integer> iterator()
        {
            return new LinkedListIterable(this);
        }

        node first = new node(); //set node to null right now so it's denoting the end of the list. This will serve as a reference to the first node.

        void addFirst(Integer value) {
            if (first.next == null) //case: list is empty
            {
                first.next = new node(value);
            } else //case: list is not empty at least one node on the list
            {
                node newnode = new node(value); //allocating memory for the new node
                newnode.next = first.next; //changing new node pointer from null to what the first.next is pointing to
                first.next = newnode; //changing what the first node pointer is pointing to previously to where the new node information is pointing to
            }
        }

        void removeFirst() {
            try {
                if (first.next == null) //case: list is empty
                {
                    //MAKE EXCEPTION HERE TO LET THEM KNOW THERE IS NOTHING ON THE LIST
                    throw new NullPointerException();

                } else //case: list is not empty at least one node on the list
                {
                    node temp = first.next; //creating a temporary node that points to where the first node is also pointing to
                    first.next = temp.next; //moving the first node's pointer to the next node pointer effectively removing the original head from the list
                }
                return;
            } catch (NullPointerException exception) {
                System.out.println(exception + ":" + " The list is empty, so there is nothing to remove.");
            }
        }

        void getFirst() throws linkedlistexception //custom exception
        {
            if (first.next == null)//case: list is empty
            {
                //MAKE EXCEPTION HERE TO LET THEM KNOW THERE IS NOTHING ON THE LIST
                throw new linkedlistexception("The list is empty, so there is nothing to return.");

            } else //case: list is not empty at least one node on the list
            {
                System.out.println("The first element is: " + first.next.data); //printing out the data for the element in the first node (accompanying train car on list)
            }
        }
    }

    class LinkedListIterable implements ListIterator<Integer>
    {
        private node nodePtr;
        LinkedListIterable(LinkedList aThis)
        {
            nodePtr = aThis.first.next;
        }


        @Override
        public Integer next()
        {
            if (nodePtr == null)
            {
                throw new NoSuchElementException();
            }
            Integer temp = nodePtr.data;
            nodePtr = nodePtr.next;
            return temp;
        }

        @Override
        public boolean hasNext()
        {
            return nodePtr != null;
        }

        @Override
        public void set(Integer j) //will set the first node to a different value whether it is null or a different value
        {
            if (nodePtr == null)
            {
                nodePtr.data = j;
            }
            else
            {
                nodePtr.data = j;
            }
        }

        @Override
        public void add(Integer i) //will add to the end of the linked list rather than the front/frist
        {
            if (nodePtr == null)
            {
                nodePtr = new node(i);
            }
            else
            {
                node temp = nodePtr;
                while (temp.next != null)
                {
                    temp = temp.next;
                }
                node nn = new node(i);
                nn.next = temp.next;
                temp.next = nn;
            }
        }

        @Override
        public void remove()     //will remove the last node in the linked list rather than the first one
        {
            if (nodePtr ==null)
            {
                throw new NoSuchElementException();
            }
            else
            {
                node temp = nodePtr;
                node trail = null;
                while (temp.next != null)
                {
                    trail = temp;
                    temp = temp.next;
                }
                if (trail == null)
                {
                    nodePtr = temp.next; //copying over the null
                }
                else
                {
                    trail.next = temp.next; //copying over the null and node at temp will be deleted by garbage collection
                }
            }
        }

        @Override
        public int nextIndex()
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public int previousIndex()
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean hasPrevious()
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public Integer previous()
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }

    public static void main(String [] args)
    {
        //Initialize the inner classes
        linkedlists outer = new linkedlists();
        linkedlists.LinkedList ll1 = outer.new LinkedList();
        linkedlists.LinkedList ll2 = outer.new LinkedList();
        //The part demonstrating the functionality of the Linked List
        ll1.addFirst(9);
        ll1.addFirst(10);
        ll1.addFirst(30);
        ll1.addFirst(90);
        ll1.addFirst(1234);
        ll1.addFirst(5432);

        System.out.println("The linked list using the addFirst method to add values to the front of the list:");
        ListIterator iterator1 = ll1.iterator();
        while (iterator1.hasNext())
        {
            System.out.println(iterator1.next());
        }
        System.out.println("__________________________________________________________________________");
        System.out.println("The linked list using the getFirst method to retrieve the first value in the list:");
        try
        {
            ll1.getFirst();
        }
        catch (linkedlists.linkedlistexception linkedlistexception) //leaves it up to user to act next as it is a custom exception so it can crash or keep going or more
        {
            linkedlistexception.printStackTrace();
        }
        System.out.println("__________________________________________________________________________");
        ll1.removeFirst();
        System.out.println("The linked list after using Linked List method removeFirst to remove the first element:");
        ListIterator iterator2 = ll1.iterator();
        while (iterator2.hasNext())
        {
            System.out.println(iterator2.next());
        }
        System.out.println("__________________________________________________________________________");
        System.out.println("The linked list printed out using the Iterator methods next and hasNext:");
        ListIterator iterator11 = ll1.iterator();
        while (iterator11.hasNext())
        {
            System.out.println(iterator11.next());
        }
        System.out.println("__________________________________________________________________________");

        //The part demonstrating the functionality of the Iterator functions not used already
        System.out.println("The linked list after using the Iterator method set to change the first value on list to 1:");
        ListIterator iterator3 = ll1.iterator();
        iterator3.set(1);
        ListIterator iterator4 = ll1.iterator();
        while (iterator4.hasNext())
        {
            System.out.println(iterator4.next());
        }
        System.out.println("__________________________________________________________________________");
        System.out.println("The linked list after using the Iterator method add to put a value at the end of the list which will be 20 in this case:");
        ListIterator iterator5 = ll1.iterator();
        iterator5.add(20);
        ListIterator iterator6 = ll1.iterator();
        while (iterator6.hasNext())
        {
            System.out.println(iterator6.next());
        }
        System.out.println("__________________________________________________________________________");
        System.out.println("The linked list after using the Iterator method remove to remove the value at the end of the list which is 20 in this case:");
        ListIterator iterator7 = ll1.iterator();
        iterator7.remove();
        ListIterator iterator8 = ll1.iterator();
        while (iterator8.hasNext())
        {
            System.out.println(iterator8.next());
        }
        System.out.println("__________________________________________________________________________");
        //Instantiating a second Linked List that allows the user to input an arbitrary number of integer values ending with a sentinel value and add them to the linked list
        Scanner input = new Scanner(System.in);
        System.out.println("Type in as many integers as you want to be added to the Linked List. Type something other than an integer to terminate input.");
        Boolean linkedlistinput;
        while (linkedlistinput = true)
        {
            if (input.hasNextInt())
            {
                ll2.addFirst(input.nextInt());
            }
            else
            {
                break;
            }
        }
        System.out.println("The user inputted linked list:");
        ListIterator iterator9 = ll2.iterator();
        while (iterator9.hasNext())
        {
            System.out.println(iterator9.next());
        }
        //Use the iterator to iterate over the values in the linked list, sum them, and print the sum
        System.out.println("The sum of the user inputted linked list calculated using the Iterator:");
        Integer sum = 0;
        ListIterator iterator10 = ll2.iterator();
        while (iterator10.hasNext())
        {
            sum += (Integer) iterator10.next();
        }
        System.out.println(sum);
    }
}
