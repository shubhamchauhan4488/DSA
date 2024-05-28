import linkedlist.LinkedList;

class LLDeletion extends LinkedList {

	// Method to insert a node at the front of the linked list
	public ListNode insertAtHead(int val) {
		ListNode newNode = new ListNode(val);
		newNode.next = head;
		head = newNode;
		return head;
	}

	// Method to insert a node at the end of the linked list
	public ListNode insertAtTail(int newVal) {
		ListNode newNode = new Node(newVal);
		// empty list, newNode is the head itself
		if (head == null) {
			head = newNode;
			return head;
		}
		// 1 or more items in the list
		ListNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		// reached the last element
		current.next = newNode;
		return head;
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

	public static ListNode insertAtKthFromEnd(ListNode head, int data, int k) {
		if (head == null)
			return null; // list is empty

		// starting a slow pointer from the start/head
		ListNode newNode = new ListNode(data);
		ListNode slow = head;
		ListNode fast = head;
		// if (fast == null)
		// return head.next;
		// 9 -> 1 -> 3 -> 5 -> 7 -> null
		// slow fast // k = 3
		// slow fast // new will come between 3 and 5, 3rd from end
		for (int i = 0; i < k - 1; i++) { // k = 3, fast 2 increments
			fast = fast.next;
		}

		// the initial difference between the 'fast' and the 'slow' and making 'fast'
		// reach the end
		// will help us take "slow" to the node after which we need to insert
		while (fast.next != null) { // taking fast to the end, incrementing both fast and slow by 1
			// keep traversing, we want to reach the end
			slow = slow.next;
			fast = fast.next;
		}

		// same insertion logic as "at the middle"
		newNode.next = slow.next;
		slow.next = newNode;

		return head;
	}

}