package org.example;

import java.util.function.Function;

public class MyList<T> {
    private Object[] array = new Object[INITIAL_CAPACITY];
    private static final int INITIAL_CAPACITY = 3;
    private static final int GROW_MULTIPLIER = 2;
    private int size;

    public int size() {
        return size;
    }
    public T get(int index) {
        return (T) array[index];
    }

    private void resize() {
        Object [] newArray = new Object[array.length*GROW_MULTIPLIER];
        System.arraycopy(array,0 ,newArray, 0, array.length);
        array = newArray;

//        T[] newArray = (T[]) new Number[array.length * GROW_CAPACITY];
//        System.arraycopy(array, 0, newArray, 0, size);
//        array = newArray;
    }
    public void add(Object element) {
        if (isFull()) {
            resize();
        }
        array[size++] = element;
    }
    private boolean isFull() {
        return size == array.length;
    }

    public boolean remove(Object object) {
        for (int i = 0; i < size; i++) {
            if (object.equals(array[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public Object remove(int index) {
        Object removedElement = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
        return removedElement;
    }

    public <R extends Number> MyList<R> map(Function<T, R> f) {
        MyList<R> myList = new MyList<>();
        for (int i = 0; i < size; i++) {
            myList.add(f.apply(this.get(i)));
        }
        return myList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MyList<?> otherList = (MyList<?>) obj;
        if (size != otherList.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(otherList.array[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;
        for (int i = 0; i < size; i++) {
            result = 31 * result + array[i].hashCode();
        }
        return result;
    }
}
