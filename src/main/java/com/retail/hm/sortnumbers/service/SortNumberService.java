package com.retail.hm.sortnumbers.service;

import com.retail.hm.sortnumbers.domain.SortNumbers;
import com.retail.hm.sortnumbers.domain.SortOutput;
import com.retail.hm.sortnumbers.repository.SortNumbersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.retail.hm.sortnumbers.utils.SortValidator.convertListToString;

/**
 * This is the service class that does the sorting logic
 */
@Service
public class SortNumberService {

    private static final Logger log = LoggerFactory.getLogger(SortNumberService.class);

    private final SortNumbersRepository sortNumbersRepository;

    @Autowired
    SortNumberService(SortNumbersRepository sortNumbersRepository) {
        this.sortNumbersRepository = sortNumbersRepository;
    }

    /**
     * This method does the sorting logic and updates the results in the bean
     *
     * @param inputIntegers
     * @return sortOutput
     */
    public SortOutput sortInputNumbers(List<Integer> inputIntegers) {
        SortOutput sortOutput = new SortOutput();
        long startTime = System.nanoTime();
        log.info("Sorting service started to Sort");
        int[] inputArray = inputIntegers.stream().mapToInt(Integer::intValue).toArray();
        sortOutput.setActualList(inputIntegers);
        //lambda expression that implements the functional interface of sort method.
        HMSortInterface hmSortInterface = inputArray1 -> {
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
        int swappedCount = hmSortInterface.sort(inputArray);
        long endTime = System.nanoTime();
        log.info("Sort service completed sorting");
        sortOutput.setSortTime(TimeUnit.NANOSECONDS.toMillis(endTime - startTime));
        log.info("Time taken to sort {} ms", sortOutput.getSortTime());
        log.info("Total numbers of positions that are shifted {}", swappedCount);
        sortOutput.setShiftCount(swappedCount);
        sortOutput.setSortedList(populateSortedList(inputArray));
        sortNumbersRepository.save(populateValuesForDB(sortOutput));
        return sortOutput;
    }

    private SortNumbers populateValuesForDB(SortOutput sortOutput) {
        SortNumbers sortNumbers = new SortNumbers();
        sortNumbers.setInputList(convertListToString(sortOutput.getActualList()));
        sortNumbers.setSortedList(convertListToString(sortOutput.getSortedList()));
        sortNumbers.setSortTime(sortOutput.getSortTime());
        sortNumbers.setShiftPositions(sortOutput.getShiftCount());
        return sortNumbers;
    }

    private List<Integer> populateSortedList(int[] sortArray){
        List<Integer> sortedList = new ArrayList<>();
        for (int value : sortArray) {
            sortedList.add(value);
        }
        log.info("The final sorted list is {}", sortedList);
        return sortedList;
    }
}
