package src;

import java.util.AbstractList;
import java.util.Comparator;
import java.util.Objects;

/**
 * CustomArrayList<E> is a custom implementation for ArrayList
 * Following methods are implemented: add item, add item to specific index,
 * remove item, remove item by index, get by index, set element to specific index.
 * QuickSort method is implemented as well
 *
 */
public class CustomArrayList<E> extends AbstractList<E> {
    private static final int DEFAULT_CAPACITY = 10;

    private int size = 0;
    private E[] array;

    CustomArrayList() {
       this.array = (E[]) new Object[DEFAULT_CAPACITY];
    }

    CustomArrayList(int capacity) {
        this.array = (E[]) new Object[capacity];
    }

    /**
     * Get element by index
     * @param index
     * @return element
     */
    @Override
    public E get(int index) {
        return (E) array[index];
    }

    /**
     * Returns current size of the List
     * @return size
     */
    @Override
    public int size() {
        return this.size;
    }

    private void resize(int newLength) {
        E[] newArray = (E[]) new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, size);
        this.array = newArray;
    }

    /**
     * Add element to the end of the list
     * @param item
     * @return true if method finished successful
     */
    @Override
    public boolean add(E item) {
        if (size == array.length - 1)
            resize(array.length * 2);
        this.array[size++] = item;
        return true;
    }

    /**
     * Add element to specific index
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        if (size == array.length - 1) {
            resize(array.length * 2);
        }
        System.arraycopy(array, index, array, index + 1, size - index + 1);
        array[index] = element;
        size++;
    }

    /**
     * Remove specific element
     * @param item
     * @return true if method finished successful
     */
    @Override
    public boolean remove(Object item) {
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i].equals(item)) {
                System.arraycopy(array, i + 1, array, i, size - 1);
                size -= 1;
                break;
            }
        }
        return true;
    }

    /**
     * Remove element by it's index
     * @param index
     * @return element that was removed
     */
    public E remove(int index) {

        Objects.checkIndex(index, size);
        E oldValue = (E) array[index];
            System.arraycopy(array, index + 1, array, index, size - 1);
            size -= 1;

        return oldValue;
    }

    /**
     * Set element to specific index in the list
     * @param index
     * @param element
     * @return old value that was in that index previously
     */
    @Override
    public E set(int index, E element) {
        Objects.checkIndex(index, size);
        E oldValue = (E) this.array[index];
        this.array[index] = element;
        return oldValue;
    }

    /**
     * Sorts custom list using comparator
     * @param comparator
     */
    public void quickSort(Comparator<? super E> comparator) {
        if(size == 0) return;
        sort(0, size - 1, comparator);
    }

    private void sort(int begin, int end, Comparator<? super E> comparator) {

        if(begin < end) {
            int wall = partition(begin, end, comparator);
            sort(begin, wall - 1, comparator);
            sort(wall + 1, end, comparator);
        }
    }

    private int partition(int begin, int end, Comparator<? super E> comparator) {
        E pivot = array[end];
        int i = begin;
        E tmp;

        for(int j = begin; j < end; j++) {
            if(comparator.compare(array[j], pivot) < 0) {
                tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
                i++;
            }
        }
        tmp = array[i];
        array[i] = array[end];
        array[end] = tmp;
        return i;
    }
}