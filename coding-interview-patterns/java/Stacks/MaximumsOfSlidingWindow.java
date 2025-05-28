import java.util.Stack;

public class MaximumsOfSlidingWindow {
    public int[] maximumsOfSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Stack<int[]> dq = new Stack<>();
        int left, right;
        left = right = 0;
        while (right < nums.length) {
            // 1) Ensure the values of the deque maintain a monotonic decreasing order
            // by removing candidates <= the current candidate.
            while (!dq.isEmpty() && dq.peek()[0] <= nums[right]) {
                dq.pop();
            }
            // 2) Add the current candidate.
            dq.push(new int[]{nums[right], right});
            // If the window is of length 'k', record the maximum of the window.
            if (right - left + 1 == k) {
                // 3) Remove values whose indexes occur outside the window.
                if (!dq.isEmpty() && dq.firstElement()[1] < left) {
                    dq.remove(0);
                }
                // The maximum value of this window is the leftmost value in the 
                // deque.
                res[left] = dq.firstElement()[0];
                // Slide the window by advancing both 'left' and 'right'. The right  
                // pointer always gets advanced so we just need to advance 'left'.
                left++;
            }
            right++;
        }
        return res;
    }
}
