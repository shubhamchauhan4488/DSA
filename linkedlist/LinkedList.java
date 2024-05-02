// Following is the class structure of the Single Link list ListNode class:
class ListNode {
	public int data;
	public ListNode next;
	public ListNode prev;

	ListNode() {
		this.data = 0;
		this.next = null;
	}

	ListNode(int data) {
		this.data = data;
		this.next = null;
	}

	ListNode(int data, ListNode next) {
		this.data = data;
		this.next = next;
	}
};

public class LinkedList {

	/* converts an array to link list 
	 *  TC: O(n) worst case
	 *  SC: O(1) no extra space
	*/
	private static ListNode convertArr2LL(int[] arr){
		// creating the first element of LL
		ListNode head = new ListNode(arr[0]);
		// taking a reference to head
		ListNode current = head;

		for(int i=1;i<arr.length;i++){
			// a new node for every array element
			ListNode temp = new ListNode(arr[i]);
			// connections
			current.next = temp;
			// moving current to temp
			current = temp;
		}
		return head;
  }

	/** Traverse the entire linked list 
	 *  TC: O(n) worst case
	 *  SC: O(1) no extra space
	*/
	private static void traverse(ListNode head){
		ListNode current = head;
		// i.e until we reach the last element, keep going
		while(current != null){
			System.out.println(current.data);
			current = current.next; // for keep going in list
		}
	}

	/**
	 * Counts the number of nodes in the linked list
	 */
	public static int length(ListNode head){
        ListNode current = head;
        int count = 0;
        if(head == null){
            return count; // return 0, if list empty
        }
        while(current != null){
            count+=1; // keep counting + 1 for every element
            current = current.next;
        }
        return count;
    }

	/** Searches for 'val' inside the linked list 
	 *  Returns 1 if found, 0 if not found
	 *  TC: O(n) worst case
	 *  SC: O(1) no extra space
	*/
	private static int search(ListNode head, int k){
		// in every link list need to check for empty list
		if(head == null) return 0;
		ListNode current = head;

		while(current != null){
			if(current.data == val){
				// return wherever the val is found
				return 1;
			}
			current = current.next;
		}
		// reached end, so not found
		return 0;
	}

	public static void main(String args[]) {
		System.out.println("-------- Array to List --------");
		int[] arr = { 12, 5, 8, 4 };
		ListNode head = convertArr2LL(arr);
		// System.out.println(head.data);
		System.out.println("-------- Traverse --------");
		traverse(head);
		System.out.println("-------- Search --------");
		System.out.println(search(head, 8));
	}
}