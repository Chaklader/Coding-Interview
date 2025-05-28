public class Solution
{
    public int LongestChainOfConsecutiveNumbers(int[] nums)
    {
        if (nums == null || nums.Length == 0)
        {
            return 0;
        }
        HashSet<int> numSet = new HashSet<int>(nums);
        int longestChain = 0;
        foreach (int num in numSet)
        {
            // If the current number is the smallest number in its chain, search for
            // the length of its chain.
            if (!numSet.Contains(num - 1))
            {
                int currentNum = num;
                int currentChain = 1;
                // Continue to find the next consecutive numbers in the chain.
                while (numSet.Contains(currentNum + 1))
                {
                    currentNum++;
                    currentChain++;
                }
                longestChain = Math.Max(longestChain, currentChain);
            }
        }

        return longestChain;
    }
}