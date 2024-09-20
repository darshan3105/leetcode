// https://leetcode.com/problems/swap-nodes-in-pairs/
// TC: O(n)
// SC: O(1)
// where n is the length of the List

**
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
    public ListNode swapPairs(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null && curr.next!=null) {
            ListNode next = curr.next;
            ListNode nextToNext = next.next;
            if (prev==null) {
                prev = next;
                head = prev;
            } else {
                prev.next = next;
            }
            next.next=curr;
            curr.next = nextToNext;

            prev = curr;
            curr = curr.next;
        }

        return head;
    }
}
