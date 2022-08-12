// https://leetcode.com/problems/add-two-numbers/
// TC: O(max(n, m))
// SC: O(max(n, m))

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
class SolutionB {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Listt ans = new Listt();
        int carry = 0;
        while(l1!=null || l2!=null) {
            int val1 = l1==null ? 0 : l1.val;
            int val2 = l2==null ? 0 : l2.val;
            int sum = val1+val2+carry;
            ListNode node = new ListNode(sum%10);
            carry = sum/10;
            ans.add(node);
            
            if(l1!=null) {
                l1 = l1.next;
            }
            
            if(l2!=null) {
                l2 = l2.next;
            }
        }
        
        if(carry!=0) {
            ans.add(new ListNode(carry));
        }
        return ans.head;
    }
}

class Listt {
    ListNode head, tail;
    
    public Listt() {
        head = tail = null;
    }
    
    public void add(ListNode node) {
        if(head==null) {
            head = tail = node;
            return;
        }
        
        tail.next = node;
        tail = node;
    }
}