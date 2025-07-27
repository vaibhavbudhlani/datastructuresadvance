package org.example.mustdo.linkedlist;

import java.util.List;

import static org.example.mustdo.linkedlist.ReverseLinkedListInGroups.printList;
// In this you need to merge in sorted manner
public class MergeTwoSortedList {
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
        Node ar = mergeTwoSorted(head1, head2);
        printList(ar);

    }

    static Node mergeTwoSorted(Node head1, Node head2) {
         Node dummy = new Node(0);

         while(head1 != null && head2!= null){
             if(head1.data < head2.data){
                 dummy.next = head1;
                 head1 = head1.next;
             }
             else{
                 dummy.next = head2;
                 head2 = head2.next;
             }
             dummy = dummy.next;
         }
         dummy.next = (head1 == null)? head2 : head1;

         return dummy.next;

    }
}
