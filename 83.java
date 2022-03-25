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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode prev = head;

        temp = temp.next;
        while(temp != null) {
            ListNode tempPrev = null;
            if(temp.val != prev.val) {
                prev = temp;
                temp = temp.next;
            } else {
                while(temp !=null && temp.val == prev.val) {
                    tempPrev = temp;
                    temp = temp.next;
                }
                prev.next = tempPrev.next;
            }
        }
        return head;
    }
}
