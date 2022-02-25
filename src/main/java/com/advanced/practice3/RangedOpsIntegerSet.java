package com.advanced.practice3;

import java.util.Arrays;
import java.util.Iterator;

public class RangedOpsIntegerSet implements Iterable<Integer>{
    private Integer[] set;
    private int capacity;
    private int size;

    public RangedOpsIntegerSet(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.set = new Integer[capacity];
    }

    public boolean add(int fromInclusive, int toExclusive) {
        boolean check = false;
        for (int i = fromInclusive; i < toExclusive; i++) {
            if(add(i)){
                check = true;
            }
        }
        return check;
    }

    public boolean add(int number) {
        if (capacity == size) {
            capacity *= 2;
            set = Arrays.copyOf(set, capacity);
        }

        for (int i = 0; i < capacity; i++) {
            if (set[i] == null) {
                set[i] = number;
                break;
            } else if (number == set[i])
                return false;
            else if (number < set[i] && number > set[i - 1]) {
                System.arraycopy(set, i, set, i + 1, size - i);
                set[i] = number;
                break;
            }
        }

        size++;
        return true;
    }

    public boolean remove(int fromInclusive, int toExclusive) {
        boolean check = false;
        for (int i = fromInclusive; i < toExclusive; i++) {
            if(remove(i)){
                check = true;
            }
        }
        return check;
    }

    public boolean remove(int number) {
        if (set[0] == null)
            return false;

        for (int i = 0; i < capacity; i++) {
            if (number == set[i]) {
                System.arraycopy(set, i + 1, set, i, --size);
                set[size] = null;
                return true;
            }
        }

        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> it = new Iterator<Integer>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && set[currentIndex] != null;
            }

            @Override
            public Integer next() {
                return set[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }

    @Override
    public String toString() {
        String str = "[";
        for (Integer el : set) {
            if (el == null)
                break;
            str += el + ", ";
        }
        if (str.contains(", ")) {
            str = str.substring(0, str.length() - 2);
        }

        str += "]";
        str += "   " + size;
        return str;
    }
}
