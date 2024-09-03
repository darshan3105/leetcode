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
        ListNode head=null, tail=null;
        int carry=0;
        while (l1!=null || l2!=null) {
            int val1 = l1==null ? 0 : l1.val;
            int val2 = l2==null ? 0 : l2.val;

            int sum = val1 + val2 + carry;
            ListNode newNode = new ListNode(sum%10);
            carry = sum/10;
            if (head==null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
            l1 = l1==null ? null : l1.next;
            l2 = l2==null ? null : l2.next;
        }

        if (carry!=0) {
            ListNode newNode = new ListNode(carry);
            tail.next = newNode;
            tail = tail.next;
        }

        return head;
    }
}
