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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode [] result=new ListNode[k];
        ListNode t=head;
        int n=0;
        while(t!=null){
            n++;
            t=t.next;
        }
        int count=n/k;
        int rem=n%k;
        ListNode curr=head;
        for(int i=0;i<k;i++){
            ListNode temp=curr;
            ListNode prev=null;
            for(int j=0;j<count + (rem > 0 ? 1 : 0);j++){
                prev=curr;
                if(curr!=null){
                    curr=curr.next;
                }
            }
            if(prev!=null){
                prev.next=null;
            }
            result[i]=temp;
            if (rem > 0) {
                rem--;
            }
        }
        return result;
    }
}