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

	/* converts an array to link list */
	public convertArr2LL(int[] arr){
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

	public static void main(String args[]) {
		int[] arr = { 12, 5, 8, 4 };
		ListNode head = convertArr2LL(arr);
		System.out.println(head.data);
	}
}