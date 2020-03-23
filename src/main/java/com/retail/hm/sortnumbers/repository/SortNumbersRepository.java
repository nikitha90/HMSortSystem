package com.retail.hm.sortnumbers.repository;

import com.retail.hm.sortnumbers.domain.SortNumbers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface extends jpa repository and provides methods for crud operation
 */
@Repository
public interface SortNumbersRepository extends JpaRepository<SortNumbers, String> {

}
