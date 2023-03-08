package com.jones.goldenmonitor.model.param;

import com.jones.goldenmonitor.object.BaseObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value="位置类型参数")
public class PositionTypeParam extends BaseObject {
    @ApiParam(hidden = true)
    private Integer id;
    @ApiModelProperty(value="标题",name="title")
    private String title;
    @ApiModelProperty(value="图标",name="icon")
    private String icon;
    @ApiModelProperty(value="內容",name="detail")
    private String detail;
}

