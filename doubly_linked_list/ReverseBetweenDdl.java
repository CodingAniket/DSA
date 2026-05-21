public class ReverseBetweenDdl {

    static class Node {
        public int data;
        public Node prev;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;

    // =========================================================================
    // LOGIC TO IMPLEMENT: REVERSE BETWEEN
    // =========================================================================

    /**
     * Reverses the nodes of the list from position 'left' to 'right' (1-based
     * index).
     * 
     * @param left  The starting position to reverse (1-indexed)
     * @param right The ending position to reverse (1-indexed)
     */
    public void reverseBetween(int left, int right) {
        // Edge cases where no reversal is needed
        if (head == null || head.next == null || left == right) {
            return;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;
        Node pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        Node temp;
        Node current = pre.next;
        for (int i = 0; i < right - left; i++) {
            temp = current.next;
            current.next = temp.next;
            if (current.next != null)
                temp.next.prev = current;
            temp.next = pre.next;
            if (pre.next != null)
                pre.next.prev = temp;
            pre.next = temp;
            temp.prev = pre;
        }
        head = dummy.next;
    }

    // =========================================================================
    // UTILITY OPERATIONS
    // =========================================================================

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

    public void printList() {
        Node current = head;
        if (current == null) {
            System.out.println("Empty List");
            return;
        }
        while (current != null) {
            System.out.print(current.data + " <-> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // =========================================================================
    // MAIN METHOD FOR TESTING
    // =========================================================================
    public static void main(String[] args) {
        ReverseBetweenDdl list = new ReverseBetweenDdl();

        // Creating sample list: 10 <-> 20 <-> 30 <-> 40 <-> 50
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);

        System.out.print("Original List:    ");
        list.printList();

        int left = 2, right = 4;
        System.out.println("Reversing positions from " + left + " to " + right);
        list.reverseBetween(left, right);

        System.out.print("After Reversal:   ");
        list.printList();
        // Expected outcome: 10 <-> 40 <-> 30 <-> 20 <-> 50 <-> null
    }
}
