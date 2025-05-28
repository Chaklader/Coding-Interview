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

fun invertBinaryTreeIterative(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val stack = Stack<TreeNode>()
    stack.push(root)
    while (stack.isNotEmpty()) {
        val node = stack.pop()
        // Swap the left and right subtrees of the current node.
        val temp = node.left
        node.left = node.right
        node.right = temp
        // Push the left and right subtrees onto the stack.
        if (node.left != null) {
            stack.push(node.left)
        }
        if (node.right != null) {
            stack.push(node.right)
        }
    }
    return root
}
