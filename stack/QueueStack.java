import java.util.Stack;

class QueueUsingStacks {
    // Two stacks to manage the FIFO behavior
    private Stack<Integer> inputStack;
    private Stack<Integer> outputStack;

    // Constructor to initialize the stacks
    public QueueUsingStacks() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    // 1. ADD operation (Enqueue)
    public void enqueue(int x) {
        if (inputStack.isEmpty()) {
            inputStack.push(x);
        } else {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
            inputStack.push(x);
            while (!outputStack.isEmpty()) {
                inputStack.push(outputStack.pop());
            }
        }
    }

    // 2. REMOVE operation (Dequeue)
    public int dequeue() {
        if (inputStack.isEmpty())
            return -1;
        return inputStack.pop();
    }

    // 3. LOOK operation (Peek at the front element)
    public int peek() {
        if (inputStack.isEmpty())
            return -1;
        return inputStack.peek();
    }

    // 4. Check if queue is empty
    public boolean isEmpty() {
        if (inputStack.size() == 0)
            return true;
        return false;
    }
}

public class QueueStack {
    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();

        System.out.println("--- Testing Queue Using Stacks ---");

        // Test 1: Enqueue elements
        System.out.println("Adding elements: 10, 20, 30");
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        // Test 2: Peek front element
        System.out.println("Expected Front: 10");
        System.out.println("Actual Front: " + q.peek());
        System.out.println();

        // Test 3: Dequeue elements
        System.out.println("Expected Dequeue: 10");
        System.out.println("Actual Dequeue: " + q.dequeue());

        System.out.println("Expected Dequeue: 20");
        System.out.println("Actual Dequeue: " + q.dequeue());
        System.out.println();

        // Test 4: Enqueue more after dequeue
        System.out.println("Adding element: 40");
        q.enqueue(40);

        // Test 5: Dequeue remaining
        System.out.println("Expected Dequeue: 30");
        System.out.println("Actual Dequeue: " + q.dequeue());

        System.out.println("Expected Dequeue: 40");
        System.out.println("Actual Dequeue: " + q.dequeue());
        System.out.println();

        // Test 6: Check if empty
        System.out.println("Expected IsEmpty: true");
        System.out.println("Actual IsEmpty: " + q.isEmpty());
    }
}
