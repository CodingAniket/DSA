public class RemoveDuplicates {
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
    public void removeDuplicates() {
        if (head == null) return;
        Node current=head;
        while(current!=null){
        Node compare=current;
        while(compare!=null && compare.next!=null){
            if(compare.next.data==current.data){
                compare.next=compare.next.next;
            } else{
            compare=compare.next;
        }
        }
        current=current.next;
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
        RemoveDuplicates list = new RemoveDuplicates();
        list.append(10);
        list.append(20);
        list.append(10);
        list.append(30);
        list.append(20);

        System.out.println("Before:");
        list.printList();

        list.removeDuplicates();

        System.out.println("After:");
        list.printList();
    }
}
