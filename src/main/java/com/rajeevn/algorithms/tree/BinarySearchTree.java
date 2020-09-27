package com.rajeevn.algorithms.tree;

import java.util.Objects;

/**
 * Binary search tree to search an item in a list of items.
 * Time complexity for find: O(log N)
 * @param <T> data type of items (must be a Comparable object)
 */
public class BinarySearchTree<T extends Comparable<T>>
{
    private final T value;
    private BinarySearchTree<T> left;
    private BinarySearchTree<T> right;

    public BinarySearchTree(T nodeValue)
    {
        value = nodeValue;
    }

    public void add(T newItem)
    {
        if (value.compareTo(newItem) > 0)
        {
            if (left != null)
            {
                left.add(newItem);
            } else
            {
                left = new BinarySearchTree<>(newItem);
            }
        } else
        {
            if (right != null)
            {
                right.add(newItem);
            } else
            {
                right = new BinarySearchTree<>(newItem);
            }
        }
    }

    public boolean contains(T valueToFind)
    {
        return (
                Objects.equals(value, valueToFind)
                        || (
                        value != null && value.compareTo(valueToFind) > 0
                                ? (left != null && left.contains(valueToFind))
                                : (right != null && right.contains(valueToFind))
                )
        );
    }
}
