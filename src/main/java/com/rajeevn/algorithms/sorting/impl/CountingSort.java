package com.rajeevn.algorithms.sorting.impl;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Non-comparison sorting of integers by counting frequency.
 * Time complexity - O(N+K), where K is range of number
 * Space complexity - O(N+K), where K is range of number
 * @see AbstractArraySorter
 */
public class CountingSort extends AbstractArraySorter
{
    @Override
    public <T extends Comparable<T>> void sort(T[] array)
    {
        if (array instanceof Integer[])
        {
            if (array.length < 2)
            {
                return;
            }

            // check if all integers are positive
            if (Arrays.stream(array).anyMatch(item -> (Integer) item < 0))
            {
                throw new RuntimeException("Only non negative numbers can be sorted with counting sort technique.");
            }

            // create map with frequency
            Map<Integer, Integer> itemCounts = Arrays.stream((Integer[]) array)
                    .collect(Collectors.groupingBy(item -> item, HashMap::new, Collectors.summingInt(e -> 1)));

            // get max number
            Integer maxNumber = Arrays.stream((Integer[]) array).max(Integer::compareTo).get();

            // sum from previous available number
            Integer sum = 0;
            for (int i = 0; i <= maxNumber; i++)
            {
                sum += itemCounts.getOrDefault(i, 0);
                if (itemCounts.containsKey(i))
                {
                    itemCounts.put(i, sum);
                }
            }

            // iterate original array and put in appropriate index
            Integer[] sorted = new Integer[array.length];
            for (Integer item : (Integer[]) array)
            {
                int index = itemCounts.get(item) - 1;
                sorted[index] = item;
                itemCounts.put(item, index);
            }

            System.arraycopy(sorted, 0, array, 0, array.length);
        }
        else
        {
            throw new RuntimeException("Radix sort can only be applied to integer array.");
        }
    }

    @Override
    public <T> void sort(T[] array, Comparator<T> comparator)
    {
        throw new UnsupportedOperationException();
    }
}
