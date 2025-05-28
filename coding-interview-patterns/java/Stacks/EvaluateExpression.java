import java.util.Stack;

public class EvaluateExpression {
    public int evaluateExpression(String s) {
        Stack<Integer> stack = new Stack<>();  
        int currNum = 0;
        int sign = 1;
        int res = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }
            // If the current character is an operator, add 'currNum' to 
            // the result after multiplying it by its sign.
            else if (c == '+' || c == '-') {
                res += currNum * sign;
                // Update the sign and reset 'curr_num'.
                sign = c == '-' ? -1 : 1;
                currNum = 0;
            }
            // If the current character is an opening parenthesis, a new 
            // nested expression is starting.
            else if (c == '(') {
                // Save the current 'res' and 'sign' values by pushing them 
                // onto the stack, then reset their values to start 
                // calculating the new nested expression.
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }
            // If the current character is a closing parenthesis, a nested 
            // expression has ended.
            else if (c == ')') {
                // Finalize the result of the current nested expression.
                res += sign * currNum;
                // Apply the sign of the current nested  expression's result 
                // before adding this result to the result of the outer 
                // expression.
                res *= stack.pop();
                res += stack.pop();
                currNum = 0;
            }
        }
        // Finalize the result of the overall expression.
        return res + currNum * sign;
    }
}
