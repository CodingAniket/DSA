public class ReverseSublist {
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
    public void reverseBetween(int m, int n) {
        // 1. Edge cases: empty list or m == n (no work needed)
        if (head == null || m == n) return;
        else{
            Node dummy=new Node(0);
            dummy.next=head;
            Node prev=dummy;
            for(int i=0;i<m-1;i++){
                prev=prev.next;
            }
            Node current=prev.next;
            for(int i=0;i<n-m;i++){
                Node temp=current.next;
                current.next=temp.next;
                temp.next=prev.next;
                prev.next=temp;
            }
            head=dummy.next;
        }
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
        ReverseSublist list = new ReverseSublist();
        // 10 -> 20 -> 30 -> 40 -> 50
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);

        System.out.println("Original:");
        list.printList();

        // Reverse from position 2 to 4 (20, 30, 40)
        list.reverseBetween(2, 4);

        System.out.println("Reversed (2 to 4):");
        list.printList(); // Expected: 10 -> 40 -> 30 -> 20 -> 50
    }
}