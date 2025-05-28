public class WeightedRandomSelection
{
    private readonly int[] _prefixSums;
    private readonly Random _random;

    public WeightedRandomSelection(int[] weights)
    {
        _prefixSums = new int[weights.Length];
        _prefixSums[0] = weights[0];

        for (int i = 1; i < weights.Length; i++)
            _prefixSums[i] = _prefixSums[i - 1] + weights[i];

        _random = new Random();
    }

    public int Select()
    {
        // Pick a random target between 1 and the largest endpoint on the number line.
        int target = _random.Next(1, _prefixSums[^1]);
        int left = 0, right = _prefixSums.Length - 1;

        // Perform lower-bound binary search to find which endpoint (i.e., prefix 
        // sum value) corresponds to the target.
        while (left < right)
        {
            int mid = (left + right) / 2;

            if (_prefixSums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }
}
