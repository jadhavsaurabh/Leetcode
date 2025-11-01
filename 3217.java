class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> st = new HashSet<>();
        for(int num: nums) {
            st.add(num);
        }

        ListNode prev = new ListNode();
        ListNode newHead = prev;
        prev.next = head;
        ListNode temp  = head;
        while(temp != null) {
            if(st.contains(temp.val)) {
                prev.next = temp.next;
            } else {
                prev = prev.next;
            }
            temp = temp.next;
        }

        return newHead.next;
    }
}
