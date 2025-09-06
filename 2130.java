class Solution {
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        Stack<Integer> stack = new Stack<>();
        while(fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        
        int max = 0;
        while(slow != null) {
            max = Math.max(max, slow.val + stack.pop());
            slow = slow.next;
        }
        
        return max;
    }
}
