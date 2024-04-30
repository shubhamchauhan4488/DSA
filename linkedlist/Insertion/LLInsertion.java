import linkedlist.LinkedList;

class LLDeletion extends LinkedList {

    // Method to insert a node at the front of the linked list
    public void insertAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    // Method to insert a node at the end of the linked list
    public void insertAtTail(int newVal) {
        ListNode newNode = new Node(newVal);
        // empty list, newNode is the head itself
        if (head == null) {
            head = newNode;
            return;
        }
        // 1 or more items in the list
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        // reached the last element
        current.next = newNode;
    }
}