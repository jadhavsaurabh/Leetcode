0/5
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    var max: Int = 0
    fun getMaxDepth(depthSoFar: Int, node: TreeNode?) {
        if(depthSoFar > max) {
            max = depthSoFar
        }
        if(node == null) {
            return 
        }
        getMaxDepth(depthSoFar + 1, node.left)
        getMaxDepth(depthSoFar + 1, node.right)
    }

    fun maxDepth(root: TreeNode?): Int {
        max = 0
        getMaxDepth(0, root)

        return max
    }
}
