class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(ListNode list: lists) {
            ListNode temp = list;
            
            while(temp != null) {
                pq.add(temp.val);
                temp = temp.next;
            }
        }
        
        ListNode prev = new ListNode(0);
        ListNode res = prev;
        while(!pq.isEmpty()) {
            prev.next = new ListNode(pq.poll());
            prev = prev.next;
        }
        
        return res.next;
    }
}
