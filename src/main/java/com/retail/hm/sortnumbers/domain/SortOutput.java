package com.retail.hm.sortnumbers.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SortOutput {

    private List<Integer> actualList;
    private List<Integer> sortedList;
    private long sortTime;
    private int shiftCount;
}
