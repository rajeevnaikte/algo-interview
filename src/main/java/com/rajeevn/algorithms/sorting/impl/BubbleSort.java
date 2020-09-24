package com.rajeevn.algorithms.sorting.impl;

import java.util.Comparator;
import java.util.Objects;

/**
 * Sort by moving larger item down.
 * Time complexity - Best case: O(N), Worst case: O(N^2)
 * Space complexity - 1
 * @see AbstractArraySorter
 */
public class BubbleSort extends AbstractArraySorter
{
    @Override
    public <T> void sort(T[] array, Comparator<T> comparator)
    {
        Objects.requireNonNull(comparator);

        if (array.length < 2)
        {
            return;
        }

        for (int i = 0; i < array.length; i++)
        {
            boolean swapped = false;

            for (int j = 0; j < array.length - i - 1; j++)
            {
                if (comparator.compare(array[j], array[j + 1]) > 0)
                {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }

            if (!swapped)
            {
                break;
            }
        }
    }
}
