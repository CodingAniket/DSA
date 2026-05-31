import java.util.*;

public class ParenthesisBalance {
    public static boolean BalanceMeasure(String input) {
        ArrayList<Character> stack = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.add(input.charAt(i));
            } else if (input.charAt(i) == ')') {
                if (stack.isEmpty())
                    return false;
                stack.remove(stack.size() - 1);
            }
        }
        if (stack.isEmpty())
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter perenthesis properly: ");
        String input = sc.nextLine();
        boolean Balance = BalanceMeasure(input);
        if (Balance) {
            System.out.println("perenthesis are balanced");
        } else {
            System.out.println("perenthesis are not balanced");
        }
        sc.close();
    }
}
