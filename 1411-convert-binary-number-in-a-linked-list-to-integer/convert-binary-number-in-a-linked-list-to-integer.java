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
    public int getDecimalValue(ListNode head) {
     ArrayList<Integer>ans=new ArrayList<>();
     ListNode curr=head;
     while(curr!=null){
        ans.add(curr.val);
        curr=curr.next;
     }
     int index=0;
     int power=0;
     for(int i=ans.size()-1;i>=0;i--){
        int val=ans.get(i);
        if(val==1)power+=Math.pow(2,index);
        index++;
     }
     return power;
    }
}