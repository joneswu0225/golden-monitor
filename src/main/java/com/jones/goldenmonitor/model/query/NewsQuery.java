package com.jones.goldenmonitor.model.query;

import com.jones.goldenmonitor.model.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@ApiModel(value="信息查询参数")
@Builder
public class NewsQuery extends Query {
    @ApiModelProperty(value="类型",name="type")
    private String type;
    @ApiModelProperty(value="标题",name="title")
    private String title;
    @ApiModelProperty(value="是否华发路",name="isHuafa")
    private Integer isHuafa;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value="开始日期",name="startDate")
    private String startDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value="结束日期",name="endDate")
    private String endDate;
}
