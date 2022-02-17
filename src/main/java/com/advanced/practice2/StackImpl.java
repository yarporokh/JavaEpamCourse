package com.advanced.practice2;

import java.util.Iterator;

public class StackImpl implements Stack {
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
    public void push(Object element) {
        Node newHead = new Node(element);
        newHead.next = head;
        head = newHead;
    }

    @Override
    public Object pop() {
        Object temp = head.data;
        head = head.next;
        return temp;
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

    @Override
    public Object top() {
        return head.data;
    }

    private class IteratorImpl implements Iterator<Object> {
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
        StackImpl stack = new StackImpl();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.top());

    }
}
