public class Solution
{
    public int EvaluateExpression(string s)
    {
        Stack<int> stack = new Stack<int>();
        int currNum = 0, sign = 1, res = 0;

        foreach (char ch in s)
        {
            if (char.IsDigit(ch))
                currNum = currNum * 10 + (ch - '0');

            // If the current character is an operator, add 'currNum' to 
            // the result after multiplying it by its sign.
            else if (ch == '+' || ch == '-')
            {
                res += currNum * sign;

                // Update the sign and reset 'currNum'.
                sign = (ch == '-') ? -1 : 1;
                currNum = 0;
            }

            // If the current character is an opening parenthesis, a new 
            // nested expression is starting. 
            else if (ch == '(')
            {
                // Save the current 'res' and 'sign' values by pushing them 
                // onto the stack, then reset their values to start 
                // calculating the new nested expression.
                stack.Push(res);
                stack.Push(sign);
                res = 0;
                sign = 1;
            }

            // If the current character is a closing parenthesis, a nested 
            // expression has ended.
            else if (ch == ')')
            {
                // Finalize the result of the current nested expression.
                res += sign * currNum;

                // Apply the sign of the current nested  expression's result 
                // before adding this result to the result of the outer 
                // expression.
                res *= stack.Pop();
                res += stack.Pop();
                currNum = 0;
            }
        }

        // Finalize the result of the overall expression.
        return res + currNum * sign;
    }
}
