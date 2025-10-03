package org.example.mustdo.linkedlist;

import static org.example.mustdo.linkedlist.ReverseLinkedListInGroups.printList;

public class CloneLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next;

        // Print the original list
        System.out.println("Original linked list:");
        printListNew(head);

        // Function call
        Node clonedList = cloneLinkedList(head);

        System.out.println("Cloned linked list:");
        printListNew(clonedList);
    }

    public static void printListNew(Node head) {
        while (head != null) {
            System.out.print(head.data + "(");
            if (head.random != null) {
                System.out.print(head.random.data);
            } else {
                System.out.print("null");
            }
            System.out.print(")");

            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    // Function to clone the linked list
    static Node cloneLinkedList(Node head) {
        if(head == null){
            return null;
        }
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

         curr= head;

        while(curr != null){
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node clonedHead = head.next;
        Node clone = clonedHead;
        while (clone.next != null) {
            // Update the next nodes of original node
            // and cloned node
            curr.next = curr.next.next;
            clone.next = clone.next.next;

            // Move pointers of original and cloned
            // linked list to their next nodes
            curr = curr.next;
            clone = clone.next;
        }
        curr.next = null;
        clone.next = null;

        return clonedHead;
    }
}
