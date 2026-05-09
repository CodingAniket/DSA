public class HasLoopLinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;

    // Helper to add data
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
    public boolean hasLoop() {
        Node fast=head;
        Node slow=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow) return true;
        }
        return false;
    }
    // ---------------------------------------------------------

    public static void main(String[] args) {
        HasLoopLinkedList list = new HasLoopLinkedList();
        
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        // Creating a manual loop for testing: 4 -> 2
        list.head.next.next.next.next = list.head.next;

        System.out.println("Does the list have a loop? " + list.hasLoop());
    }
}
