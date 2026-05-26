// Solution 1 : O(2n) 

    private int length(ListNode head){
        int res = 0 ;
        ListNode temp = head ;
        while(temp != null){
            temp = temp.next ;
            res++;
        }
        return res ;
    }

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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head ;

        ListNode slow = dummy ;
        ListNode fast = dummy ;

        for(int i = 0 ; i <= n ; i++){
            fast = fast.next ;
        }
        while(fast != null){
            fast = fast.next ;
            slow = slow.next ;
        }
        slow.next  = slow.next.next ;
        return dummy.next ;
    }

