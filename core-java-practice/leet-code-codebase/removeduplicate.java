
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class removeduplicate {
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));
        Solution solution = new Solution();
        ListNode result = solution.deleteDuplicates(head);
        
        while(result != null){
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;
        while(temp != null){
            int n = temp.val;
            while(temp.next != null && temp.next.val == n){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }
}