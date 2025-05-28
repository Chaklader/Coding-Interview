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

fun widestBinaryTreeLevel(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    var maxWidth = 0
    val queue = LinkedList<Pair<TreeNode, Int>>() // Stores (node, index) pairs.
    queue.add(Pair(root, 0))
    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        // Set the 'leftmostIndex' to the index of the first node in
        // this level. Start 'rightmostIndex' at the same point as
        // 'leftmostIndex' and update it as we traverse the level,
        // eventually positioning it at the last node.
        var leftmostIndex = queue.first().second
        var rightmostIndex = leftmostIndex
        // Process all nodes at the current level.
        repeat(levelSize) {
            val (node, i) = queue.poll()
            if (node.left != null) {
                queue.add(Pair(node.left!!, 2 * i + 1))
            }
            if (node.right != null) {
                queue.add(Pair(node.right!!, 2 * i + 2))
            }
            rightmostIndex = i
        }
        maxWidth = maxOf(maxWidth, rightmostIndex - leftmostIndex + 1)
    }
    return maxWidth
}
