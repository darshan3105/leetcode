// https://leetcode.com/problems/reverse-linked-list/
// TC: O(n)
// SC: O(1)

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
class SolutionA {
    public ListNode reverseList(ListNode head) {
        if(head==null) {
            return head;
        }
        
        ListNode prev=null, cur=head, next = cur.next;
        while(cur!=null) {
            cur.next = prev;
            prev=cur;
            cur=next;
            if(cur!=null) {
                next=cur.next;
            }
        }
        return prev;
    }
}