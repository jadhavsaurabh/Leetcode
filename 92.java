class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0, head);

        ListNode lp = dummy;
        ListNode curr = head;

        for(int i =0;i<left-1;i++) {
            lp = curr;
            curr = curr.next;
        }

        ListNode prev = null;
        for(int i=0;i<right-left + 1;i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        lp.next.next = curr;
        lp.next = prev;

        return dummy.next;
    }
}
