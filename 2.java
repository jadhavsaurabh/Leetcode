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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode head = res;
        boolean carry = false;
        while(l1 != null || l2 != null) {
            if(l1 == null) {
                while(l2 != null) {
                    int sum  = l2.val + (carry ? 1 : 0);
                    if(sum >= 10) {
                        carry = true;
                        sum = sum %10;
                    } else {
                        carry = false;
                    }
                    ListNode node = new ListNode(sum);
                    res.next = node;
                    res = res.next;
                    l2 = l2.next;
                }
                break;
            } else if(l2 == null) {
                while(l1 != null) {
                    int sum  = l1.val + (carry ? 1 : 0);
                    if(sum >= 10) {
                        carry = true;
                        sum = sum %10;
                    } else {
                        carry = false;
                    }
                    ListNode node = new ListNode(sum);
                    res.next = node;
                    res = res.next;
                    l1 = l1.next;
                }
                break;
            } else {
                int sum  = l1.val + l2.val + (carry ? 1 : 0);
                if(sum >= 10) {
                    carry = true;
                    sum = sum %10;
                } else {
                    carry = false;
                }
                ListNode node = new ListNode(sum);
                res.next = node;
                res = res.next;
                l1 = l1.next;
                l2 = l2.next;
            }
        }
        
        if(carry) {
            ListNode node = new ListNode(1);
            res.next = node;
        }
        return head.next;
    }
}
