package com.rajeevn.algorithms.sort.impl;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class QuickSortTest
{
    private static final Logger LOGGER = LoggerFactory.getLogger(QuickSortTest.class);

    private static void sortAndVerify(Integer[] arr, Integer[] expected) {
        AbstractArraySorter sorter = new QuickSort();

        sorter.sort(arr);
        assertArrayEquals(arr, expected);
        LOGGER.info("Swaps count {}", sorter.getSwapsCount());
    }

    @Test
    public void testUnordered() {
        sortAndVerify(new Integer[]{1, 7, 3, 10, 4}, new Integer[]{1, 3, 4, 7, 10});
    }

    @Test
    public void testAlreadyOrdered() {
        sortAndVerify(new Integer[]{1, 2, 3, 4, 19}, new Integer[]{1, 2, 3, 4, 19});
    }

    @Test
    public void testReverseOrdered() {
        sortAndVerify(new Integer[]{19, 4, 3, 2, 1}, new Integer[]{1, 2, 3, 4, 19});
    }
}
