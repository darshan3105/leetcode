// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLength(head);
        int index = len-n+1;
        if(index==1) {
            return head.next;
        }
        
        ListNode node1 = getNodeAt(head, index-1);
        ListNode node2 = getNodeAt(head, index+1);
        
        node1.next = node2;
        return head;
    }
    
    private ListNode getNodeAt(ListNode head, int index) {
        int i = 1;
        while(i!=index) {
            i++;
            head=head.next;
        }
        return head;
    }
    
    private int getLength(ListNode head) {
        int len = 0;
        while(head!=null) {
            len++;
            head = head.next;
        }
        return len;
    }
}