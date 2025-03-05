/**
This class is full of themods to modify list nodes
@author Ta'Rissa Woods
@ version %I% %G%
*/
import static java.lang.System.*;

public class ListFunHouse
{
   public static void print(ListNode list) {
        while (list != null) {
            System.out.println(list.getValue() + " ");
            list = list.getNext();
        }
    }

    // This method will return the number of nodes present in the list
    public static int nodeCount(ListNode list) {
        int count = 0;
        while (list != null) {
            count++;
            list = list.getNext(); // Corrected to use the getNext() method.
        }
        return count;
    }

    // This method will create a new node with the same value as the first node and add this
    // new node to the list. Once finished, the first node will occur twice.
    public static void doubleFirst(ListNode list) {
        if (list == null){
            return; // Handle the case where the list is empty.
        } 

        ListNode newNode = new ListNode(list.getValue(), list.getNext());  // Create a new node with the same value as the first node.
        //newNode.setNext(list);  // Set its next to the current head node.
        list.setNext(newNode);  // Set the original head node's next to the new node, effectively doubling the first node.
    }



    // This method will create a new node with the same value as the last node and add this
    // new node at the end. Once finished, the last node will occur twice.
    public static void doubleLast(ListNode list) {
       if (list == null){
            return; // Handle the case where the list is empty.
        } 
            ListNode current = list;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        ListNode newNode = new ListNode(current.getValue(), null);
        current.setNext(newNode);
    }

    // Method skipEveryOther will remove every other node
    public static void skipEveryOther(ListNode list) {
        if (list == null || list.getNext() == null) {
            return;
        }

        ListNode current = list;
        while (current != null && current.getNext() != null) {
            current.setNext(current.getNext().getNext());  
            current = current.getNext();  
        }
    }

    // This method will set the value of every xth node in the list
    public static void setXthNode(ListNode list, int x, Comparable value) {
        if (list == null || x <= 0) {
            System.out.println("NOT VALID INDEX.");
            return;
        }

        int count = 1;
        ListNode current = list;
        while (current != null && count < x) {
            current = current.getNext();
            count++;
        }

        if (current == null) {
            System.out.println("OUT OF BOUNDS INDEX");
        } else {
            current.setValue(value);  // Corrected to use the setter method for value.
        }
    }

    // This method will remove every xth node in the list
    public static void removeXthNode(ListNode list, int x) {
        if (list == null || x <= 0) {
            System.out.println("INVALID INDEX");
            return;
        }

        // Special case for removing the head node
        if (x == 1) {
            list = list.getNext(); 
            return;
        }

        int count = 1;
        ListNode current = list;
        while (current != null && count < x - 1) {
            current = current.getNext();
            count++;
        }

        if (current == null || current.getNext() == null) {
            System.out.println("OUT OF BOUNDS INDEX");
        } else {
            current.setNext(current.getNext().getNext());
        }
    }
}
