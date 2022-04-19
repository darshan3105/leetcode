// https://leetcode.com/problems/merge-k-sorted-lists/
// TC: O(klogk + nlogk)
// SC: O(k) excluding the space required to store the result
// n = size of the result linked list

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class SolutionA {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        ListNode head=null, tail=null;
        
        for(int i=0;i<lists.length;i++) {
            if(lists[i]!=null) {
                pq.add(new int[]{lists[i].val, i});
            }
        }
        
        while(!pq.isEmpty()) {
            int[] top = pq.poll();
            ListNode node = new ListNode(top[0]);
            if(head==null) {
                head = node;
                tail = node;
            }
            else {
                tail.next = node;
                tail = tail.next;
            }
            
            lists[top[1]] = lists[top[1]].next;
            if(lists[top[1]]!=null) {
                pq.add(new int[]{lists[top[1]].val, top[1]});
            }
        }
        
        return head;
    }
}