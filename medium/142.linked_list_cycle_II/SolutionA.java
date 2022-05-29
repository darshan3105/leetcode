// https://leetcode.com/problems/linked-list-cycle-ii/
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
    public ListNode detectCycle(ListNode head) {
        if(head==null) {
            return null;
        }
        
        ListNode s=head, f=head;
        while(f!=null) {
            s=s.next;
            f=f.next;
            if(f!=null) {
                f=f.next;
            }
            if(s==f) {
                break;
            }
        }
        if(f==null) {
            return null;
        }
        
        s=head;
        while(s!=f) {
            s=s.next;
            f=f.next;
        }
        
        return s;
    }
}