package com.advanced.practice3;

import java.util.Arrays;
import java.util.Iterator;

public class MedianQueue implements Iterable<Integer>{
    private int maxSize;
    private Integer[] queArray;
    private int front;
    private int rear;
    private int nItems;

    public MedianQueue(int s)
    {
        maxSize = s;
        queArray = new Integer[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void offer(Integer j)
    {
        if(rear == maxSize-1)
            rear = -1;
        queArray[++rear] = j;
        nItems++;
    }

    public Integer poll()
    {
        Integer temp = queArray[front++];
        if(front == maxSize)
            front = 0;
        nItems--;
        return temp;
    }

    public int peek() {
        return queArray[front];
    }

    public int size() {
        return nItems;
    }

    public int getMedian() {
        Arrays.sort(queArray);
        if (maxSize % 2 == 0) {
            return queArray[maxSize / 2 - 1];
        } else
            return queArray[maxSize / 2];
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> it = new Iterator<>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < maxSize && queArray[currentIndex] != null;
            }

            @Override
            public Integer next() {
                return queArray[currentIndex++];
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
        return Arrays.toString(queArray);
    }
}
