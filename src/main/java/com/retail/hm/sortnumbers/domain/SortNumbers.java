package com.retail.hm.sortnumbers.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hmSortTable")
public class SortNumbers {

    @Id
    @GeneratedValue(strategy = AUTO)
    private int id;

    @Column(name = "input_list")
    private String inputList;

    @Column(name = "sorted_list")
    private String sortedList;

    @Column(name = "sort_time")
    private long sortTime;

    @Column(name = "shift_positions")
    private int shiftPositions;
}
