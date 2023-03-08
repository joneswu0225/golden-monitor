package com.jones.goldenmonitor.model.query;

import com.jones.goldenmonitor.model.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ApiModel(value="位置查询参数")
@Builder
public class PositionQuery extends Query {
    @ApiModelProperty(value="类型",name="type")
    private String type;
    @ApiModelProperty(value="标题",name="title")
    private String title;
    @ApiModelProperty(value="是否华发路",name="isHuafa")
    private Integer isHuafa;
}
