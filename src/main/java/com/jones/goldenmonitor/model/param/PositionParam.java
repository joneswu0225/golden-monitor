package com.jones.goldenmonitor.model.param;

import com.jones.goldenmonitor.object.BaseObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value="位置参数")
public class PositionParam extends BaseObject {
    @ApiParam(hidden = true)
    private Integer id;
    @ApiModelProperty(value="经度",name="ath")
    private String ath;
    @ApiModelProperty(value="纬度",name="atv")
    private String atv;
    @ApiModelProperty(value="标题",name="title")
    private String title;
    @ApiModelProperty(value="类型",name="type")
    private String type;
    @ApiModelProperty(value="是否华发路",name="isHuafa")
    private Integer isHuafa;
}

