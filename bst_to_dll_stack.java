class Solution {
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        Node head = null;
        Node prev = null;

        while (curr != null || !stack.isEmpty()) {

            // Go to the leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();

            // Build the doubly linked list
            if (prev == null) {
                head = curr;
            } else {
                prev.right = curr;
                curr.left = prev;
            }

            prev = curr;

            // Visit the right subtree
            curr = curr.right;
        }

        // Make it circular
        head.left = prev;
        prev.right = head;

        return head;
    }
}
