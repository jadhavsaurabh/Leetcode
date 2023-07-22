/*
Do level order traversal & add last element of every level in result.
maintain two queue for a level, swap the queues after level traversal is finished
*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        List<Integer> result = new ArrayList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            Queue<TreeNode> q2 = new LinkedList();
            Iterator it = q.iterator();
            TreeNode prev = null;
            while (it.hasNext()) {
                TreeNode node = q.poll();
                if(node == null) {
                    break;
                }
                if(node.left != null) {
                    q2.add(node.left);
                }
                if(node.right != null) {
                    q2.add(node.right);
                }
                prev = node;
            }
            if(prev != null) {
                result.add(prev.val);
            }
            
            if(q2.size() == 0) {
                break;
            }
            q.addAll(q2);
        }
        return result;
    }

}
