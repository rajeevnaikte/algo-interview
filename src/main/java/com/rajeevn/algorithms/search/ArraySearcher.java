package com.rajeevn.algorithms.search;

/**
 * Interface of search logic to search an item in given array.
 */
public interface ArraySearcher<B>
{
    /**
     * Search the item in given array and returns the index where the array is in.
     * Returns -1 if not found.
     * @param array
     * @param itemToSearch
     * @param <T>
     * @return
     */
    <T extends B> int search(T[] array, T itemToSearch);
}
