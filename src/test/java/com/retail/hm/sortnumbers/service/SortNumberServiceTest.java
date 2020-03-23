package com.retail.hm.sortnumbers.service;

import com.retail.hm.sortnumbers.domain.SortOutput;
import com.retail.hm.sortnumbers.repository.SortNumbersRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class SortNumberServiceTest {

    @Test
    public void checkSortedNumbers() {
        SortNumbersRepository sortNumbersRepository = mock(SortNumbersRepository.class);
        SortNumberService sortNumberService = new SortNumberService(sortNumbersRepository);
        List<Integer> actualList = new ArrayList<>();
        actualList.add(5);
        actualList.add(2);
        actualList.add(7);
        actualList.add(0);
        SortOutput sortOutput = sortNumberService.sortInputNumbers(actualList);

        assertEquals("Sorted output list matches the expected list", Arrays.asList(0,2,5,7), sortOutput.getSortedList());
        assertEquals("size of sorted list is four",4, sortOutput.getSortedList().size());
        assertEquals("positions shifted for sorting is four", 4, sortOutput.getShiftCount());
    }
}
