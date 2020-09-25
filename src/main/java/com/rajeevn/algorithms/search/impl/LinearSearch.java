package com.rajeevn.algorithms.search.impl;

import com.rajeevn.algorithms.search.ArraySearcher;

import java.util.Objects;

/**
 * Search index of given item in the array.
 * Time complexity: O(N)
 * Space complexity: O(1)
 * @see ArraySearcher
 */
public class LinearSearch implements ArraySearcher<Object>
{
    @Override
    public <T> int search(T[] array, T itemToSearch)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (Objects.equals(array[i], itemToSearch))
            {
                return i;
            }
        }
        return -1;
    }
}
