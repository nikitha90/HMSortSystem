package com.retail.hm.sortnumbers.service;

import com.retail.hm.sortnumbers.domain.SortOutput;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SortNumberServiceTest {

    @Test
    public void checkSortedNumbers() {
        SortNumberService sortNumberService = new SortNumberService();
        List<Integer> actualList = new ArrayList<>();
        actualList.add(5);
        actualList.add(2);
        actualList.add(7);
        actualList.add(0);
        SortOutput sortOutput = sortNumberService.sortInputNumbers(actualList);
        assertEquals(4, sortOutput.getSortedList().size());
        assertEquals(4, sortOutput.getShiftCount());
    }
}
