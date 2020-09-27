package com.rajeevn.algorithms.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MinHeapTest
{
    @Test
    public void addNew() throws Exception
    {
        MinHeap heap = new MinHeap();
        heap.add(2);
        heap.add(5);
        heap.add(1);
        heap.add(10);
        heap.add(3);

        assertEquals(1, heap.peek());
    }

    @Test
    public void poll() throws Exception
    {
        MinHeap heap = new MinHeap();
        heap.add(2);
        heap.add(5);
        assertEquals(2, heap.poll());
        heap.add(1);
        heap.add(10);
        heap.add(3);
        assertEquals(1, heap.poll());
        assertEquals(3, heap.poll());
        assertEquals(5, heap.poll());
        assertEquals(10, heap.poll());
    }

    @Test
    public void heapIsEmpty() throws Exception
    {
        MinHeap heap = new MinHeap();
        heap.add(2);
        heap.poll();

        assertThrows(Exception.class, () -> heap.poll());
    }
}
