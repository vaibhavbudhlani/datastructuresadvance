package org.example.mustdo.linkedlist;

public class FloydCycle {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);

        // Create a loop
        head.next.next.next = head.next;

        if (detectLoop(head))
            System.out.println("true");
        else
            System.out.println("false");
    }

    static boolean detectLoop(Node head) {

        // Fast and slow pointers initially points to the head
        Node slow = head, fast = head;

        // Loop that runs while fast and slow pointer are not
        while(slow != null && fast != null && fast.next!= null){
            slow= slow.next;
            fast= fast.next.next;

            if(slow == fast){
                return  true;
            }
        }
        return false;
    }
}
