public class Solution
{
    public int[] NextLargestNumberToTheRight(int[] nums)
    {
        int[] res = new int[nums.Length];
        Stack<int> stack = new Stack<int>();

        // Find the next largest number of each element, starting with the 
        // rightmost element.
        for (int i = nums.Length - 1; i >= 0; i--)
        {
            // Pop values from the top of the stack until the current 
            // value's next largest number is at the top.
            while (stack.Count > 0 && stack.Peek() <= nums[i])
                stack.Pop();

            // Record the current value's next largest number, which is at 
            // the top of the stack. If the stack is empty, record -1.
            res[i] = stack.Count > 0 ? stack.Peek() : -1;

            stack.Push(nums[i]);
        }

        return res;
    }
}
