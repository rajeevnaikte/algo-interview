package com.rajeevn.algorithms.sorting;

import java.util.Comparator;

/**
 * Interface of various sorting algorithms.
 */
public interface ArraySorter
{
    /**
     * Sort the given array with comparator of defined in the array element object.
     * i.e. the array elements need to be implementing {Comparable} interface.
     *
     * @param array
     */
    <T extends Comparable> void sort(T[] array);

    /**
     * Sort the given array with given comparator logic.
     *
     * @param array
     * @param comparator - lambda function, e.g. (a, b) -> a.compareTo(b)
     * @param <T>
     */
    <T> void sort(T[] array, Comparator<T> comparator);
}
