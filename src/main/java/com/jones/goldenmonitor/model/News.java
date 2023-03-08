package com.jones.goldenmonitor.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class News {
    private Integer id;
    private String title;
    private String type;
    private String content;
    private Integer isHuafa;
    private String publishTime;
}

