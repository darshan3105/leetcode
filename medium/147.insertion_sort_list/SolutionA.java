// https://leetcode.com/problems/insertion-sort-list/
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
    public ListNode insertionSortList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while(cur!=null) {
            ListNode ptr = head;
            ListNode innerPrev = null;
            while(ptr!=cur && ptr.val<cur.val) {
                innerPrev=ptr;
                ptr=ptr.next;
            }
            
            if(cur==ptr) {
                prev=cur;
                cur=cur.next;
            }
            else {
                ListNode next = cur.next;
                prev.next=next;
                if(innerPrev==null) {
                    head=cur;
                }
                else {
                    innerPrev.next=cur;
                }
                cur.next=ptr;
                cur=next; 
            }
            
        }
        return head;
    }
}