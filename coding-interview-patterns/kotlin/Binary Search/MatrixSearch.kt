fun matrixSearch(matrix: List<List<Int>>, target: Int): Boolean {
    val m = matrix.size
    val n = matrix[0].size
    var left = 0
    var right = m * n - 1
    // Perform binary search to find the target.
    while (left <= right) {
        val mid = left + (right - left) / 2
        val r = mid / n
        val c = mid % n
        if (matrix[r][c] == target) {
            return true
        } else if (matrix[r][c] > target) {
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return false
}
