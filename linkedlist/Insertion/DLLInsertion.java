class DoublyListNode {
    int val;
    DoublyListNode next;
    DoublyListNode prev;

    DoublyListNode() {
        this.val = 0;
        this.next = null;
        this.prev = null;
    }

    DoublyListNode(int data) {
        this.val = data;
    }
}

class DLLInsertion extends LinkedList {
    public static DoublyListNode insertAtFront(DoublyListNode head, int data) {

        // create the node to be inserted
        DoublyListNode newNode = new DoublyListNode(data);
        System.out.println("insertAtFront newNode" + newNode.val);

        if (head == null) { // empty
            head = newNode;
        }

        newNode.next = head; // newNode: forward connection, newNode: backward connection: already exists
                             // (null)
        head.prev = newNode; // head: backward connection, head: forward connection: already exists
        head = newNode; // re-position the head

        return head;
    }

    public static DoublyListNode insertAtEnd(DoublyListNode head, int data) {

        // create the node to be inserted
        DoublyListNode newNode = new DoublyListNode(data);
        System.out.println("insertAtEnd newNode" + newNode.val);

        if (head == null) { // empty
            head = newNode;
        }
        DoublyListNode current = head;
        // reach the end, same as SLL
        while (current.next != null) {
            current = current.next;
        }
        // reached
        current.next = newNode; // current: forward connection, current: backward connection: already exists
        newNode.prev = current; // newNode: backward connection, head: newNode connection: already exists(null)
        current = newNode; // re-position the head

        return head;
    }

}