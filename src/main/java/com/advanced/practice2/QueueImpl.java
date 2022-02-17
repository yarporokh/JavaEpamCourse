package com.advanced.practice2;

import java.util.Iterator;

public class QueueImpl implements Queue {
    private Node head;

    @Override
    public void clear() {
        head = new Node(null);
    }

    @Override
    public int size() {
        if (head == null)
            return 0;
        Node tempNode = head;
        int count = 1;
        while (tempNode.next != null) {
            count++;
            tempNode = tempNode.next;
        }
        return count;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    @Override
    public void enqueue(Object element) {
        if (head == null) {
            head = new Node(element);
            return;
        }

        Node newNode = new Node(element);

        Node last = head;
        while (last.next != null)
            last = last.next;

        last.next = newNode;
    }

    @Override
    public Object dequeue() {
        if (head.next == null) {
            Object removedElem = head.data;
            head = null;
            return removedElem;
        }

        Node last = head;
        while (last.next.next != null)
            last = last.next;

        Object removedElem = last.next.data;
        last.next = null;
        return removedElem;
    }

    @Override
    public Object top() {
        return head.data;
    }

    @Override
    public String toString() {
        Node tempHead = head;
        String str = "[";
        while (tempHead != null) {
            str += tempHead.data + ", ";
            tempHead = tempHead.next;
        }

        if (str.contains(", ")) {
            str = str.substring(0, str.length() - 2);
        }

        str += "]";
        return str;
    }

    class IteratorImpl implements Iterator<Object> {
        @Override
        public boolean hasNext() {
            return head.next != null;
        }

        @Override
        public Object next() {
            return head.next;
        }
    }

    static class Node {
        Object data;
        Node next;

        Node(Object d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        QueueImpl queue = new QueueImpl();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.top());
    }
}
