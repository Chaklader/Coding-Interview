import java.util.PriorityQueue

class MedianOfAnIntegerStream {
    private val leftHalf = PriorityQueue<Int>(reverseOrder()) // Max-heap
    private val rightHalf = PriorityQueue<Int>() // Min-heap

    fun add(num: Int) {
        // If 'num' is less than or equal to the max of 'left_half', it
        // belongs to the left half.
        if (leftHalf.isEmpty() || num <= leftHalf.peek()) {
            leftHalf.add(num)
            // Rebalance the heaps if the size of the 'left_half'
            // exceeds the size of the 'right_half' by more than one.
            if (leftHalf.size > rightHalf.size + 1) {
                rightHalf.add(leftHalf.poll())
            }
            // Otherwise, it belongs to the right half.
        } else {
            rightHalf.add(num)
            // Rebalance the heaps if 'right_half' is larger than
            // 'left_half'.
            if (leftHalf.size < rightHalf.size) {
                leftHalf.add(rightHalf.poll())
            }
        }
    }

    fun getMedian(): Double {
        if (leftHalf.size == rightHalf.size) {
            return (leftHalf.peek().toDouble() + rightHalf.peek().toDouble()) / 2.0
        }
        return leftHalf.peek().toDouble()
    }
}
