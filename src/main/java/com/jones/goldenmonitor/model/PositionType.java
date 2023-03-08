package com.jones.goldenmonitor.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PositionType {
    private Integer id;
    private String title;
    private String icon;
    private String detail;
}

