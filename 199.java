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



/* Alternate with one queue, instead of declaring another queue just take size of queue and iterate till the size*/
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i=0;i<sz;i++) {
                TreeNode node = q.poll();
                if(node != null) {
                    if(i==(sz-1)) {
                        res.add(node.val);
                    }
                    if(node.left != null) q.add(node.left);
                    if(node.right != null) q.add(node.right);
                }
            }
        }
        return res;
    }
}
