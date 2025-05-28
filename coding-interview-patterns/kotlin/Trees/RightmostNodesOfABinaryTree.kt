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

fun rightmostNodesOfABinaryTree(root: TreeNode?): List<Int> {
    val res = mutableListOf<Int>()
    if (root == null) {
        return res
    }
    val queue = LinkedList<TreeNode>()
    queue.add(root)
    while (queue.isNotEmpty()) {
        val levelSize = queue.size
        // Add all the non-null child nodes of the current level to the
        // queue.
        repeat(levelSize) {
            val node = queue.poll()
            if (node.left != null) {
                queue.add(node.left!!)
            }
            if (node.right != null) {
                queue.add(node.right!!)
            }
            // Record this level's last node to the result array.
            if (it == levelSize - 1) {
                res.add(node.value)
            }
        }
    }
    return res
}
