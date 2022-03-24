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
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> liststack = new Stack<>();
        ListNode temp = head;
        while(temp != null) {
            liststack.push(temp);
            temp = temp.next;
        }
        
        ListNode prev = new ListNode();
        ListNode temp2 = prev;
        while(!liststack.isEmpty()) {
            prev.next = liststack.pop();
            prev = prev.next;
        }
        prev.next = null;
        return temp2.next;
    }
}
