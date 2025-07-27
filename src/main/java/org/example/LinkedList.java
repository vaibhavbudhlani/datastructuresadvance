package org.example;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    public static void main(String[] args) {
        Node head= new Node(10);
        Node n1 = new Node(20);
        Node n2 = new Node(30);
        Node n3 = new Node(40);
        head.next = n1;
        head.next.next = n2;
        n2.next = n3;
        head = insertAtPosition(1,head,5);
        head = insertAtPosition(5,head,35);
        head = deleteFirstNode(head);
        deleteLastNode(head);
        printList(head);


    }

    private static Node deleteLastNode(Node head){
        Node curr = head;
        while(curr.next.next != null){
            curr = curr.next;
        }
        curr.next = null;
        return head;
    }

    private static Node deleteFirstNode(Node head){
        if(head == null){
            return null;
        }
        return head.next;
    }

    private static void printList(Node head){
        Node curr = head;

        while(curr != null){
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    private static Node insertAtPosition(int pos, Node head, int value){
        Node temp = new Node(value);

        if(pos ==1 ){
            temp.next = head;
            return temp;
        }
        Node curr = head;
        // 10 20 30 40
        // 1  2   3  4
        for(int i=1;i<=pos-2 && curr!=null;i++){
           curr= curr.next;
        }
        if(curr == null){
            return head;
        }
        temp.next = curr.next;
        curr.next = temp;
        return head;


    }
}
