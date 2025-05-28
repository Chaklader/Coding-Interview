public class Solution
{
    public string RepeatedRemovalOfAdjacentDuplicates(string s)
    {
        Stack<char> stack = new Stack<char>();

        foreach (char ch in s)
        {
            // If the current character is the same as the top character on the stack,
            // a pair of adjacent duplicates has been formed. So, pop the top character 
            // from the stack.
            if (stack.Count > 0 && ch == stack.Peek())
                stack.Pop();

            // Otherwise, push the current character onto the stack.
            else
                stack.Push(ch);
        }

        // Return the remaining characters as a string.
        return string.Join("", stack);
    }
}
