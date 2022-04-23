// https://leetcode.com/problems/reverse-linked-list-ii/
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
class Solution {
    public ListNode reverseBetween(ListNode head, int l, int r) {
        int len = lengthOf(head);
        ListNode left = getNodeAt(head, l);
        ListNode nextToRight = getNodeAt(head, r+1);
        ListNode prevToLeft = getNodeAt(head, l-1);
        
        int freq = r-l;
        ListNode prev = prevToLeft,cur=left,next=null;
        if(cur!=null) {
            next = cur.next;
        }
        
        while(freq>=0) {
            cur.next = prev;
            prev = cur;
            cur = next;
            if(cur!=null) {
                next = cur.next;
            }
            freq--;
        }
        
        if(prevToLeft!=null) {
            prevToLeft.next = prev;
        }
        left.next = nextToRight;
        
        if(l == 1) {
            return prev;
        }
        else {
            return head;
        }
    }
    
    private int lengthOf(ListNode head) {
        int len=0;
        while(head!=null) {
            len++;
            head = head.next;
        }
        return len;
    }
    
    private ListNode getNodeAt(ListNode head, int pos) {
        while(pos>1) {
            head = head.next;
            pos--;
        }
        return head;
    }
}