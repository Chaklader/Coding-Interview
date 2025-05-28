public class Solution
{
    public int CuttingWood(int[] heights, int k)
    {
        int left = 0, right = heights.Length;

        while (left < right)
        {
            // Bias the midpoint to the right during the upper-bound binary search.
            int mid = (left + right) / 2 + 1;

            if (cutsEnoughWood(mid, k, heights))
                left = mid;
            else
                right = mid - 1;
        }

        return right;
    }

    private bool cutsEnoughWood(int H, int k, int[] heights)
    {
        int woodsCollected = 0;

        foreach (int height in heights)
        {
            if (height > H)
                woodsCollected += (height - H);
        }

        return woodsCollected >= k;
    }
}
