package com.rajeevn.algorithms.sorting.impl;

import java.util.Objects;
import java.util.Comparator;

/**
 * Sort by inserting value at appropriate position.
 * Time complexity - Best case: O(N), Worst case: O(N^2)
 * Space complexity - 1
 * @see AbstractArraySorter
 */
public class InsertionSort extends AbstractArraySorter
{
    @Override
    public <T> void sort(T[] array, Comparator<T> comparator)
    {
        Objects.requireNonNull(comparator);

        if (array.length < 2)
        {
            return;
        }

        for (int i = 1; i < array.length; i++)
        {
            int j = i;
            while (j > 0 && comparator.compare(array[j], array[j - 1]) < 0)
            {
                swap(array, j, j - 1);
                j--;
            }
        }
    }
}
