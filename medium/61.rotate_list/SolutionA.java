// https://leetcode.com/problems/rotate-list/
// TC: O(n)
// SC: O(1)
// where n is the size of the linked list

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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return head;
        }
        
        int len = 0;
        ListNode tempHead = head;
        while(tempHead!=null) {
            tempHead = tempHead.next;
            len++;
        }
        
        int jumps = len - (k%len);
        if(jumps == len) {
            return head;
        }
        
        ListNode firstNode = head;
        while(jumps!=0) {
            if(jumps==1) {
                ListNode temp = firstNode.next;
                firstNode.next = null;
                firstNode = temp;
            }
            else {
                firstNode = firstNode.next;
            }
            jumps--;
        }
        ListNode secondNode = firstNode;
        while(secondNode.next!=null) {
            secondNode = secondNode.next;
        }
        
        secondNode.next = head;
        head = firstNode;
        
        return head;
    }
}