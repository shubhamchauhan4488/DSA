import linkedlist.LinkedList;

class LLDeletion extends LinkedList {

	/** Deletes the element at the head of the LL
	 *  TC: O(1), SC: O(1)
	 */
	public static ListNode removeNodeAtHead(ListNode head){
		if(head == null) return head;
		head = head.next;
		return head;
	}

	/** Deletes the element at the tail of the LL
	 *  TC: O(N), SC: O(1)
	 */
	public static ListNode removeNodeAtTail(ListNode head){
		if(head == null) return head;
		ListNode current = head;
		while(current.next.next != null){ // second last element
			current = current.next;
		}
		current.next = null; // marking second last node's next as null and hence the last node in the LL
		return head;
	}

	/** Deletes the 'k'th element from the end 
	 *  TC: O(n) SC: O(1) no extra space being used
	*/
	public static ListNode removeKthNodeFromEnd(ListNode head, int K) {
		if (head == null)
			return head;
		// using the fast and the slow pointer approach
		ListNode fast = head;
		for (int i = 0; i < K; i++) {
			fast = fast.next; // moving the fast pointer ahead by the same amount as the 'K'
		}

		// means say we had 1,2,3 and we need to delete 3rd element from end i.e 1 i.e
		// head itself
		// fast will start at the 'head' but after increments equal to the length of the
		// array will reach the 'null'
		// means we are going positions from back = length of the list
		if (fast == null)
			return head.next;

		// starting a slow pointer from the start/head
		ListNode slow = head;
		// the initial difference between the 'fast' and the 'slow' and making 'fast'
		// reach the end
		// will help us take "slow" to the ListNode after which we need to insert
		while (fast.next != null) { // taking fast to the end, incrementing both fast and slow by 1
			// keep traversing, we want to reach the end
			// System.out.println("fast"+ fast.data);
			// System.out.println("slow"+ slow.data);
			slow = slow.next;
			fast = fast.next;
		}

		// now perform the deletion
		slow.next = slow.next.next;

		return head;
	}

	// Traverse after deletion, from the head that is received after making the changes
	// System.out.println("-------- Delete Head --------");
  // traverse(removeNodeAtHead(head));
  // System.out.println("-------- Delete Tail --------");
	// traverse(removeNodeAtTail(head));
	// System.out.println("-------- Delete Kth from end --------");
  // traverse(removeKthNodeFromEnd(head, 2));
}