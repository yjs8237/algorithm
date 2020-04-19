package com.greatyun.algorithm.graph;

import com.greatyun.algorithm.binaryTree.Node;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T>  {

    private LinkedList<T> list;

    public Queue() {
        this.list = new LinkedList<T>();
    }

    public void enqueue(T data) {
        this.list.add(data);
    }

    public T dequeue() {
        return this.list.remove();
    }

    public T remove() {
        return this.list.remove();
    }

    public T peek() {
        return this.list.peek();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }




}
