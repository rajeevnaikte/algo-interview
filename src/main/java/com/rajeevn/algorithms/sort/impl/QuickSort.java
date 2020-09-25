package com.rajeevn.algorithms.sort.impl;

import java.util.Objects;
import java.util.Comparator;

/**
 * Sort by divide and conquer with a pivot index strategy.
 * Time complexity - Best case: O(N lon N), Worst case: O(N^2)
 * Space complexity - O(log N)
 * @see AbstractArraySorter
 */
public class QuickSort extends AbstractArraySorter
{
    /**
     * Lambda function interface to find a pivot index for the quick-sort algorithm.
     */
    private interface PivotIndexStrategy
    {
        int get(Object[] array, int low, int high);
    }

    private PivotIndexStrategy pivotIndexStrategy = (array, low, high) -> (low + high) / 2;

    /**
     * Logic as a lambda function to find a pivot index for the quick-sort algorithm.
     * @param pivotIndexStrategy
     * @return
     */
    public QuickSort withPivotIndexStrategy(PivotIndexStrategy pivotIndexStrategy)
    {
        this.pivotIndexStrategy = pivotIndexStrategy;
        return this;
    }

    @Override
    public <T> void sort(T[] array, Comparator<T> comparator)
    {
        Objects.requireNonNull(comparator);

        if (array.length < 2)
        {
            return;
        }

        quickSort(array, 0, array.length - 1, comparator);
    }

    private <T> void quickSort(T[] array, int left, int right, Comparator<T> comparator)
    {
        if (left >= right) return;

        int rightPartitionStartIdx = partition(array, left, right, comparator);
        quickSort(array, left, rightPartitionStartIdx - 1, comparator);
        quickSort(array, rightPartitionStartIdx, right, comparator);
    }

    private <T> int partition(T[] array, int left, int right, Comparator<T> comparator)
    {
        int pivot = pivotIndexStrategy.get(array, left, right);
        while (left <= right)
        {
            while (comparator.compare(array[left], array[pivot]) < 0)
            {
                left++;
            }
            while (comparator.compare(array[right], array[pivot]) > 0)
            {
                right--;
            }
            if (left <= right)
            {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
}
