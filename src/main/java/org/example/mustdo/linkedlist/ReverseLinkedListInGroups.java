package org.example.mustdo.linkedlist;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}

public class ReverseLinkedListInGroups {
    static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        head = reverseKGroup(head, 3);
        printList(head);
    }

    static Node reverseKGroup(Node head, int k) {

        if (head == null) {
            return head;
        }

        Node curr = head;
        Node newHead = null;
        Node tail = null;

        while(curr!= null) {
            Node prev = null;
            Node groupHead = curr;
            Node next;
            int count = 0;

            while (curr != null && count < k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if(newHead == null){
                newHead = prev;
            }
            if(tail != null){
                tail.next = prev;
            }
            
            tail = groupHead;
        }


             return newHead;
    }


}
