// Define Exception here
class IndexNotFoundException extends Exception {
    IndexNotFoundException(String massege) {
        super(massege);
    }
}

public class LinkedList {
    class Node {
        int data;
        Node nextNode;

        // Creating node structure
        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    // Creating pointers to store addresss of head node and last node also
    public Node head, tail;
    int counter;

    // Creating new method for creating a new Node
    public Node createNode(int data) {
        Node newNode = new Node(data);
        return newNode;
    }

    // Creating an Prepend method to insert into head
    public void prepend(int data) {
        Node newNode = createNode(data);
        Node temp = head;
        head = newNode;
        newNode.nextNode = temp;
        counter = counter + 1;
    }

    private Node getNodeSingly(int position) {
        Node temp = head;
        int i = 0;
        while (i != position - 1) {
            temp = temp.nextNode;
            i = i + 1;
        }
        return temp;
    }

    // Creating an append Method
    public void append(int data) {
        Node newNode = createNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.nextNode = newNode;
            tail = tail.nextNode;
        }
        counter = counter + 1;
    }

    // Creating a Print method for linked list
    public void PrintLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.err.println(temp.data);
            temp = temp.nextNode;
        }
    }

    // Creating insert method here
    public void insert(int position, int data) {
        try {
            if (position > counter || position < 0) {
                throw new IndexNotFoundException("Enter valid index please!");
            } else if (position == 0) {
                prepend(data);
            } else if (position == counter) {
                append(data);
            } else {
                Node newNode = new Node(data);
                Node tempNode = getNodeSingly(position);
                newNode.nextNode = tempNode.nextNode;
                tempNode.nextNode = newNode;
                counter = counter + 1;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Remove last Method is here
    public void RemoveLast() {
        Node temp = head;
        while (temp.nextNode.nextNode != null) {
            temp = temp.nextNode;
        }
        temp.nextNode = null;
        tail = temp;
        counter--;
    }

    // Remove from begining is here
    public void removeBegin() {
        Node temp = head;
        head = head.nextNode;
        temp.nextNode = null;
        counter--;
    }

    // Remove from postion
    public void RemoveFromPosition(int position) {
        try {
            if (position > counter) {
                throw new IndexNotFoundException("The index is not valid");
            } else if (position == counter) {
                RemoveLast();
            } else if (position == 0) {
                removeBegin();
            } else {
                Node temp = getNodeSingly(position);
                temp.nextNode = temp.nextNode.nextNode;
                counter--;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        LinkedList obj = new LinkedList();
        obj.append(0);
        obj.append(1);
        obj.append(2);
        obj.prepend(-1);
        obj.insert(2, 34);
        obj.RemoveFromPosition(2);
        obj.PrintLinkedList();
        System.out.println("The length of the linked list is : " + obj.counter);
    }
}