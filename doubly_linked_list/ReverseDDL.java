public class ReverseDDL {

    // Node class representing each element in the list
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    Node head;

    // Method to reverse the doubly linked list
    public void reverse() {
        if (head == null || head.next == null) {
            System.out.println("The list is empty please append it.");
            return;
        } else {
            Node pre = null;
            Node current = head;
            while (current != null) {
                current.prev=current.next;
                current.next = pre;
                pre = current;
                current = current.prev;
            }
            head = pre;
        }
    }

    // Helper method to insert a node at the end (for testing)
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    // Helper method to print the list forward
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        ReverseDDL list = new ReverseDDL();

        // Creating a sample list: 1 <-> 2 <-> 3 <-> 4
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        System.out.println("Original List:");
        list.printList();

        list.reverse();

        System.out.println("Reversed List:");
        list.printList();
    }
}