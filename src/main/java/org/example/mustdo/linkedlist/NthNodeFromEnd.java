package org.example.mustdo.linkedlist;

public class NthNodeFromEnd {
    public static void main(String[] args) {
        // 35 -> 15 -> 4 -> 20
        Node head = new Node(35);
        head.next = new Node(15);
        head.next.next = new Node(4);
        head.next.next.next = new Node(20);

        // Function Call to find the 4th node from end
        System.out.println(nthFromEnd(head, 4));
    }

    static int nthFromEnd(Node head, int N) {
        Node main = head;
        Node ref = head;
        int ctr =1 ;
        while(ref !=null && ctr<N){
            ref= ref.next;
            ctr++;
        }
        while(ref.next!=null ){
            main = main.next;
            ref = ref.next;
        }
        return main.data;
    }
}
