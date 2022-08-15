/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class SolutionA {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLenOf(headA);
        int len2 = getLenOf(headB);
        
        if(len1>len2) {
            for(int i=0;i<len1-len2;i++) {
                headA = headA.next;
            }
        }
        else {
            for(int i=0;i<len2-len1;i++) {
                headB = headB.next;
            }
        }
        
        while(headA!=headB) {
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
    
    private int getLenOf(ListNode head) {
        int len = 0;
        while(head!=null) {
            head = head.next;
            len++;
        }
        return len;
    }
}