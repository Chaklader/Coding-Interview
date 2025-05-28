public class Solution
{
    public int LongestChainOfConsecutiveNumbersBruteForce(int[] nums)
    {
        if (nums == null || nums.Length == 0)
        {
            return 0;
        }
        int longestChain = 0;
        // Look for chains of consecutive numbers that start from each number.
        foreach (int num in nums)
        {
            int currentNum = num;
            int currentChain = 1;
            // Continue to find the next consecutive numbers in the chain.
            while (nums.Contains(currentNum + 1))
            {
                currentNum++;
                currentChain++;
            }
            longestChain = Math.Max(longestChain, currentChain);
        }

        return longestChain;
    }
}