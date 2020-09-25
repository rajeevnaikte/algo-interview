package com.rajeevn.algorithms.sort.impl;

import java.util.Objects;
import java.util.Comparator;

/**
 * Sorting with divide and conquer and merge sorted parts.
 * Time complexity - All case: O(N log N)
 * Space complexity - N
 * @see AbstractArraySorter
 */
public class MergeSort extends AbstractArraySorter
{
    @Override
    public <T> void sort(T[] array, Comparator<T> comparator)
    {
        Objects.requireNonNull(comparator);

        if (array.length < 2)
        {
            return;
        }

        mergeSort(array, 0, array.length - 1, comparator);
    }

    private <T> void mergeSort(T[] array, int start, int end, Comparator<T> comparator)
    {
        if (start >= end) return;

        int mid = (start + end) / 2;
        mergeSort(array, start, mid, comparator);
        mergeSort(array, mid + 1, end, comparator);
        mergeHalves(array, start, end, comparator);
    }

    private <T> void mergeHalves(T[] array, int start, int end, Comparator<T> comparator)
    {
        int leftEnd = (start + end) / 2;
        int rightStart = leftEnd + 1;

        int left = start;
        int right = rightStart;
        Object[] temp = new Object[end - start + 1];
        int indexForTemp = 0;

        while (left <= leftEnd && right <= end)
        {
            if (comparator.compare(array[left], array[right]) <= 0)
            {
                temp[indexForTemp] = array[left];
                left++;
            }
            else
            {
                temp[indexForTemp] = array[right];
                right++;
            }
            indexForTemp++;
        }

        System.arraycopy(array, left, temp, indexForTemp, leftEnd - left + 1);
        System.arraycopy(array, right, temp, indexForTemp, end - right + 1);
        System.arraycopy(temp, 0, array, start, temp.length);
    }
}
