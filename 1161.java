/*
Add root in queue,

for all added element in queue calculate sum, while calculating keep on adding childs.
So that the childs will become the next level
maintain max sum & level record
*/
class Solution {
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);
        int max = root.val;
        int level = 1;
        int result = level;
        while(!queue.isEmpty()) {
            int sum = 0;
            
            for(int i=queue.size();i > 0;i--) {
                var node = queue.poll();
                sum += node.val;
                
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            
            if(sum > max) {
                max = sum;
                result = level;
            }
            level++;
        }
        return result;
    }
}
