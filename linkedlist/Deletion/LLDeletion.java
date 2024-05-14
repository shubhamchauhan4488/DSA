import linkedlist.LinkedList;

class LLDeletion extends LinkedList {

	/**
	 * Deletes the element at the head of the LL
	 * TC: O(1), SC: O(1)
	 */
	public static ListNode removeNodeAtHead(ListNode head) {
		if (head == null)
			return head;
		head = head.next;
		return head;
	}

	/**
	 * Deletes the element at the tail of the LL
	 * TC: O(N), SC: O(1)
	 */
	public static ListNode removeNodeAtTail(ListNode head) {
		if (head == null)
			return head;
		ListNode current = head;
		while (current.next.next != null) { // second last element
			current = current.next;
		}
		current.next = null; // marking second last node's next as null and hence the last node in the LL
		return head;
	}

	/**
	 * Deletes the element from the middle
	 * TC: O(n) SC: O(1) no extra space being used
	 */
	public static ListNode removeNodeFromMiddle(ListNode head) {
		if (head == null)
			return head;
		// using the fast and the slow pointer approach
		ListNode fast = head;

		if (fast == null)
			return head.next;

		fast = fast.next; // moving one ahead so that slow stops at middle -1

		// starting a slow pointer from the start/head
		ListNode slow = head;

		while (fast.next != null) { // taking fast to the end, incrementing both fast and slow by 1
			slow = slow.next;
			fast = fast.next.next; // fast has 2x speed
		}

		// now perform the deletion, slow will be at the middle - 1
		slow.next = slow.next.next; // by-pass the middle node
		return head;
	}

	/**
	 * Deletes the 'k'th element from the end
	 * TC: O(n) SC: O(1) no extra space being used
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

	/**
	 * Deletes the 'k'th element from the start
	 * TC: O(n) SC: O(1) no extra space being used
	 */
	public static ListNode removeKthFromStart(ListNode head, int k) {
		if (k <= 0) { // invalid
			return head;
		}
		if (k == 1) { // remove first element
			head = head.next;
			return head;
		}

		// the actual kth removal
		ListNode current = head;
		ListNode previous = null;
		int count = 1;
		while (current.next != null && count < k) { // count 1, count 2, k = 3rd position
			previous = current;
			// System.out.println("current" + current.val);
			current = current.next;
			count++;
		}
		// previous will be at k - 1
		// [12]->[5](prev)->[8](current)->[4] and we want to delete 8

		// just bypass the [8]
		previous.next = current.next;
		return head;
	}

	public static void removeNodeWithValue(ListNode node) { // just node to be deleted is given, NO ACCESS TO HEAD
        if(node == null || node.next == null){
            System.out.println("cannot delete last node with this method");
        }

        // copy the data from the next node into the current node, thats it!!
        // the val
        // the pointer

        node.val = node.next.val;
        node.next = node.next.next;
    }

	// Given the head of a linked list and an integer val,
	// remove ALL the nodes of the linked list that has Node.val == val, and return the new head.
	/**
	 * Input: head = [1,2,6,3,4,5,6], val = 6
		Output: [1,2,3,4,5]
		Example 2:

		Input: head = [], val = 1
		Output: []
		Example 3:

		Input: head = [7,7,7,7], val = 7
		Output: []
	 */
    public static ListNode removeAllElements(ListNode head, int val) {
        if(head == null) return null;
		
        // first element itself, to be deleted
        if(head.val == val){
            return removeElements(head.next, val); // just move head + 1 and call the function again
        } 
        ListNode current = head;
        ListNode previous = null;
        while(current != null){
            if(current.val == val){
                previous.next = current.next;
            }else{
                previous = current; // maintains the previous node
            }
            current = current.next;
          
        }
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

	// System.out.println("-------- Delete Kth from start --------");
	// traverse(removeKthFromStart(head, 2));

	// System.out.println("-------- Delete from middle --------");
	// head = removeNodeFromMiddle(head);

	// System.out.println("-------- Delete a particular Node --------");
	// removeNodeWithValue(head.next.next); // want to delete 8, passing only that node
}