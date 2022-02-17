package com.advanced.practice2;

import java.util.Iterator;

public class ListImpl implements List {
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
    public void addFirst(Object element) {
        Node newHead = new Node(element);
        newHead.next = head;
        head = newHead;
    }

    @Override
    public void addLast(Object element) {
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
    public void removeFirst() {
        head = head.next;
    }

    @Override
    public void removeLast() {
        if (head.next == null) {
            head = null;
            return;
        }

        Node last = head;
        while (last.next.next != null)
            last = last.next;

        last.next = null;
    }

    @Override
    public Object getFirst() {
        return head.data;
    }

    @Override
    public Object getLast() {
        Node tempNode;
        tempNode = head;

        if (tempNode.data == null)
            return null;

        while (tempNode.next != null)
            tempNode = tempNode.next;

        return tempNode.data;
    }

    @Override
    public Object search(Object element) {
        Node tempNode = head;
        while (tempNode.next != null) {
            if (tempNode.data.equals(element))
                return tempNode.data;
            tempNode = tempNode.next;
        }

        return null;
    }

    @Override
    public boolean remove(Object element) {
        if (head.equals(null))
            return false;

        if (head.data.equals(element)) {
            removeFirst();
            return true;
        }

        Node tempNode = head;
        while (tempNode.next != null) {
            if (tempNode.next.data.equals(element))
                break;

            tempNode = tempNode.next;
        }

        if (tempNode.next.data.equals(null))
            tempNode.next = null;
        else
            tempNode.next = tempNode.next.next;

        return true;
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
        ListImpl list = new ListImpl();
        list.addFirst("C");
        list.addFirst("B");
        list.addFirst("A");
        list.addLast("F");
        System.out.println(list);
        list.remove("F");
        System.out.println(list);
        System.out.println(list.size());
    }
}
