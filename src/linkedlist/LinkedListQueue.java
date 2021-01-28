package linkedlist;

import qurue.Queue;

/**
 * @Auther: Alex
 * @Date: 2021/1/9 - 01 - 09 -16:13
 * @Description: linkedlist
 * @Verxion: 1.0
 */
public class LinkedListQueue<E> implements Queue<E> {
    private class Node{

        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node() {
        }
        @Override
        public String toString() {
            return e.toString();
        }
    }
    private Node head,tail;
    private int size;
    public LinkedListQueue(){
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if(tail == null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if(head == null){
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot get from an empty queue");
        }
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");
        Node cur = head;
        while(cur != null){
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}