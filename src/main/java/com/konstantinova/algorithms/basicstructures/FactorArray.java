package com.konstantinova.algorithms.basicstructures;

public class FactorArray<T> implements IArray<T> {
    private T[] array;
    private int size;

    public FactorArray() {
        size = 0;
        array = (T[]) new Object[10];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public void add(T item) {
        if (size() == array.length) resize();
        array[size] = item;
        size++;
    }

    @Override
    public void add(T item, int index) {
        if (size() == array.length) resize();
        System.arraycopy(array, index, array, index + 1, size() - index);
        array[index] = item;
        size++;
    }

    @Override
    public T remove(int index) {
        T removedElement = array[index];
        System.arraycopy(array, index + 1, array, index, size() - index - 1);
        size--;
        return removedElement;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private void resize() {
        T[] newArray = (T[]) new Object[size() * 2 + 1];
        if (!isEmpty()) System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }
}
