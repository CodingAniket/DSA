public class SwapInpairsDdl {
    
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
    // LOGIC TO IMPLEMENT: SWAP NODES IN PAIRS
    // =========================================================================
    
    /**
     * Swaps every two adjacent nodes in the doubly linked list in-place.
     * Modifies the pointers, not just the data values inside the nodes!
     */
    public void swapPairs() {
        // Edge cases: empty list or only one node means nothing to swap
        if (head == null || head.next == null) {
            return;
        }
        Node dummy=new Node(0);
        dummy.next=head;
        head.prev=dummy;
        Node pre=dummy;
        while(pre.next!=null && pre.next.next!=null){
        Node swap1=pre.next;
        Node swap2=swap1.next;
        swap1.next=swap2.next;
        if(swap2.next!=null) swap2.next.prev=swap1;
        swap2.next=pre.next;
        if(pre.next!=null) pre.next.prev=swap2;
        pre.next=swap2;
        swap2.prev=pre;
        pre=swap1;
        }
        head=dummy.next;
        if(head!=null) head.prev=null;
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
        SwapInpairsDdl list = new SwapInpairsDdl();
        
        // Creating sample list: 1 <-> 2 <-> 3 <-> 4 <-> 5
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(5);

        System.out.print("Original List: ");
        list.printList();

        list.swapPairs();

        System.out.print("After Swapping: ");
        list.printList(); 
        // Expected outcome: 2 <-> 1 <-> 4 <-> 3 <-> 5 <-> null
    }
}