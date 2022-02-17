package com.advanced.practice2;

import com.advanced.practice1.task2.Container;

public interface Queue extends Container {

    // Appends the specified element to the end.
    void enqueue(Object element);

    // Removes the head.
    Object dequeue();

    // Returns the head.
    Object top();

}