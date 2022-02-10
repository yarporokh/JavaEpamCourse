package com.advanced.practice1.task2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayImpl implements Array {

    private Object[] objects = new Object[0];
    private int currentPos = -1;

    @Override
    public void add(Object element) {
        Object[] temp = objects;
        objects = new Object[temp.length + 1];
        for (int i = 0; i < temp.length; i++) {
            objects[i] = temp[i];
        }

        objects[objects.length - 1] = element;

    }

    @Override
    public void set(int index, Object element) {
        if (index >= objects.length || index < 0) throw new IndexOutOfBoundsException();

        Object[] temp = objects;
        objects = new Object[temp.length + 1];

        for (int i = 0; i < index; i++) {
            objects[i] = temp[i];
        }

        for (int i = index; i < temp.length; i++) {
            objects[i + 1] = temp[i];
        }

        objects[index] = element;
    }

    @Override
    public Object get(int index) {
        if (index >= objects.length || index < 0) throw new IndexOutOfBoundsException();
        return objects[index];
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < objects.length; i++) {
            if (element.equals(objects[i]))
                return i;
        }
        return -1;
    }

    @Override
    public void remove(int index) {
        if (index >= objects.length || index < 0) throw new IndexOutOfBoundsException();

        for (int i = index; i < objects.length - 1; i++) {
            objects[i] = objects[i + 1];
        }

        Object[] temp = objects;
        objects = new Object[temp.length - 1];
        for (int i = 0; i < objects.length; i++) {
            objects[i] = temp[i];
        }
    }

    @Override
    public void clear() {
        objects = new Object[0];
    }

    @Override
    public int size() {
        return objects.length;
    }

    @Override
    public String toString() {
        String str = "[";
        for (var object: objects) {
            str += object + ", ";
        }

        if (str.contains(", ")) {
            str = str.substring(0, str.length() - 2);
        }

        str += "]";
        return str;
    }

    @Override
    public Iterator<Object> iterator() {
        return new IteratorImpl();
    }

    class IteratorImpl implements Iterator<Object> {


        @Override
        public boolean hasNext() {
            return objects.length > currentPos + 1;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                currentPos++;
                return objects[currentPos];
            } else throw new NoSuchElementException();
        }
    }

    public static void main(String[] args) {
        ArrayImpl array = new ArrayImpl();

        //Add elements to array
        array.add("A");
        array.add("B");
        array.add("C");

        //All iterator methods demonstration
        System.out.println(array.iterator().hasNext());
        System.out.println("First element: " + array.iterator().next());
        System.out.println(array.iterator().hasNext());
        System.out.println("Second element: " + array.iterator().next());
        System.out.println(array.iterator().hasNext());
        System.out.println("Third element: " + array.iterator().next());
        System.out.println(array.iterator().hasNext());

        //All array methods demonstration
        System.out.println("Array size: " + array.size());
        System.out.println("Array: " + array);
        array.remove(2);
        System.out.println("Array after deleting element with index 2: " + array);
        System.out.println("Index of the element B: " + array.indexOf("B"));
        System.out.println("Index of the element that is not in the array: " + array.indexOf("Z"));
        array.set(1, "W");
        System.out.println("Array after putting W on index 1: " + array);
        System.out.println("Get element with index 2: " + array.get(2));
        array.clear();
        System.out.println("Array after clearing: " + array);


    }
}
