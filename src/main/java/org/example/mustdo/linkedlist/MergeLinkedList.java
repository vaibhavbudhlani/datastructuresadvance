package org.example.mustdo.linkedlist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.mustdo.linkedlist.ReverseLinkedListInGroups.printList;

public class MergeLinkedList {

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);

        // Creating second linked list 4->5->6->7->8
        Node head2 = new Node(4);
        head2.next = new Node(5);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(7);
//        head2.next.next.next.next = new Node(8);

        // Store first and second head points in array
        List<Node> ar = merge(head1, head2);
        printList(ar.get(0));
        printList(ar.get(1));
    }

    static List<Node> merge(Node head1, Node head2) {
        Node temp = head1;
        while(head1 != null){
            Node next1 = head1.next;
               if(head2 != null){
                Node next2 = head2.next;
                head1.next = head2;
                head2 = next2;
                head1.next.next = next1;

            }
            head1 = next1;
        }

        return Arrays.asList(temp, head2);
    }
}
