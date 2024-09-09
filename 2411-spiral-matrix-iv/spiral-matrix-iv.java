/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int n, int m, ListNode head) {
        int arr[][] = new int[n][m];
        ListNode curr = head;
        int sr = 0;
        int sc = 0;
        int er = n - 1;
        int ec = m - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = -1;
            }
        }
        while (sr <= er && sc <= ec) {
            for (int j = sc; j <= ec; j++) {
                if (curr != null) {
                    arr[sr][j] = curr.val;
                    curr = curr.next;
                }
            }
            sr++;
            for (int i = sr; i <= er; i++) {
                if (curr != null) {
                    arr[i][ec] = curr.val;
                    curr = curr.next;
                }
            }
            ec--;
            if (sr <= er) {
                for (int j = ec; j >= sc; j--) {
                    if (curr != null) {
                        arr[er][j] = curr.val;
                        curr = curr.next;
                    }
                }
                er--;
                if (sc <= ec) {
                    for (int i = er; i >= sr; i--) {
                        if (curr != null) {
                            arr[i][sc] = curr.val;
                            curr = curr.next;
                        }
                    }
                    sc++;
                }
            }
        }
        return arr;
    }
}