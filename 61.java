class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;

        int sz = 0;
        ListNode c = head;
        while (c != null) {
            sz++;
            c = c.next;
        }
        if(sz == 0) return head;
        k = k % sz;
        if(k==0) return head;
        while(k > 0) {
            k--;
            right = right.next;
        }
        while(right != null && right.next!= null) {
            left = left.next;
            right = right.next;
        }

        ListNode temp = head;
        head = left.next;
        right.next = temp;
        left.next = null;

        return head;
    }
}
