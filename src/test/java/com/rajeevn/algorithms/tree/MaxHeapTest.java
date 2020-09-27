package com.rajeevn.algorithms.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MaxHeapTest
{
    @Test
    public void addNew() throws Exception
    {
        MaxHeap heap = new MaxHeap();
        heap.add(2);
        heap.add(5);
        heap.add(1);
        heap.add(10);
        heap.add(3);

        assertEquals(10, heap.peek());
    }

    @Test
    public void poll() throws Exception
    {
        MaxHeap heap = new MaxHeap();
        heap.add(2);
        heap.add(5);
        assertEquals(5, heap.poll());
        heap.add(1);
        heap.add(10);
        heap.add(3);
        assertEquals(10, heap.poll());
        assertEquals(3, heap.poll());
        assertEquals(2, heap.poll());
        assertEquals(1, heap.poll());
    }

    @Test
    public void heapIsEmpty() throws Exception
    {
        MaxHeap heap = new MaxHeap();
        heap.add(2);
        heap.poll();

        assertThrows(Exception.class, () -> heap.poll());
    }
}
