// https://leetcode.com/problems/reverse-nodes-in-k-group/
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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = lengthOf(head);
        int freq = len/k;
        ListNode resultHead = null, tail = null, prevTail=null;
        ListNode prev=null, cur=head, next=cur.next;
        for(int i=0;i<freq;i++) {
            tail = cur;
            for(int j=0;j<k;j++) {
                cur.next = prev;
                prev = cur;
                cur = next;
                if(cur != null) {
                    next = cur.next;
                }
            }
            
            if(resultHead == null) {
                resultHead = prev;
            }
            
            if(prevTail!=null) {
                prevTail.next = prev;
            }
            tail.next = cur;
            prev = tail;
            prevTail = tail;
        }
        
        return resultHead;
    }
    
    private int lengthOf(ListNode head) {
        int len = 0;
        while(head!=null) {
            len++;
            head = head.next;
        }
        return len;
    }
}