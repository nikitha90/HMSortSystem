package com.retail.hm.sortnumbers.service;

import org.springframework.stereotype.Component;

/**
 * This is a functional Interface to sort.
 * No separate classes need to be created to implement the method,
 * just use lambda expression and call the sort method.
 */
@FunctionalInterface
@Component
public interface HMSortInterface {
    int sort(int[] inputArray);
}
