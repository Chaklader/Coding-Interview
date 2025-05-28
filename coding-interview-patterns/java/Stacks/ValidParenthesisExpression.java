import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesisExpression {
    public boolean validParenthesisExpression(String s) {
        Map<Character, Character> parenthesesMap = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        parenthesesMap.put('(', ')');
        parenthesesMap.put('{', '}');
        parenthesesMap.put('[', ']');
        for (char c : s.toCharArray()) {
            // If the current character is an opening parenthesis, push it 
            // onto the stack.
            if (parenthesesMap.containsKey(c)) {
                stack.push(c);
            }
            // If the current character is a closing parenthesis, check if 
            // it closes the opening parenthesis at the top of the stack.
            else {
                if (!stack.isEmpty() && parenthesesMap.get(stack.peek()) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        // If the stack is empty, all opening parentheses were successfully 
        // closed.
        return stack.isEmpty();
    }
}
