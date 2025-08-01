class Solution {
    public int convertToNum(ArrayList<Integer> integers) {
        int num = 0;
        for(int i = 0; i<integers.size();i++) {
            num += (int) (integers.get(i) * Math.pow(10, integers.size() - i - 1));
        }
        return num;
    }

    public void preOrder(TreeNode node, ArrayList<Integer> num, int[] sum) {
        if(node.left == null && node.right == null) {
            num.add(node.val);
            sum[0] += convertToNum(num);
            num.removeLast();
        }
        num.add(node.val);
        if(node.left != null) preOrder(node.left, num, sum);
        if(node.right != null) preOrder(node.right, num, sum);
        num.removeLast();
    }
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        ArrayList<Integer> num = new ArrayList<>();
        preOrder(root, num, sum);

        return sum[0];
    }
}
