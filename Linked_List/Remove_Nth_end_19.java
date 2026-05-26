package Linked_List;

public class Remove_Nth_end_19 {
    // Solution 1 : O(2n)

    // To find length
    private int length(ListNode head){
        int res = 0 ;
        ListNode temp = head ;
        while(temp != null){
            temp = temp.next ;
            res++;
        }
        return res ;
    }
    //Main function
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0) ;
        dummy.next = head ;
        int tot = length(head) ;
        
        int req = tot-n ;
        ListNode temp = dummy ;
        
        for(int i = 0 ; i < req ; i++){
            temp = temp.next ;
        }
        temp.next = temp.next.next ;
        return dummy.next ;
    }

    // Solution 2 : O(n) using 2 pointer approach (fast and slow pointers)

    
}
