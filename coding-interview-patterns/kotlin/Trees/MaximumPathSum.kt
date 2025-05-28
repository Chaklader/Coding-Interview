import ds.TreeNode

/*
    Definition of TreeNode:

    data class TreeNode(
        var value: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )
*/

fun maxPathSum(root: TreeNode?): Int {
    // In Kotlin, global variable is bad practice.
    // So, we use a mutable list to store the max sum and access it by reference.
    var maxSum = mutableListOf(Int.MIN_VALUE)
    maxPathSumHelper(root, maxSum)
    return maxSum[0]
}

fun maxPathSumHelper(node: TreeNode?, maxSum: MutableList<Int>): Int {
    // Base case: null nodes have no path sum.
    if (node == null) {
        return 0
    }
    // Collect the maximum gain we can attain from the left and right
    // subtrees, setting them to 0 if they're negative.
    val leftSum = Math.max(maxPathSumHelper(node.left, maxSum), 0)
    val rightSum = Math.max(maxPathSumHelper(node.right, maxSum), 0)
    // Update the overall maximum path sum if the current path sum is
    // larger.
    maxSum[0] = Math.max(maxSum[0], node.value + leftSum + rightSum)
    // Return the maximum sum of a single, continuous path with the
    // current node as an endpoint.
    return node.value + Math.max(leftSum, rightSum)
}
