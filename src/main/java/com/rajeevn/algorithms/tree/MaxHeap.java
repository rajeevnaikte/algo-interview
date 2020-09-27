package com.rajeevn.algorithms.tree;

public class MaxHeap
{
    private int[] heap = new int[16];
    private int length;

    public void add(int item) throws Exception
    {
        ensureCapacity();
        heap[length] = item;
        length++;
        maxHeapifyUp(length - 1);
    }

    public int poll() throws Exception
    {
        if (length <= 0)
        {
            throw new Exception("Heap is empty.");
        }
        int rootValue = heap[0];
        heap[0] = heap[length - 1];
        length--;
        maxHeapifyDown(0);
        return rootValue;
    }

    public int peek()
    {
        return heap[0];
    }

    private void ensureCapacity() throws Exception
    {
        if (length == (Integer.MAX_VALUE - 1))
        {
            throw new Exception("Heap is full.");
        }
        if (length < heap.length)
        {
            return;
        }
        int newCapacity = length + length / 2;
        int[] newHeap = new int[newCapacity < 0 ? Integer.MAX_VALUE - 1 : newCapacity];
        System.arraycopy(heap, 0, newHeap, 0, length);
        heap = newHeap;
    }

    private void maxHeapifyUp(int nodeIndex)
    {
        int parentIndex = getParentIndex(nodeIndex);
        if (parentIndex < 0) return;
        if (heap[parentIndex] < heap[nodeIndex])
        {
            swap(parentIndex, nodeIndex);
            maxHeapifyUp(parentIndex);
        }
    }

    private void swap(int i, int j)
    {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private int getParentIndex(int nodeIndex)
    {
        return (nodeIndex - 1) / 2;
    }

    private void maxHeapifyDown(int nodeIndex)
    {
        int leftChildIndex = getLeftChildIndex(nodeIndex);
        if (leftChildIndex < 0 || leftChildIndex >= length) return;
        int rightChildIndex = getRightChildIndex(nodeIndex);

        int smallerChildIndex = (rightChildIndex < 0 || rightChildIndex >= length)
                || (heap[leftChildIndex] > heap[rightChildIndex]) ? leftChildIndex : rightChildIndex;
        if (heap[smallerChildIndex] > heap[nodeIndex])
        {
            swap(smallerChildIndex, nodeIndex);
            maxHeapifyDown(smallerChildIndex);
        }
    }

    private int getLeftChildIndex(int nodeIndex)
    {
        return 2 * nodeIndex + 1;
    }

    private int getRightChildIndex(int nodeIndex)
    {
        return 2 * nodeIndex + 2;
    }
}
