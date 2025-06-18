class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);

        if(head == null || head.next == null) return head;
        ListNode curr = head;
        ListNode next = head.next;
        ListNode prev = dummy;
        dummy.next = head;

        while(next != null) {
            if(curr.val != next.val) {
                prev = curr;
                curr = next;
                next = next.next;
            } else {
                int val = next.val;
                while(next != null && next.val == val) {
                    next = next.next;
                }
                prev.next = next;
                curr = next;
                if(next != null) next = next.next;
            }
        }
        return dummy.next;
    }
}
