class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);
        ListNode leftPtr = left;
        ListNode rightPtr = right;

        while(head != null) {
            ListNode newNode = new ListNode(head.val);
            if(head.val < x) {
                leftPtr.next = newNode;
                leftPtr = leftPtr.next;
            } else {
                rightPtr.next = newNode;
                rightPtr = rightPtr.next;
            }
            head = head.next;
        }
        
        leftPtr.next = right.next;
        return left.next;
    }
}
