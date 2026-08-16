class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode headToReturn = head;
        ListNode currHead = head;
        ListNode prevGroupTail = null;

        while (true) {
            int i = k - 1;
            ListNode kthNode = currHead;

            while (kthNode != null && i > 0) {
                i--;
                kthNode = kthNode.next;
            }

            if (kthNode == null) {
                break;
            }

            ListNode nextGroup = kthNode.next;
            kthNode.next = null;

            ListNode reversedHead = reverseGroup(currHead);

            if (prevGroupTail != null) {
                prevGroupTail.next = reversedHead;
            } else {
                headToReturn = reversedHead;
            }

            prevGroupTail = currHead;
            currHead.next = nextGroup;
            currHead = nextGroup;
        }

        return headToReturn;
    }

    public ListNode reverseGroup(ListNode currHead) {
        ListNode prev = null;
        ListNode curr = currHead;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
