
class Solution {
    public ListNode sortLists(ListNode l, ListNode r) {
        ListNode head;
        if(r == null) return l;
        if(l == null) return r;

        if(l.val < r.val) {
            head = l;
            l = l.next;
        } else {
            head = r;
            r = r.next;
        }

        ListNode curr = head;
        while(l != null && r != null) {
            if(l.val <= r.val) {
                curr.next = l;
                curr = curr.next;
                l = l.next;
            } else {
                curr.next = r;
                curr = curr.next;
                r = r.next;
            }
        }

        if(r != null) {
            curr.next = r;
        }
        if(l != null) {
            curr.next = l;
        }

        return head;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<ListNode> ll = new ArrayList<>(Arrays.asList(lists));

        while(ll.size() > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            for(int i=0;i<ll.size();) {
                if(i+1 < ll.size()) {
                    ListNode merged = sortLists(ll.get(i), ll.get(i+1));
                    mergedLists.add(merged);
                } else {
                    ListNode merged = ll.get(i);
                    mergedLists.add(merged);
                }
                i = i + 2;
            }
            ll = mergedLists;
        }
        
        return ll.get(0);
    }
}
