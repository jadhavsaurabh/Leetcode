/*
Create a child -> parent Map using bfs
now run dfs with initial distance 0 on parent, left & right
*/
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public void dfs(TreeNode target, int distance, int k, HashSet<Integer> visited, HashMap<TreeNode, TreeNode> parentMap, List<Integer> res) {
        if(target == null || visited.contains(target.val) || distance > k) return;
        
        if(distance == k) {
            res.add(target.val);
            return;
        }

        visited.add(target.val);
        dfs(target.left, distance + 1, k, visited, parentMap, res);
        dfs(target.right, distance + 1, k, visited, parentMap, res);
        if(parentMap.containsKey(target)) {
            dfs(parentMap.get(target), distance + 1, k, visited, parentMap, res);
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();

        q.add(root);
        while(!q.isEmpty()) {
            TreeNode parent = q.poll();

            if(parent.left != null) {
                parentMap.put(parent.left, parent);
                q.add(parent.left);
            }
            if(parent.right != null) {
                parentMap.put(parent.right, parent);
                q.add(parent.right);
            }
        }

        HashSet<Integer> vis = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        dfs(target, 0, k, vis, parentMap, res);

        return res;
    }
}
