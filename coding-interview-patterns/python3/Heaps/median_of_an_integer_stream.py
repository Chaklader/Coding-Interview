import heapq


class MedianOfAnIntegerStream:
    def __init__(self):
        self.left_half = []  # Max-heap.
        self.right_half = []  # Min-heap.

    def add(self, num: int) -> None:
        # If 'num' is less than or equal to the max of 'left_half', it 
        # belongs to the left half.
        if not self.left_half or num <= -self.left_half[0]:
            heapq.heappush(self.left_half, -num)
            # Rebalance the heaps if the size of the 'left_half' 
            # exceeds the size of the 'right_half' by more than one.
            if len(self.left_half) > len(self.right_half) + 1:
                heapq.heappush(self.right_half, -heapq.heappop(self.left_half))
        # Otherwise, it belongs to the right half.
        else:
            heapq.heappush(self.right_half, num)
            # Rebalance the heaps if 'right_half' is larger than 
            # 'left_half'.
            if len(self.left_half) < len(self.right_half):
                heapq.heappush(self.left_half, -heapq.heappop(self.right_half))

    def get_median(self) -> float:
        if len(self.left_half) == len(self.right_half):
            return (-self.left_half[0] + self.right_half[0]) / 2.0
        return -self.left_half[0]
