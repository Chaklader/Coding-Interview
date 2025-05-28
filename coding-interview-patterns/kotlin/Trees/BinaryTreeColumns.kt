import java.util.LinkedList
import ds.TreeNode

/*
    Definition of TreeNode:

    data class TreeNode(
        var value: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )
*/

fun binaryTreeColumns(root: TreeNode?): List<List<Int>> {
    if (root == null) {
        return emptyList()
    }
    val columnMap = hashMapOf<Int, MutableList<Int>>()
    var leftmostColumn = 0
    var rightmostColumn = 0
    val queue = LinkedList<Pair<TreeNode?, Int>>()
    queue.add(root to 0)

    while (queue.isNotEmpty()) {
        val (node, column) = queue.removeFirst()
        if (node != null) {
            // Add the current node's value to its corresponding list in the hash
            // map.
            columnMap.computeIfAbsent(column) { mutableListOf() }.add(node.value)
            leftmostColumn = minOf(leftmostColumn, column)
            rightmostColumn = maxOf(rightmostColumn, column)
            // Add the current node's children to the queue with their respective
            // column ids.
            queue.add(node.left to column - 1)
            queue.add(node.right to column + 1)
        }
    }
    
    // Construct the output list by collecting values from each column in the hash
    // map in the correct order.
    return (leftmostColumn..rightmostColumn).map { columnMap[it] ?: emptyList() }
}
