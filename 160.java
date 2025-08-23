class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        Set<ListNode> listA = new HashSet<>();
        while(tempA != null) {
            listA.add(tempA);
            
            tempA = tempA.next;
        }
        
        while(tempB != null) {
            if(listA.contains(tempB) ) return tempB;

            tempB = tempB.next;
        }

        return null;
    }
}
