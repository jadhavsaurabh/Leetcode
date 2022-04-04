/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = new ListNode();
        left.next = head;
        ListNode ender = head;
        while(k != 0) {
            left = left.next;
            ender = ender.next;
            k--;
        }
        ListNode right = head;
        while(ender != null) {
            ender = ender.next;
            right = right.next;
        }
        if(left.val != right.val) {
            int temp = right.val;
            right.val = left.val;
            left.val = temp;
        }
        return head;
    }
}
