import java.util.*;

public class ArrayListStack<T> {
    ArrayList<T> Stack = new ArrayList<>();

    public void push(T value) {
        Stack.add(value);
        System.out.println("The value " + value + " is successfully pushed");
    }

    public T pop() {
        T result;
        result = Stack.get(Stack.size() - 1);
        Stack.remove(Stack.size() - 1);
        return result;
    }

    public void printStack() {
        System.out.println("The Stack has elements: ");
        for (int i = Stack.size() - 1; i >= 0; i--) {
            System.out.println(Stack.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayListStack<Integer> obj = new ArrayListStack<>();
        int k = 1;
        while (k > 0) {
            System.out.println("Enter value to use Stack: ");
            System.out.println("Enter 1 to push");
            System.out.println("Enter 2 to pop");
            System.out.println("Enter 3 to print");
            System.out.println("Enter 0 to quit");
            int i = sc.nextInt();
            switch (i) {
                case 1:
                    System.out.println("Enter value to push: ");
                    int val = sc.nextInt();
                    obj.push(val);
                    break;
                case 2:
                    int val2 = obj.pop();
                    System.out.println("The " + val2 + " is poped");
                    break;
                case 3:
                    obj.printStack();
                case 0:
                    k = 0;
                    break;
            }
        }
        sc.close();
    }
}