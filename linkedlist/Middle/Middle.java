import linkedlist.LinkedList;

class LLDeletion extends LinkedList {

  // this is only to find the middle node
  public static ListNode findMiddle(ListNode head) {
    // Write your code here.
    // for even numbers : n/2 +1

    // for odd: n+1/2
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      // even case : the fast pointer will be reach the null (1,3,5,null) 6 nodes in
      // list [1,2,3,4,5,6]
      // and odd case: the fast pointer reaches the last (1,3,5) 5 nodes in list
      // [1,2,3,4,5]
      fast = fast.next.next; // move by 2 positions (2x)
      slow = slow.next; // move by 1 positions (1x)
      // when fast reaches the end, slow will be at middle
      // example: length of 8, fast will take (1, 3, 5, 7), slow (1,2,3,4) at last
      // element (8th), slow at 4th
      // example: length of 5, fast will take (1, 3, 5), slow (1,2,3) when fast at
      // last element (5th), slow at 3rd
    }
    return slow;
  }

  // Case 1: even numbers
  // say 8, insert at middle means the 5th number (after insertion it will be odd
  // : 9 numbers), middle: (9+1)/2.
  // so the new number should be the fifth from starting
  // Case 2: odd numbers
  // say 5 numbers, insert at middle means the 4th number (after insertion it will
  // be even : 6 numbers), middle: (6)/2 +1.
  // so the new number should be the 4th from starting
  public static ListNode insertAtMiddle(ListNode head) {
    // to achieve this, we need to add fast.next.next != null in the while loop, to
    // stop the small 1 position behind the middle
    ListNode slow = head;
    ListNode fast = head;
    while (fast.next.next != null && fast != null) { // [1,2,3,4,5,6] // [1,2,3,4,5]
      fast = fast.next.next; // 1- > 3- > 5 // 1-> 3-> 5
      slow = slow.next; // 1 -> 2 -> 3 // 1-> 2-> 3 (for even 6 numbers, 6/2 +1 is the middle)
    }
    newNode.next = slow.next;
    slow.next = newNdoe;
    return head;
  }

  // Traverse after deletion, from the head that is received after making the
  // changes
  // System.out.println("-------- Delete Head --------");
  // traverse(removeNodeAtHead(head));
  // System.out.println("-------- Delete Tail --------");
  // traverse(removeNodeAtTail(head));
  // System.out.println("-------- Delete Kth from end --------");
  // traverse(removeKthNodeFromEnd(head, 2));
}
