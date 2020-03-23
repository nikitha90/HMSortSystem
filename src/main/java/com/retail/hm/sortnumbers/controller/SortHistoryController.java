package com.retail.hm.sortnumbers.controller;

import com.retail.hm.sortnumbers.domain.SortNumbers;
import com.retail.hm.sortnumbers.service.SortHistoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.retail.hm.sortnumbers.constants.SortConstants.SORT_HISTORY_LIST;
import static com.retail.hm.sortnumbers.constants.SortConstants.VIEW_HISTORY;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * This is the controller class to view the history of sort results
 */
@Controller
public class SortHistoryController {

    private final static Logger log = LoggerFactory.getLogger(SortHistoryController.class);

    private final SortHistoryService sortHistoryService;

    @Autowired
    SortHistoryController(SortHistoryService sortHistoryService) {
        this.sortHistoryService = sortHistoryService;
    }

    /**
     * This is the get method that retrieves the sorted list history
     * @param modelMap
     * @return string
     */
    @RequestMapping(value = "/hm/viewHistory", method = GET)
    public String getSortHistory(ModelMap modelMap) {
        log.info("Started to retrieve Sort history..");
        List<SortNumbers> sortNumbersList = sortHistoryService.getSortHistory();
        log.info("Sort history completed with retrieval count {}", sortNumbersList.size());
        modelMap.put(SORT_HISTORY_LIST, sortNumbersList);
        return VIEW_HISTORY;
    }
}
