public class KthNodeFromEnd {
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
    public int findKthFromEnd(int k) {
        if(k<0)
        return -1;
        Node fast=head;
        Node slow=head;
        if(fast==null) return -1;
        for(int i=0;i<k;i++) fast=fast.next;
        while(fast!=null){
            fast=fast.next;
            slow=slow.next; 
        }
       return slow.data;
    }
    // ---------------------------------------------------------

    public static void main(String[] args) {
        KthNodeFromEnd list = new KthNodeFromEnd();
        
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);

        int k = 4; 
        System.out.println("The " + k + "th node from end is: " + list.findKthFromEnd(k));
        // Expected: 40
    }
}