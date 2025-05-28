public class Solution
{
	public int[] MaximumsOfSlidingWindow(int[] nums, int k)
	{
		List<int> result = new List<int>();
		LinkedList<(int num, int indx)> dq = new LinkedList<(int num, int indx)>();

		int left = 0, right = 0;

		while (right < nums.Length)
		{
			// 1) Ensure the values of the deque maintain a monotonic decreasing order
			// by removing candidates <= the current candidate.
			while (dq.Count > 0 && dq.Last().num <= nums[right])
				dq.RemoveLast();

			// 2) Add the current candidate.
			dq.AddLast((nums[right], right));

			// If the window is of length 'k', record the maximum of the window
			if (right - left + 1 == k)
			{
				// 3)  Remove values whose indexes occur outside the window
				if (dq.Count > 0 && dq.First().indx < left)
					dq.RemoveFirst();

				// The maximum value of this window is the leftmost value in the dq.
				result.Add(dq.First().num);

				// Slide the window by advancing both 'left' and 'right'. The right  
				// pointer always gets advanced so we just need to advance 'left'.
				left++;
			}

			right++;
		}

		return [.. result];
	}
}
