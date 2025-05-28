public class Solution
{
    public int[] PairSumUnsorted(int[] nums, int target)
    {
        Dictionary<int, int> hashmap = new Dictionary<int, int>();
        for (int i = 0; i < nums.Length; i++) 
        {
            if (hashmap.ContainsKey(target - nums[i]))
            {
                return [hashmap[target - nums[i]], i];
            }

            hashmap[nums[i]] = i;
        }

        return [];
    }
}