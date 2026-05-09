public class BinaryToDecimal {
    class Node {
        int data; // Will be 0 or 1
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
    public int convertToDecimal() {
        if (head == null) return 0;
        int result = 0;
        Node current=head;
        if(current.next==null) result=current.data;
        else{
            result=current.data;
            while(current!=null && current.next!=null){
             current=current.next;
             result=(result*2)+current.data;
            }
        }
        return result;
    }
    // ---------------------------------------------------------

    public static void main(String[] args) {
        BinaryToDecimal list = new BinaryToDecimal();
        
        // Binary: 1 -> 0 -> 1 -> 1 (which is 11 in decimal)
        list.append(1);
        list.append(0);
        list.append(1);
        list.append(1);

        System.out.println("The decimal value is: " + list.convertToDecimal());
    }
}
