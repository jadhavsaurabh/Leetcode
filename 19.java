class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0, head);
        ListNode fast = temp;
        ListNode slow = temp;
    
        while(n > 0) {
            fast = fast.next;
            n--;
        }

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        if(slow != null && slow.next != null) {
            slow.next = slow.next.next;
        }
        return temp.next;
    }
}
