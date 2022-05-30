// https://leetcode.com/problems/reorder-list/
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
    public void reorderList(ListNode head) {
        ListNode mid = getMid(head);
        ListNode h1=head, h2=mid.next;
        mid.next=null;
        h2 = reverse(h2);
        
        ListNode tail=null;
        head=null;
        while(h1!=null) {
            if(head==null) {
                ListNode nextH1=h1.next, nextH2= h2==null ? null : h2.next;
                head=h1;
                tail=h1;
                
                tail.next=h2;
                tail=tail.next;
                
                h1=nextH1;
                h2=nextH2;
            }
            else {
                ListNode nextH1=h1.next, nextH2= h2==null ? null : h2.next;
                tail.next=h1;
                tail=tail.next;
                tail.next=h2;
                tail=tail.next;

                h1=nextH1;
                h2=nextH2;
            }
        }
    }
    
    private ListNode reverse(ListNode head) {
        if(head==null) {
            return null;
        }
        
        ListNode prev=null, cur=head, next=cur.next;
        while(cur!=null) {
            cur.next=prev;
            
            prev=cur;
            cur=next;
            if(next!=null) {
                next=next.next;
            }
        }
        
        return prev;
    }
    
    private ListNode getMid(ListNode head) {
        ListNode s=head, f=head;
        while(f!=null) {
            f=f.next;
            if(f==null || f.next==null) {
                break;
            }
            f=f.next;
            s=s.next;
        }
        return s;
    }
}