package com.jones.goldenmonitor.model;

import com.jones.goldenmonitor.object.BaseObject;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class AppConst extends BaseObject {
    public static final String APP_DEFAULT_PREFIX = "APP_DEFAULT_";
    private String name;
    private String value;
    private String detail;
    private Integer seq;
    private Object rel;
    private List<String> values;
}

