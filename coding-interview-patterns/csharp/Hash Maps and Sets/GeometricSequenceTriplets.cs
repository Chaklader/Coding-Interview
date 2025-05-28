public class Solution
{
    public int GeometricSequenceTriplets(int[] nums, int r)
    {
        // The default value of 0 is returned when accessing a key that 
        // doesn’t exist in the hash map. 
        Dictionary<int, int> leftMap = new Dictionary<int, int>();
        Dictionary<int, int> rightMap = new Dictionary<int, int>();
        int count = 0;
        // Populate 'right_map' with the frequency of each element in the array.
        foreach (int x in nums) 
        {
            rightMap[x] = rightMap.GetValueOrDefault(x) + 1;
        }
        // Search for geometric triplets that have x as the center.
        foreach (int x in nums)
        {
            // Decrement the frequency of x in 'right_map' since x is now being
            // processed and is no longer to the right.
            rightMap[x] = rightMap.GetValueOrDefault(x) - 1;
            if (x % r == 0)
            {
                count += leftMap.GetValueOrDefault(x / r) * rightMap.GetValueOrDefault(x * r);
            }
            // Increment the frequency of x in 'left_map' since it'll be a part of the
            // left side of the array once we iterate to the next value of x.
            leftMap[x] = leftMap.GetValueOrDefault(x) + 1;
        }

        return count;
    }
}