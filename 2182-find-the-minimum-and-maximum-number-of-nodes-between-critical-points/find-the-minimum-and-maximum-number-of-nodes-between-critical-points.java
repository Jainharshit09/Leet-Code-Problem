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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> ans=new ArrayList<>();
        ListNode prev=head;
        ListNode curr=prev.next;
        ListNode next=curr.next;
        int count=0;
        while(next!=null){
            if((prev.val<curr.val && next.val<curr.val) || (prev.val>curr.val && next.val>curr.val)){
                ans.add(count);
            }
            prev=curr;
            curr=next;
            next=next.next;
            count++;
        }
        if(ans.size()<2){
           return new int[]{-1,-1};
        }
        int mini=Integer.MAX_VALUE;
        int max=ans.get(ans.size()-1)-ans.get(0);
        for(int i=1;i<ans.size();i++){
            mini=Math.min(mini,ans.get(i)-ans.get(i-1));
        }
        return new int[]{mini,max};
    }
}