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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = getSize(head);
        int skip = size-n;

        if (skip==0) {
            head=head.next;
            return head;
        }

        ListNode ptr = head;
        while (skip!=1) {
            ptr = ptr.next;
            skip--;
        }

        ptr.next = ptr.next.next;
        return head;
    }

    private int getSize(ListNode head) {
        int size=0;
        while(head!=null) {
            head = head.next;
            size++;
        }
        return size;
    }
}
