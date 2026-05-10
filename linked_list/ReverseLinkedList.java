public class ReverseLinkedList {
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
    public void reverse() {
        if (head == null || head.next == null)
            return;
        Node prev = null;
        Node current = head;
        Node nextNode = null;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev;

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
        ReverseLinkedList list = new ReverseLinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        System.out.println("Original:");
        list.printList();

        list.reverse();

        System.out.println("Reversed:");
        list.printList();
    }
}