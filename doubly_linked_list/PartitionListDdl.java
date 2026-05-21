public class PartitionListDdl {

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
    // LOGIC TO IMPLEMENT: PARTITION LIST
    // =========================================================================

    /**
     * Partitions the doubly linked list around a value x.
     * All nodes less than x should come before nodes greater than or equal to x.
     * Preserves original relative order of nodes within partitions.
     * 
     * @param x The partition value
     */
    public void partition(int x) {
        if (head == null || head.next == null) {
            return; // 0 or 1 elements don't need partitioning
        }
        Node dummyNode1 = new Node(0);
        Node dummyNode2 = new Node(0);
        dummyNode1.next = head;
        dummyNode2.next = head;
        Node temp = head;
        Node add1 = dummyNode1;
        Node add2 = dummyNode2;
        while (temp != null) {
            if (temp.data < x) {
                add1.next = temp;
                temp.prev = add1;
                add1 = add1.next;
            } else if (temp.data >= x) {
                add2.next = temp;
                temp.prev = add2;
                add2 = add2.next;
            }
            temp = temp.next;
        }
        add1.next = dummyNode2.next;
        add2.next = null;

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
        PartitionListDdl list = new PartitionListDdl();

        // Example list: 3 <-> 5 <-> 8 <-> 5 <-> 10 <-> 2 <-> 1
        list.append(3);
        list.append(5);
        list.append(8);
        list.append(5);
        list.append(10);
        list.append(2);
        list.append(1);

        System.out.print("Before Partition: ");
        list.printList();

        int partitionValue = 5;
        System.out.println("Partitioning around value: " + partitionValue);
        list.partition(partitionValue);

        System.out.print("After Partition:  ");
        list.printList();
        // Expected outcome shape: Nodes < 5 come first, then nodes >= 5
        // e.g., 3 <-> 2 <-> 1 <-> 5 <-> 8 <-> 5 <-> 10
    }
}
