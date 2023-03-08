package com.jones.goldenmonitor.model.param;

import com.jones.goldenmonitor.object.BaseObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@ApiModel(value="精彩瞬间参数")
public class IntentParam extends BaseObject {
    @ApiParam(hidden = true)
    private Integer id;
    @ApiModelProperty(value="精彩瞬间标题",name="name")
    private String title;
    @ApiModelProperty(value="精彩瞬间类型",name="type")
    private String type;
    @ApiModelProperty(value="精彩瞬间內容",name="content")
    private String content;
    @ApiModelProperty(value="是否华发路",name="isHuafa")
    private Integer isHuafa;
}

