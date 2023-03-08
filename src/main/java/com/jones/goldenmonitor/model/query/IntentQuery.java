package com.jones.goldenmonitor.model.query;

import com.jones.goldenmonitor.model.Query;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@ApiModel(value="精彩瞬间查询参数")
@Builder
public class IntentQuery extends Query {
    @ApiModelProperty(value="类型",name="type")
    private String type;
    @ApiModelProperty(value="标题",name="title")
    private String title;
    @ApiModelProperty(value="是否华发路",name="isHuafa")
    private Integer isHuafa;
}
