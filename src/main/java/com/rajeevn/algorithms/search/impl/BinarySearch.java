package com.rajeevn.algorithms.search.impl;

import com.rajeevn.algorithms.search.ArraySearcher;

import java.util.Objects;

/**
 * Search index of given item in the sorted array.
 * Time complexity: Best case: O(1), Average case: O(log N)
 * Space complexity: O(1)
 * @see ArraySearcher
 */
public class BinarySearch implements ArraySearcher<Comparable>
{
    @Override
    public <T extends Comparable> int search(T[] array, T itemToSearch)
    {
        int low = 0;
        int high = array.length - 1;

        while (low <= high)
        {
            int mid = (high + low) / 2;
            if (Objects.equals(array[mid], itemToSearch))
            {
                return mid;
            }

            if ((itemToSearch != null && itemToSearch.compareTo(array[mid]) < 0)
                || (array[mid].compareTo(itemToSearch) > 0))
            {
                high = mid - 1;
            } else
            {
                low = mid + 1;
            }
        }

        return -1;
    }
}
