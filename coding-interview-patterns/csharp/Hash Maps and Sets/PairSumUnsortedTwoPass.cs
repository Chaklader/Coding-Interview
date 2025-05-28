public class Solution
{
    public int[] PairSumUnsortedTwoPass(int[] nums, int target)
    {
        Dictionary<int, int> numMap = new Dictionary<int, int>();
        // First pass: Populate the hash map with each number and its 
        // index
        for (int i = 0; i < nums.Length; i++) 
        {
            numMap[nums[i]] = i;
        }
        // Second pass: Check for each number's complement in the hash map.
        for (int i = 0; i < nums.Length; i++)
        {
            int complement = target - nums[i];
            if (numMap.ContainsKey(complement) && numMap[complement] != i)
            {
                return [i, numMap[complement]];
            }
        }

        return [];
    }
}