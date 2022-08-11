// https://leetcode.com/problems/merge-two-sorted-lists/
// TC: O(n+m)
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ptr1 = list1, ptr2 = list2;
        Listt l = new Listt();
        while(ptr1!=null && ptr2!=null) {
            if(ptr1.val < ptr2.val) {
                l.add(ptr1);
                ptr1 = ptr1.next;
            }
            else {
                l.add(ptr2);
                ptr2 = ptr2.next;
            }
        }
        
        if(ptr1!=null) {
            l.add(ptr1);
        }
        else {
            l.add(ptr2);
        }
        
        return l.head;
    }
}

class Listt {
    ListNode head, tail;
    
    public Listt() {
        head = tail = null;
    }
    
    public void add(ListNode node) {
        if(head == null) {
            head = tail = node;
        }
        else {
            tail.next = node;
            tail = tail.next;
        }
    }
}