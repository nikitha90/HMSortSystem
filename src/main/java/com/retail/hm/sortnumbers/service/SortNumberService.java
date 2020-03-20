package com.retail.hm.sortnumbers.service;

import com.retail.hm.sortnumbers.domain.SortOutput;
import com.retail.hm.sortnumbers.sortinterface.HMSortInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the service class that does the sorting logic
 */
@Service
public class SortNumberService {

    private static final Logger log = LoggerFactory.getLogger(SortNumberService.class);

    /**
     * This method does the sorting logic and updates the results in the bean
     *
     * @param inputIntegers
     * @return sortOutput
     */
    public SortOutput sortInputNumbers(List<Integer> inputIntegers) {
        SortOutput sortOutput = new SortOutput();
        sortOutput.setActualList(inputIntegers);
        long startTime = System.nanoTime();
        log.info("Sorting service started to Sort");
        int[] inputArray = inputIntegers.stream().mapToInt(Integer::intValue).toArray();
        //lambda expression that implements the functional interface of sort method.
        HMSortInterface sortInterface = (int[] inputArray1) -> {
            int swappedCount = 0;
            for (int i = 0; i < inputArray1.length; i++) {
                for (int j = 1; j < inputArray1.length - i; j++) {
                    if (inputArray1[j - 1] > inputArray1[j]) {
                        swappedCount++;
                        Integer temp = inputArray1[j - 1];
                        inputArray1[j - 1] = inputArray1[j];
                        inputArray1[j] = temp;
                    }
                }
            }
            return swappedCount;
        };
        int swappedCount = sortInterface.sort(inputArray);
        long endTime = System.nanoTime();
        log.info("Sort service completed sorting");
        long timeTaken = endTime - startTime;
        log.info("Time taken to sort {} ms", timeTaken / 1000000);
        sortOutput.setSortTime(timeTaken / 1000000);
        log.info("Total numbers of positions that are shifted {}", swappedCount);
        sortOutput.setShiftCount(swappedCount);
        List<Integer> sortedList = new ArrayList<>();
        for (int value : inputArray) {
            sortedList.add(value);
        }
        log.info("The final sorted list is {}", sortedList);
        sortOutput.setSortedList(sortedList);
        return sortOutput;
    }
}
