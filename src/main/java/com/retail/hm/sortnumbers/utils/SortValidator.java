package com.retail.hm.sortnumbers.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.retail.hm.sortnumbers.constants.SortConstants.COMMA;

/**
 * This is an utility class that validates the input sequence
 */
public final class SortValidator {

    public static final Logger log = LoggerFactory.getLogger(SortValidator.class);

    /**
     * This is an utility method that validates the input
     * It checks if the input contains more than 50 numbers and returns error as true
     *
     * @param inputNumber
     * @return
     */
    public static boolean validateInput(String inputNumber) {
        String[] splitNumbers = inputNumber.trim().split(COMMA);
        return splitNumbers.length > 50;
    }

    /**
     * This method gets the string as input and converts into integer list
     * returns number format exception if invalid values are given
     *
     * @param inputNumber
     * @return integerList
     */
    public static List<Integer> createIntegerList(String inputNumber) {
        List<Integer> integerList = new ArrayList<>();
        String[] splitNumbers = inputNumber.trim().split(COMMA);
        for (String it : splitNumbers) {
            integerList.add(Integer.parseInt(it));
        }
        return integerList;
    }

    /**
     * This method converts list into String using comma as separator
     * @param listValues
     * @return string value
     */
    public static String convertListToString(List<Integer> listValues) {
        return listValues.stream().map(String::valueOf).collect(Collectors.joining(COMMA));
    }

}
