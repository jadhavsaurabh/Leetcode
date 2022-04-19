/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public void getLen(TreeNode root, int[] len) {
        if(root!=null) {
            getLen(root.left, len);
            len[0]++;
            getLen(root.right, len);
        }
    }

    public void addInArray(TreeNode root, int[] index, int[] array) {
        if(root!=null) {
            addInArray(root.left, index, array);
            array[index[0]++] = root.val;
            addInArray(root.right, index, array);
        }
    }

    public void replaceValues(TreeNode root, int[] index, int[] array) {
        if(root!=null) {
            replaceValues(root.left, index, array);
            root.val = array[index[0]++];
            replaceValues(root.right, index, array);
        }
    }

    public void recoverTree(TreeNode root) {
        int[] len = {0};
        int[] index = {0};
        getLen(root, len);
        //System.out.println(len[0]);
        int[] array = new int[len[0]];
        addInArray(root, index, array);
        //System.out.println(array[0]);
        Arrays.sort(array);
        index[0] = 0;
        replaceValues(root, index, array);
    }
}
