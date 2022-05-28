package com.konstantinova.algorithms.basicstructures;

public interface IArray<T> {
    int size();

    T get(int index);

    void add(T item);

    void add(T item, int index);

    T remove(int index);

    boolean isEmpty();
}
