import linkedlist.LinkedList;

class LLDeletion extends LinkedList {

    public static ListNode findMiddle(ListNode head)
    {
        // Write your code here.
        // for even numbers : n/2 +1
    
        // for odd: n+1/2
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){ 
            // even case : the fast pointer will be reach the null (1,3,5,null) 6 nodes in list [1,2,3,4,5,6]
            // and odd case: the fast pointer reaches the last (1,3,5) 5 nodes in list [1,2,3,4,5]
            fast = fast.next.next; // move by 2 positions (2x)
            slow = slow.next; // move by 1 positions (1x)
            // when fast reaches the end, slow will be at middle
            // example: length of 8,  fast will take (1, 3, 5, 7), slow (1,2,3,4) at last element (8th), slow at 4th
            // example: length of 5,  fast will take (1, 3, 5), slow (1,2,3) when fast at last element (8th), slow at 4th
        }
        return slow;
    }
	// Traverse after deletion, from the head that is received after making the changes
	// System.out.println("-------- Delete Head --------");
  // traverse(removeNodeAtHead(head));
  // System.out.println("-------- Delete Tail --------");
	// traverse(removeNodeAtTail(head));
	// System.out.println("-------- Delete Kth from end --------");
  // traverse(removeKthNodeFromEnd(head, 2));
}
