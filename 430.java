class Solution {
    public Node findTail(Node node) {
        while(node.next != null) {
            node = node.next;
        }
        
        return node;
    }    

    public Node flatten(Node head) {
        Node curr = head;

        while(curr != null) {
            if(curr.child != null) {
                Node tail = findTail(curr.child);

                Node temp = curr.next;
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                
                if(temp != null) {
                    temp.prev = tail;
                    tail.next = temp;
                }
            }
            
            curr = curr.next;
        }

        return head;
    }
}
