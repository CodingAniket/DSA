public class DoublyLinkedList {
    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head, tail;
    int length = 0;

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            length++;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            length++;
        }
    }

    public void prepend(int data){
      Node newNode=new Node(data);
      if (head == null) {
        head = newNode;
        tail = newNode;
        length++;} else{
      newNode.next=head;
      head.prev=newNode;
      head=newNode;
      length++;
        }
    }

    public void insert(int data,int pos){
         if(pos<0 || pos>length){
            System.out.println("The position is invalid");
        } else if(pos==length){
            append(data);
        } else if(pos==0){
            prepend(data);
        }
        else{
            Node newNode=new Node(data);
            Node temp=head;
            for(int i=0;i<pos-1;i++){
                temp=temp.next;
            } 
            newNode.next=temp.next;
            newNode.prev=temp;
            temp.next=newNode;
            newNode.next.prev=newNode;
            length++;
        }
    }

    public void removeFront(){
        head=head.next;
        head.prev=null;
        length--;
    }
   
    public void removeLast(){
        tail=tail.prev;
        tail.next=null;
        length--;
    }

    public void removeIndex(int pos){
    if(pos==length){
     removeLast();
    } else if(pos==0){
        removeFront();
    } else{
    Node temp=head;
    for(int i=0;i<pos-1;i++){
        temp=temp.next;
    } 
    temp.next=temp.next.next;
    temp.next.prev=temp;
    length--; }
    }
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("The length of the linked List is: " + length);
    }

    public static void main(String[] args) {
        DoublyLinkedList obj = new DoublyLinkedList();
        obj.append(1);
        obj.append(2);
        obj.append(3);
        obj.prepend(0);
        obj.insert(10, 3);
        // obj.removeFront();
        // obj.removeLast();
        obj.printList();
    }
}
