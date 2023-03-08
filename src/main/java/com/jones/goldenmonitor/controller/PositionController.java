package com.jones.goldenmonitor.controller;


import com.jones.goldenmonitor.model.param.PositionParam;
import com.jones.goldenmonitor.model.query.PositionQuery;
import com.jones.goldenmonitor.object.BaseResponse;
import com.jones.goldenmonitor.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/position")
@Slf4j
@Api(value = "位置", tags = {"位置"})
public class PositionController extends BaseController {

    @Autowired
    private PositionService service;

    @ApiOperation(value = "新位置列表", notes = "位置列表")
    @GetMapping("")
    public BaseResponse list(@ApiParam PositionQuery query) {
        return service.findByPage(query);
    }

    @ApiOperation(value = "新增位置", notes = "新增位置")
    @PostMapping("")
    public BaseResponse add(@RequestBody @ApiParam(required=true) PositionParam param) {
        return service.add(param);
    }

    @ApiOperation(value = "位置详情", notes = "位置详情")
    @GetMapping("{positionId}")
    public BaseResponse findOne(@PathVariable Integer positionId) {
        return service.findById(positionId);
    }

    @ApiOperation(value = "更新位置", notes = "更新位置")
    @PutMapping("{positionId}")
    public BaseResponse update(
            @PathVariable Integer positionId,
            @RequestBody @ApiParam(required=true) PositionParam param) {
        param.setId(positionId);
        return service.update(param);
    }

    @ApiOperation(value = "删除位置", notes = "后台调用")
    @DeleteMapping("{positionId}")
    public BaseResponse delete(@PathVariable @ApiParam(required=true) Integer positionId) {
        return service.delete(positionId);
    }


}
