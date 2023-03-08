package com.jones.goldenmonitor.controller;


import com.jones.goldenmonitor.model.Query;
import com.jones.goldenmonitor.model.param.PositionTypeParam;
import com.jones.goldenmonitor.object.BaseResponse;
import com.jones.goldenmonitor.service.PositionTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/positionType")
@Slf4j
@Api(value = "位置类型", tags = {"位置类型"})
public class PositionTypeController extends BaseController {

    @Autowired
    private PositionTypeService service;

    @ApiOperation(value = "新位置类型列表", notes = "位置类型列表")
    @GetMapping("")
    public BaseResponse list(@ApiParam Query query) {
        return service.findByPage(query);
    }

    @ApiOperation(value = "新增位置类型", notes = "新增位置类型")
    @PostMapping("")
    public BaseResponse add(@RequestBody @ApiParam(required=true) PositionTypeParam param) {
        return service.add(param);
    }

    @ApiOperation(value = "位置类型详情", notes = "位置类型详情")
    @GetMapping("{positionTypeId}")
    public BaseResponse findOne(@PathVariable Integer positionTypeId) {
        return service.findById(positionTypeId);
    }

    @ApiOperation(value = "更新位置类型", notes = "更新位置类型")
    @PutMapping("{positionTypeId}")
    public BaseResponse update(
            @PathVariable Integer positionTypeId,
            @RequestBody @ApiParam(required=true) PositionTypeParam param) {
        param.setId(positionTypeId);
        return service.update(param);
    }

    @ApiOperation(value = "删除位置类型", notes = "后台调用")
    @DeleteMapping("{positionTypeId}")
    public BaseResponse delete(@PathVariable @ApiParam(required=true) Integer positionTypeId) {
        return service.delete(positionTypeId);
    }


}
