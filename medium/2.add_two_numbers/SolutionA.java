// https://leetcode.com/problems/add-two-numbers/
// TC: O(max(n,m))
// SC: O(max(n,m)) where n = length of linked list 1, m = length of linked list 2

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode head = null, tail = null;
        while(l1!=null && l2!=null) {
            int sum = l1.val + l2.val + carry;
            carry = sum/10;
            int digit = sum%10;
            
            if(head==null) {
                head = new ListNode(digit);
                tail = head;
            }
            else {
                tail.next = new ListNode(digit);
                tail=tail.next;
            }
            
            l1=l1.next;
            l2=l2.next;
        }
        
        while(l1!=null) {
            int sum = l1.val + carry;
            carry = sum/10;
            int digit = sum%10;
            tail.next = new ListNode(digit);
            tail=tail.next;
            l1=l1.next;
        }
        
        while(l2!=null) {
            int sum = l2.val + carry;
            carry = sum/10;
            int digit = sum%10;
            tail.next = new ListNode(digit);
            tail=tail.next;
            l2=l2.next;
        }
        
        if(carry!=0) {
            tail.next = new ListNode(carry);
            tail=tail.next;
        }
        
        return head;
    }
}