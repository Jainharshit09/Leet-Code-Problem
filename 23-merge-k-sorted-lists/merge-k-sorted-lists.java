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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode list : lists) {
            while (list != null) {
                pq.add(list);
                list = list.next;
            }
        }

        ListNode temp = new ListNode(0);
        ListNode curr = temp;

        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;
        }

        curr.next = null;

        return temp.next;
    }
}
