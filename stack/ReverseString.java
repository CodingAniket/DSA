import java.util.*;

public class ReverseString {
    ArrayList<Character> Stack = new ArrayList<>();

    public void push(String input) {
        for (int i = 0; i < input.length(); i++) {
            Stack.add(input.charAt(i));
        }
    }

    public void reverse() {
        String reversed = "";
        while (!Stack.isEmpty()) {
            reversed += Stack.remove(Stack.size() - 1);
        }
        System.out.println("The reversed string is: " + reversed);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReverseString obj = new ReverseString();
        System.out.println("Enter the String to reverse: ");
        String input = sc.nextLine();
        obj.push(input);
        obj.reverse();
        sc.close();
    }
}
