package com.rajeevn.algorithms.search.impl;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LinearSearchTest
{
    @Test
    public void searchExisting()
    {
        int index = new LinearSearch().search(new Integer[]{0, 1, 4}, 1);

        assertEquals(1, index);
    }

    @Test
    public void searchNonExisting()
    {
        int index = new LinearSearch().search(new Integer[]{0, 1, 4}, 8);

        assertEquals(-1, index);
    }

    @Test
    public void searchItemIsFirstItemOfArray()
    {
        int index = new LinearSearch().search(new Integer[]{0, 1, 4}, 0);

        assertEquals(0, index);
    }

    @Test
    public void searchItemIsLastItemOfArray()
    {
        int index = new LinearSearch().search(new Integer[]{0, 1, 4}, 4);

        assertEquals(2, index);
    }

    @Test
    public void searchInUnsorted()
    {
        int index = new LinearSearch().search(new Integer[]{0, 8, 4, 19, 1}, 8);

        assertEquals(1, index);
    }
}
