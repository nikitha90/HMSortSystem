package com.retail.hm.sortnumbers.service;


import com.retail.hm.sortnumbers.domain.SortNumbers;
import com.retail.hm.sortnumbers.repository.SortNumbersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SortHistoryService {

    private static final Logger log = LoggerFactory.getLogger(SortHistoryService.class);

    private final SortNumbersRepository sortNumbersRepository;

    @Autowired
    SortHistoryService(SortNumbersRepository sortNumbersRepository) {
        this.sortNumbersRepository = sortNumbersRepository;
    }

    /**
     * This method calls the repository and gets the sort history results
     * @return List<SortNumbers>
     */
    public List<SortNumbers> getSortHistory() {
        log.info("Inside sort history service to retrieve History of sort");
        return sortNumbersRepository.findAll();
    }
}
