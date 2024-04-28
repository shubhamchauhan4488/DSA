import linkedlist.LinkedList;

class LLDeletion extends LinkedList {

    public static Node reverseLL(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static boolean isPalindrome(Node head) {
        if(head == null || head.next == null){
            return true;
        }
        Node originalHead = head;
        Node revList =  reverseLL(head);
        Node temp = revList;
        while(temp != null && originalHead != null){
            // System.out.println("head.data" + originalHead.data);
            // System.out.println("temp.data" + temp.data);
            if(originalHead.data != temp.data){
                return false;
            }
            originalHead = originalHead.next;
            temp = temp.next;
        }
        return true;
    }
}
