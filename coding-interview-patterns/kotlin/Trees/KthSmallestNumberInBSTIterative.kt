import java.util.Stack
import ds.TreeNode

/*
    Definition of TreeNode:

    data class TreeNode(
        var value: Int,
        var left: TreeNode? = null,
        var right: TreeNode? = null
    )
*/

fun kthSmallestNumberInBSTIterative(root: TreeNode?, k: Int): Int {
    val stack = Stack<TreeNode>()
    var node = root
    // Copy 'k' to a mutable variable so we can decrement it.
    var k = k
    while (stack.isNotEmpty() || node != null) {
        // Move to the leftmost node and add nodes to the stack as we go so they
        // can be processed in future iterations.
        while (node != null) {
            stack.push(node)
            node = node.left
        }
        // Pop the top node from the stack to process it, and decrement 'k'.
        node = stack.pop()
        k--
        // If we have processed 'k' nodes, return the value of the 'k'th smallest
        // node.
        if (k == 0) {
            return node.value
        }
        // Move to the right subtree.
        node = node.right
    }
    return -1
}
