import java.util.Stack;

public class RepeatedRemovalOfAdjacentDuplicates {
    public String repeatedRemovalOfAdjacentDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            // If the current character is the same as the top character on the stack,
            // a pair of adjacent duplicates has been formed. So, pop the top character 
            // from the stack.
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            }
            // Otherwise, push the current character onto the stack.
            else {
                stack.push(c);
            }
        }
        // Return the remaining characters as a string.
        for (char c : stack) {
            res.append(c);
        }
        return res.toString();
    }
}
