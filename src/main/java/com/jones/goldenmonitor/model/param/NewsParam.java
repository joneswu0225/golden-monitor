package com.jones.goldenmonitor.model.param;

import com.jones.goldenmonitor.object.BaseObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
@Builder
@ApiModel(value="信息参数")
public class NewsParam extends BaseObject {
    @ApiParam(hidden = true)
    private Integer id;
    @ApiModelProperty(value="信息标题",name="name")
    private String title;
    @ApiModelProperty(value="信息类型",name="type")
    private String type;
    @ApiModelProperty(value="信息內容",name="content")
    private String content;
    @ApiModelProperty(value="是否华发路",name="isHuafa")
    private Integer isHuafa;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value="发布日期",name="publishTime")
    private String publishTime;
}

