public class SwapNodesInPairs {
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
    // IMPLEMENTATION
    // ---------------------------------------------------------
    public void swapPairs() {
        // 1. Edge case: if list has 0 or 1 node, no swap possible
        if (head == null || head.next == null) return;
        Node dummy=new Node(0);
        dummy.next=head;
        Node temp=dummy;
        while(temp!=null && temp.next.next!=null){
            Node first=temp.next;
            Node second=temp.next.next;
            first.next=second.next;
            second.next=temp.next;
            temp.next=second;
            temp=first;
        }
        head=dummy.next;
    }
    // ---------------------------------------------------------

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        SwapNodesInPairs list = new SwapNodesInPairs();
        // 1 -> 2 -> 3 -> 4 -> 5
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        System.out.println("Original List:");
        list.printList();

        list.swapPairs();

        System.out.println("After Swapping Pairs:");
        list.printList(); // Expected: 2 -> 1 -> 4 -> 3 -> 5
    }
}
