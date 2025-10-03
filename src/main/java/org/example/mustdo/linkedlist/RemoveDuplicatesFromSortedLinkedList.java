package org.example.mustdo.linkedlist;

import java.util.HashSet;

import static org.example.mustdo.linkedlist.ReverseLinkedListInGroups.printList;

public class RemoveDuplicatesFromSortedLinkedList {
    public static void main(String[] args) {
        Node head = new Node(11);
        head.next = new Node(11);
        head.next.next = new Node(11);
        head.next.next.next = new Node(13);
        head.next.next.next.next = new Node(13);
        head.next.next.next.next.next = new Node(20);

        System.out.println(
                "Linked list before duplicate removal:");
        printList(head);

        head = removeDuplicatesExpected(head);

        System.out.println(
                "Linked list after duplicate removal:");
        printList(head);
    }

    static Node removeDuplicates(Node head) {
         HashSet<Integer> hs = new HashSet<>();
         if(head == null || head.next == null){
             return head;
         }
         Node curr = head;
         Node newList = head;
         Node newHead = newList;
         hs.add(head.data);

         while(curr!= null){
             if(!hs.contains(curr.data)){
                 newList.next = curr;
                 newList = newList.next;
                 hs.add(curr.data);
             }
             curr = curr.next;
         }
         return newHead;
    }

    static Node removeDuplicatesExpected(Node head){
        Node curr = head;
        while(curr!=null && curr.next != null){
            while(curr.data == curr.next.data){
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }
}
