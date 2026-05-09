public class FindMiddleLinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // ---------------------------------------------------------
    // TODO: IMPLEMENT YOUR SOLUTION BELOW
    // ---------------------------------------------------------
    public int findMiddle() {
        if (head == null) {
            return -1; // Or throw an exception
        }
        Node fast=head;
        Node slow=head;
        while (fast!=null && fast.next!=null) {
         fast=fast.next.next;
         slow=slow.next;
        }
        return slow.data; 
    }
    // ---------------------------------------------------------

    public static void main(String[] args) {
        FindMiddleLinkedList list = new FindMiddleLinkedList();
        
        // Test Case: 1 -> 2 -> 3 -> 4 -> 5
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        System.out.println("The middle element is: " + list.findMiddle());
    }
}