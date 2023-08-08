class Solution {
    static TreeNode buildTree(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd,HashMap<Integer,Integer> map){
        if(preStart>preEnd || inStart>inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int numLeft = inRoot-inStart;
        root.left = buildTree(preorder,preStart+1,preStart+numLeft,inorder,inStart,inRoot-1,map);
        root.right = buildTree(preorder,preStart+numLeft+1,preEnd,inorder,inRoot+1,inEnd,map);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        TreeNode root = buildTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
        return root;
    }
}
