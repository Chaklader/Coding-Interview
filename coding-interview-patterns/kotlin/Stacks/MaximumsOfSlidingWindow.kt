fun maximumsOfSlidingWindow(nums: List<Int>, k: Int): List<Int> {
    val res = mutableListOf<Int>()
    val dq = ArrayDeque<Pair<Int, Int>>()
    var left = 0
    var right = 0
    while (right < nums.size) {
        // 1) Ensure the values of the deque maintain a monotonic decreasing order
        // by removing candidates <= the current candidate.
        while (dq.isNotEmpty() && dq.last().first <= nums[right]) {
            dq.removeLast()
        }
        // 2) Add the current candidate.
        dq.add(Pair(nums[right], right))
        // If the window is of length 'k', record the maximum of the window.
        if (right - left + 1 == k) {
            // 3) Remove values whose indexes occur outside the window.
            while (dq.isNotEmpty() && dq.first().second < left) {
                dq.removeFirst()
            }
            // The maximum value of this window is the leftmost value in the
            // deque.
            res.add(dq.first().first)
            // Slide the window by advancing both 'left' and 'right'. The right
            // pointer always gets advanced so we just need to advance 'left'.
            left++
        }
        right++
    }
    return res
}
