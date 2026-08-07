class Solution {

    private Node prev = null;
    private Node head = null;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;

        inorder(root);

        head.left = prev;
        prev.right = head;

        return head;
    }

    private void inorder(Node node) {
        if (node == null)
            return;

        inorder(node.left);

        if (prev == null) {
            head = node;
        } else {
            prev.right = node;
            node.left = prev;
        }

        prev = node;

        inorder(node.right);
    }
}
