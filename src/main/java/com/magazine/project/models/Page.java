package com.magazine.project.models;

import com.magazine.project.entity.Magazine;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    private List<Magazine> magazineList;
    private int currentPage;
    private int maxPage;
}
