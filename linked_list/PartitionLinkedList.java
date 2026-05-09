public class PartitionLinkedList {
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
    public void partition(int x) {
        if (head == null) return;
        else{
            Node dummy1=new Node(0);
            Node dummy2=new Node(0);
            Node temp1=dummy1;
            Node temp2=dummy2;
            Node temp=head;
            while(temp!=null){
                if(temp.data>=x){
                 temp1.next=temp;
                 temp1=temp1.next;
                } else if(temp.data<x){
                 temp2.next=temp;
                 temp2=temp2.next;
                }
                temp=temp.next;
            }
           temp1.next=dummy2.next;
           temp2.next=null;
           head=dummy1.next;

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
        PartitionLinkedList list = new PartitionLinkedList();
        // 1 -> 4 -> 3 -> 2 -> 5 -> 2, x = 3
        list.append(1);
        list.append(4);
        list.append(3);
        list.append(2);
        list.append(5);
        list.append(2);

        System.out.println("Original:");
        list.printList();

        list.partition(3);

        System.out.println("Partitioned around 3:");
        list.printList();
    }
}
