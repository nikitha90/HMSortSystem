package com.retail.hm.sortnumbers.sortinterface;

/**
 * This is a functional Interface to sort.
 * No separate classes need to be created to implement the method,
 * just use lambda expression and call the sort method.
 */
@FunctionalInterface
public interface HMSortInterface {
        int sort(int[] inputArray);
}
