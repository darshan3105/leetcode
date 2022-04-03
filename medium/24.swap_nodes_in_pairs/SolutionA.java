// https://leetcode.com/problems/swap-nodes-in-pairs/
// TC: O(n)
// SC: O(1)
// where n is the length of the List

public class ListNode {
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int val) { 
        this.val = val; 
    }
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next;
    }; 
}

public class SolutionA {
    public ListNode swapPairs(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        boolean firstSwap = true;
        while(cur!=null && cur.next!=null) {
            ListNode next = cur.next;
            cur.next = cur.next.next;
            next.next = cur;
            if(prev!=null) {
                prev.next = next;
            }
            
            prev = cur;
            cur = cur.next;
            if(firstSwap) {
                head = next;
                firstSwap = false;
            }
        }
        
        return head;
    }
}
