// https://leetcode.com/problems/palindrome-linked-list/
// TC: O(n)
// SC: O(1) excluding the stack space

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
    
    ListNode ptr1;
    
    public boolean isPalindrome(ListNode head) {
        ptr1 = head;
        return isPalin(head);
    }
    
    private boolean isPalin(ListNode node) {
        if(node==null) {
            return true;
        }
        
        if(isPalin(node.next)) {
            if(node.val == ptr1.val) {
                ptr1 = ptr1.next;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}