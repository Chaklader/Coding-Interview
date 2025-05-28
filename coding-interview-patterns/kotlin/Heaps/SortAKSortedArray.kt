import java.util.PriorityQueue

fun sortAKSortedArray(nums: IntArray, k: Int): IntArray {
    val nums = IntArray(nums.size)
    // Populate a min-heap with the first k + 1 values in 'nums'.
    val minHeap = PriorityQueue<Int>()
    for (i in 0 until k + 1) {
        minHeap.add(nums[i])
    }
    // Replace elements in the array with the minimum from the heap at each
    // iteration.
    var index = 0
    for (i in k + 1 until nums.size) {
        nums[index++] = minHeap.poll()
        minHeap.add(nums[i])
    }
    // Pop the remaining elements from the heap to finish sorting the array.
    while (minHeap.isNotEmpty()) {
        nums[index++] = minHeap.poll()
    }
    return nums
}
