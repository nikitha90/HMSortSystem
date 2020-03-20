package com.retail.hm.sortnumbers.controller;

import com.retail.hm.sortnumbers.domain.SortOutput;
import com.retail.hm.sortnumbers.service.SortNumberService;
import com.retail.hm.sortnumbers.utils.SortValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.retail.hm.sortnumbers.constants.SortConstants.ACTUAL_LIST;
import static com.retail.hm.sortnumbers.constants.SortConstants.SORT_TIME;
import static com.retail.hm.sortnumbers.constants.SortConstants.POSTION_SHIFT;
import static com.retail.hm.sortnumbers.constants.SortConstants.SORTED_LIST;
import static com.retail.hm.sortnumbers.constants.SortConstants.SUCCESS;
import static com.retail.hm.sortnumbers.constants.SortConstants.ERROR;
import static com.retail.hm.sortnumbers.utils.SortValidator.createIntegerList;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@Controller
public class SortNumbersController {

    private static final Logger log = LoggerFactory.getLogger(SortNumbersController.class);

    private final SortNumberService sortNumberService;

    @Autowired
    SortNumbersController(SortNumberService sortNumberService)
    {
        this.sortNumberService = sortNumberService;
    }

    /**
     * This is the starting point of the application.
     * The page is displayed with input box to obtain the number sequence
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "index";
    }

    /**
     * This method sorts the given sequence of numbers and adds to the modelmap
     * @param model
     * @param inputNumbers
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.POST, produces = APPLICATION_JSON_VALUE)
    public String sortInputNumbers(ModelMap model, @RequestParam String inputNumbers) {
        boolean errorFlag = false;
        try {
            if (null != inputNumbers) {
                errorFlag = SortValidator.validateInput(inputNumbers);
                List<Integer> integerList = createIntegerList(inputNumbers);
                log.info("List of numbers provided by user for soring {}", integerList);
                SortOutput sortOutputValues = sortNumberService.sortInputNumbers(integerList);
                populateModelMap(model, sortOutputValues);
            }
        } catch (NumberFormatException ex) {
            errorFlag = true;
            log.error("Invalid input entered {}", ex.getMessage());
        } catch (Exception ex) {
            log.error("Exception occured while sorting {}", ex.getMessage());
        }
        if (errorFlag) {
            return ERROR;
        } else {
            return SUCCESS;
        }
    }

    private void populateModelMap(ModelMap model, SortOutput sortOutputValues) {
        model.put(ACTUAL_LIST, sortOutputValues.getActualList());
        model.put(SORT_TIME, sortOutputValues.getSortTime());
        model.put(SORTED_LIST, sortOutputValues.getSortedList());
        model.put(POSTION_SHIFT, sortOutputValues.getShiftCount());
    }
}
