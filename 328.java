/*
keep two pointers moving ahead, once odd reaches end point odd.next -> evens head
*/
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode lsOddHead = head;
        if(head.next == null) {
            return head;
        }
        ListNode lsEvenHead = head.next;
        ListNode oddIterator = lsOddHead;
        ListNode evenIterator = lsEvenHead;

        while(oddIterator.next != null && oddIterator.next.next != null) {
            oddIterator.next = oddIterator.next.next;
            evenIterator.next = oddIterator.next.next;
            oddIterator = oddIterator.next;
            evenIterator = evenIterator.next;
        }

        oddIterator.next = lsEvenHead;

        return lsOddHead;
    }
}
