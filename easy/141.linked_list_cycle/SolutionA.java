// https://leetcode.com/problems/linked-list-cycle/
// TC: O(n)
// SC: O(1)

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class SolutionA {
    public boolean hasCycle(ListNode head) {
        ListNode s = head, f = head;
        while(f!=null) {
            s=s.next;
            f=f.next;
            if(f!=null) {
                f=f.next;
            }
            if(f==s && f!=null) {
                return true;
            }
        }
        
        return false;
    }
}