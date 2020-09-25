package com.rajeevn.algorithms.sort.impl;

import com.rajeevn.algorithms.sort.ArraySorter;

/**
 * @see ArraySorter
 */
public abstract class AbstractArraySorter implements ArraySorter
{
    private int swapCount = 0;

    @Override
    public <T extends Comparable> void sort(T[] array)
    {
        sort(array, Comparable::compareTo);
    }

    protected void swap(Object[] array, int i, int j)
    {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        swapCount++;
    }

    public int getSwapsCount()
    {
        return swapCount;
    }
}
