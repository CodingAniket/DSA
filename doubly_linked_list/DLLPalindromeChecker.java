public class DLLPalindromeChecker {
    class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Node head;
    public Node tail; // Kept track of during append for convenience

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    // ---------------------------------------------------------
    // TODO: IMPLEMENT YOUR PALINDROME LOGIC HERE
    // ---------------------------------------------------------
    public boolean isPalindrome() {
        if (head == null || head.next == null) return true;
        else{
            Node front=head;
            Node back=tail;
            while(front!=back && front.prev!=back){
                if(front.data!=back.data) return false;
                else{
                    front=front.next;
                    back=back.prev;
                }
            }
        }

        return true; 
    }
    // ---------------------------------------------------------

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DLLPalindromeChecker list1 = new DLLPalindromeChecker();
        // 1 <-> 2 <-> 3 <-> 2 <-> 1 (Odd Palindrome)
        list1.append(1);
        list1.append(2);
        list1.append(3);
        list1.append(2);
        list1.append(1);

        System.out.print("List 1: ");
        list1.printList();
        System.out.println("Is Palindrome? " + list1.isPalindrome()); // Expected: true

        DLLPalindromeChecker list2 = new DLLPalindromeChecker();
        // 1 <-> 2 <-> 3 <-> 4 (Not a Palindrome)
        list2.append(1);
        list2.append(2);
        list2.append(3);
        list2.append(4);

        System.out.print("List 2: ");
        list2.printList();
        System.out.println("Is Palindrome? " + list2.isPalindrome()); // Expected: false
    }
}