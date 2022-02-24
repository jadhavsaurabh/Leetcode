/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var sortList = function(head) {
    let arr = []
    let temp = head;
    while(temp != null) {
        arr.push(temp.val);
        temp = temp.next;
    }
    if(arr.length === 0) {
        return null;
    }
    arr.sort((a,b) => a-b)
    let prev = new ListNode(arr[0]);
    let newhead = prev;
    for(let i=1;i<arr.length;i++) {
        let newNode = new ListNode(arr[i]);
        prev.next = newNode;
        prev = newNode;
    }
    return newhead;
}; 
