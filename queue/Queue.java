package DSA.queue;

public class Queue {
    private class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private int length;
    private Node first, last;

    Queue(int data) {
        Node newNode = new Node(data);
        first = newNode;
        last = newNode;
        length++;
    }

    public void printQueue() {
        Node temp = first;
        while (temp != null) {
            System.err.println(temp.data);
            temp = temp.next;
        }
    }

    public int firstInfo() {
        if (first == null) {
            return -1;
        } else {
            return first.data;
        }
    }

    public void enQueue(int data) {
        Node newNode = new Node(data);
        if (length == 0 || first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        System.out.println("The enque of the " + data + " is successful.");
        length++;
    }

    public int deQueue() {
        Node temp = first;
        if (temp == null)
            return -1;
        first = first.next;
        temp.next = null;
        System.out.println("The deQueue is successful.");
        length--;
        return temp.data;
    }

    public int queueLength() {
        return length;
    }

    public int lastInfo() {
        if (last == null)
            return -1;
        else {
            return last.data;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue(0);
        System.out.println("The length of Queue is: " + queue.length);
        queue.enQueue(1);
        queue.enQueue(2);
        queue.printQueue();
        System.out.println();
        queue.deQueue();
        queue.printQueue();
    }
}
