package com.advanced.practice3;


import java.util.*;
import java.util.stream.Collectors;

public class IntStringCappedMap extends TreeMap<Integer, String> {
    private int capacity;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 16;
    private mySet[] map = new mySet[DEFAULT_CAPACITY];

    public IntStringCappedMap(int c) {
        capacity = c;
    }

    public AbstractSet entrySet() {
        return new AbstractSet() {
            private int currentIndex = 0;

            @Override
            public Iterator iterator() {
                return new Iterator() {
                    @Override
                    public boolean hasNext() {
                        return currentIndex < size && map[currentIndex] != null;
                    }

                    @Override
                    public mySet next() {
                        return map[currentIndex++];
                    }
                };
            }

            @Override
            public int size() {
                return size;
            }
        };
    }


    public String put(Integer key, String value) {
        if (value.length() > capacity) throw new IllegalArgumentException();

        if (map.length == size) {
            map = Arrays.copyOf(map, size + 1);
        }
        ++size;
        map[size - 1] = new mySet(key, value);

        while (!checkCapacity()) {
            System.arraycopy(map, 1, map, 0, size);
            size--;
        }
        return value;
    }

    private boolean checkCapacity() {
        int res = 0;
        for (mySet set : map) {
            if (set == null)
                break;
            res += set.v.length();
        }

        if (res > capacity)
            return false;

        return true;
    }

    public void remove(Integer key) {
        for (int i = 0; i < map.length; i++) {
            if (map[i].k == key) {
                map[i] = null;
                System.arraycopy(map, i + 1, map, i, --size);
            }
        }
    }

    @Override
    public String toString() {
        List<mySet> res = Arrays.stream(map)
                .filter(Objects::nonNull).sorted((o1, o2) -> o1.k.compareTo(o2.k))
                .collect(Collectors.toList());

        String str = "{";

        for (mySet set : res) {
            if (set == null)
                break;
            str += set.k + "=" + set.v + ", ";
        }

        if (str.contains(", ")) {
            str = str.substring(0, str.length() - 2);
        }

        str += "}";
        return str;
    }

    static class mySet {
        Integer k;
        String v;

        mySet(Integer k, String v) {
            this.k = k;
            this.v = v;
        }
    }
}
