package com.collections;
class Node{
    int value;
    Node next;
    int size;

    public Node() {
        this.size=0;
    }

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(int  value) {
        this.value = value;
    }

}
public class LinkedListImpl {

   private Node head;
   private Node tail;

   private void addAtFirst(int value){
       Node newNode=new Node(value);
       if (head==null){

       }

       newNode.next=head;
       head=newNode;
   }

}
