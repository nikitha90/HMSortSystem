package com.retail.hm.sortnumbers.controller;

import com.retail.hm.sortnumbers.domain.SortOutput;
import com.retail.hm.sortnumbers.service.SortNumberService;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SortNumbersControllerTest {

    @Test
    public void checkForSortingWithCorrectValues() {

        SortNumberService sortNumberService = mock(SortNumberService.class);
        SortNumbersController sortNumbersController = new SortNumbersController(sortNumberService);
        SortOutput sortOutput = new SortOutput();

        when(sortNumberService.sortInputNumbers(any())).thenReturn(sortOutput);
        ModelMap modelMap = new ModelMap();
        String result = sortNumbersController.sortInputNumbers(modelMap, "5,2,7,0");

        assertEquals("sortResult", result);
    }

    @Test
    public void checkForInputArrayWithAlphabetsInInput() {

        SortNumberService sortNumberService = mock(SortNumberService.class);
        SortNumbersController sortNumbersController = new SortNumbersController(sortNumberService);
        SortOutput sortOutput = new SortOutput();

        when(sortNumberService.sortInputNumbers(any())).thenReturn(sortOutput);
        ModelMap modelMap = new ModelMap();
        String result = sortNumbersController.sortInputNumbers(modelMap, "5,e,7,0");

        assertEquals("errors", result);
    }

    @Test
    public void checkForSortSystemWithMoreThan50Numbers() {

        SortNumberService sortNumberService = mock(SortNumberService.class);
        SortNumbersController sortNumbersController = new SortNumbersController(sortNumberService);
        SortOutput sortOutput = new SortOutput();

        when(sortNumberService.sortInputNumbers(any())).thenReturn(sortOutput);
        ModelMap modelMap = new ModelMap();
        String result = sortNumbersController.sortInputNumbers(modelMap, "51,50,49,48,47,46,45,44,43,42,41,40,39,38,37,36,35,34,33,32,31,30,29,28,27,26,25,24,23,22,21,20,19,18,17,16,15,14,12,11,10,9,8,7,6,5,4,3,2,1,0");

        assertEquals("errors", result);
    }

    @Test
    public void checkForSortSystemWithEmptyInput() {

        SortNumberService sortNumberService = mock(SortNumberService.class);
        SortNumbersController sortNumbersController = new SortNumbersController(sortNumberService);
        SortOutput sortOutput = new SortOutput();

        when(sortNumberService.sortInputNumbers(any())).thenReturn(sortOutput);
        ModelMap modelMap = new ModelMap();
        String result = sortNumbersController.sortInputNumbers(modelMap, "");

        assertEquals("errors", result);
    }

    @Test
    public void checkForSortSystemWithInvalidSeparator() {

        SortNumberService sortNumberService = mock(SortNumberService.class);
        SortNumbersController sortNumbersController = new SortNumbersController(sortNumberService);
        SortOutput sortOutput = new SortOutput();

        when(sortNumberService.sortInputNumbers(any())).thenReturn(sortOutput);
        ModelMap modelMap = new ModelMap();
        String result = sortNumbersController.sortInputNumbers(modelMap, "5:2,7,0");

        assertEquals("errors", result);
    }
}
