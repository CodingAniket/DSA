import java.util.Stack; // Or your custom Stack import if it's in another file

public class StackSort {
    
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer>sortedStack=new Stack<>();
        while(!stack.isEmpty()){
         Integer temp=stack.pop();
         while(!sortedStack.isEmpty()&&sortedStack.peek()>temp){
           stack.push(sortedStack.pop());
         }
         sortedStack.push(temp);
        }
         while(!sortedStack.isEmpty()){
            stack.push(sortedStack.pop());
         }
    }

    public static void main(String[] args) {
        Stack<Integer> stack;

        System.out.println("These tests confirm sortStack sorts");
        System.out.println("the stack so the TOP is the LOWEST value.");
        System.out.println("printStack() shows the stack from top");
        System.out.println("to bottom (smallest to largest).");
        System.out.println();

        // Test 1: Empty stack
        System.out.println("Test 1: Empty Stack");
        stack = new Stack<>();
        sortStack(stack);
        System.out.println("Expected (top to bottom): empty");
        // Note: If using java.util.Stack, use System.out.println(stack); 
        // If using your custom Stack, use stack.printStack();
        System.out.println(stack.isEmpty() ? "empty" : stack); 
        System.out.println();

        // Test 2: Single element
        System.out.println("Test 2: Single Element");
        stack = new Stack<>();
        stack.push(5);
        sortStack(stack);
        System.out.println("Expected (top to bottom): 5");
        System.out.println(stack.isEmpty() ? "empty" : stack);
        System.out.println();

        // Test 3: Unsorted stack
        System.out.println("Test 3: Unsorted Stack");
        stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        sortStack(stack);
        System.out.println("Expected (top to bottom): 1, 2, 3, 4");
        System.out.println(stack.isEmpty() ? "empty" : stack);
        System.out.println();

        // Test 4: Already sorted
        System.out.println("Test 4: Already Sorted Stack");
        stack = new Stack<>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        sortStack(stack);
        System.out.println("Expected (top to bottom): 1, 2, 3, 4");
        System.out.println(stack.isEmpty() ? "empty" : stack);
        System.out.println();

        // Test 5: Reverse sorted
        System.out.println("Test 5: Reverse Sorted Stack");
        stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        sortStack(stack);
        System.out.println("Expected (top to bottom): 1, 2, 3, 4");
        System.out.println(stack.isEmpty() ? "empty" : stack);
        System.out.println();

        // Test 6: With duplicates
        System.out.println("Test 6: With Duplicates");
        stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        sortStack(stack);
        System.out.println("Expected (top to bottom): 1, 1, 2, 3, 3");
        System.out.println(stack.isEmpty() ? "empty" : stack);
        System.out.println();

        // Test 7: With negatives
        System.out.println("Test 7: With Negatives");
        stack = new Stack<>();
        stack.push(-1);
        stack.push(3);
        stack.push(-5);
        stack.push(2);
        sortStack(stack);
        System.out.println("Expected (top to bottom): -5, -1, 2, 3");
        System.out.println(stack.isEmpty() ? "empty" : stack);
        System.out.println();
    }
}