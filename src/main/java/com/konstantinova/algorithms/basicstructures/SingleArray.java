package com.konstantinova.algorithms.basicstructures;

public class SingleArray<T> implements IArray<T> {
    private T[] array;

    public SingleArray() {
        array = (T[]) new Object[0];
    }

    @Override
    public int size() {
        return array.length;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public void add(T item) {
        resize();
        array[size() - 1] = item;
    }

    @Override
    public void add(T item, int index) {
        T[] newArray = (T[]) new Object[size() + 1];

        // копируем от i = 0 до i = index
        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = item;
        // копируем от i = index + 1 до i = size() - index
        System.arraycopy(array, index, newArray, index + 1, size() - index);

        array = newArray;
    }

    @Override
    public T remove(int index) {
        T removedElement = array[index];
        T[] newArray = (T[]) new Object[size() - 1];

        // копируем от i = 0 до i = index
        System.arraycopy(array, 0, newArray, 0, index);
        // копируем от i = index + 1 до i = size() - index - 1
        System.arraycopy(array, index + 1, newArray, index, size() - index - 1);

        array = newArray;
        return removedElement;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    private void resize() {
        T[] newArray = (T[]) new Object[size() + 1];
        System.arraycopy(array, 0, newArray, 0, size());
        array = newArray;
    }
}
