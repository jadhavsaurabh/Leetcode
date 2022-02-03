/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */

var removeNthFromEnd = function(head, n) {
    const temp = new ListNode(0);
    temp.next = head;
    let r = temp;
    let l = temp;
    n=n+1;
    while (n--) {
        r = r.next;
    }
    while (r !== null) {
        r = r.next;
        l = l.next;
    }
    l.next = l.next.next; // assign null or whatever next element!
    return temp.next;
};
