public class Solution
{
    public bool ValidParenthesisExpression(string s)
    {
        Dictionary<char, char> parenthesesMap = new Dictionary<char, char>
        {
            ['('] = ')',
            ['{'] = '}',
            ['['] = ']'
        };

        Stack<char> stack = new Stack<char>();

        foreach (char ch in s)
        {
            // If the current character is an opening parenthesis, push it 
            // onto the stack.
            if (parenthesesMap.ContainsKey(ch))
                stack.Push(ch);

            // If the current character is a closing parenthesis, check if 
            // it closes the opening parenthesis at the top of the stack.
            else
            {
                if (stack.Count > 0 && parenthesesMap[stack.Peek()] == ch)
                    stack.Pop();
                else
                    return false;
            }
        }

        // If the stack is empty, all opening parentheses were successfully closed.
        return stack.Count == 0;
    }
}
