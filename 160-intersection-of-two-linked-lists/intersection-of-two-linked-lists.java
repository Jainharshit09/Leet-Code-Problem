/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int length(ListNode l1){
        int count=0;
        while(l1!=null){
            count++;
            l1=l1.next;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        // int l1=length(head1);
        // int l2=length(head2);
        // head1=head1.next;
        // }
        // while(l2>l1){
        //     l2--;
        //     head2=head2.next;
        // }
        // while(head1!=head2){
        //   head1=head1.next;
        //   head2=head2.next;
        // }
        // return head1;
        ListNode A=head1;
        ListNode B=head2;
        while(A!=B){
            if(A==null){
                A=head2;
            }
            else{
                A=A.next;
            }
            if(B==null){
                B=head1;
            }
            else{
                B=B.next;
            }
        }
        return A;
    }
}