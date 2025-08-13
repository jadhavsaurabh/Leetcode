class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;
        while(temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        temp = head;
        while(temp != null && temp.next != null) {
            ListNode popped = stack.pop();
            if(popped == temp || popped == temp.next) {
                popped.next = null;
                break;
            }
            popped.next = temp.next;
            temp.next = popped;
            
            temp = popped.next;
        }
    }
}
