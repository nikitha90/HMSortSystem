package com.retail.hm.sortnumbers.controller;

import com.retail.hm.sortnumbers.domain.SortNumbers;
import com.retail.hm.sortnumbers.service.SortHistoryService;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SortHistoryControllerTest {

    @Test
    public void testSortHistory() {
        SortHistoryService sortHistoryService = mock(SortHistoryService.class);
        SortHistoryController sortHistoryController = new SortHistoryController(sortHistoryService);
        List<SortNumbers> sortedList = new ArrayList<>();

        when(sortHistoryService.getSortHistory()).thenReturn(sortedList);
        ModelMap modelMap = new ModelMap();
        String result = sortHistoryController.getSortHistory(modelMap);

        assertEquals("viewHistory", result);
    }
}
