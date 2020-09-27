package com.rajeevn.algorithms.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BinarySearchTreeTest
{
    @Test
    public void addNew()
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(1);
        bst.add(2);
        bst.add(5);
        bst.add(1);
        bst.add(10);
        bst.add(3);
    }

    @Test
    public void contains() throws Exception
    {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(1);
        bst.add(2);
        bst.add(5);

        assertEquals(true, bst.contains(5));
        assertEquals(false, bst.contains(10));

        bst.add(1);
        bst.add(10);
        bst.add(3);

        assertEquals(true, bst.contains(10));
        assertEquals(false, bst.contains(11));
    }
}
