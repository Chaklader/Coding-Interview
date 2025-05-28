import java.util.PriorityQueue

fun kthLargestIntegerMinHeap(nums: List<Int>, k: Int): Int {
    val minHeap = PriorityQueue<Int>()
    for (num in nums) {
        // Ensure the heap has at least 'k' integers.
        if (minHeap.size < k) {
            minHeap.offer(num)
        // If 'num' is greater than the smallest integer in the heap, poll
        // off this smallest integer from the heap and offer 'num'.
        } else if (num > minHeap.peek()) {
            minHeap.poll()
            minHeap.offer(num)
        }
    }
    return minHeap.peek()
}
