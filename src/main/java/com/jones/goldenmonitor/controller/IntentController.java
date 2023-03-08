package com.jones.goldenmonitor.controller;


import com.jones.goldenmonitor.model.param.IntentParam;
import com.jones.goldenmonitor.model.query.IntentQuery;
import com.jones.goldenmonitor.object.BaseResponse;
import com.jones.goldenmonitor.service.IntentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/intent")
@Slf4j
@Api(value = "精彩瞬间", tags = {"精彩瞬间"})
public class IntentController extends BaseController {

    @Autowired
    private IntentService service;

    @ApiOperation(value = "新精彩瞬间列表", notes = "精彩瞬间列表")
    @GetMapping("")
    public BaseResponse list(@ApiParam IntentQuery query) {
        return service.findByPage(query);
    }

    @ApiOperation(value = "新增精彩瞬间", notes = "新增精彩瞬间")
    @PostMapping("")
    public BaseResponse add(@RequestBody @ApiParam(required=true) IntentParam param) {
        return service.add(param);
    }

    @ApiOperation(value = "精彩瞬间详情", notes = "精彩瞬间详情")
    @GetMapping("{intentId}")
    public BaseResponse findOne(@PathVariable Integer intentId) {
        return service.findById(intentId);
    }

    @ApiOperation(value = "更新精彩瞬间", notes = "更新精彩瞬间")
    @PutMapping("{intentId}")
    public BaseResponse update(
            @PathVariable Integer intentId,
            @RequestBody @ApiParam(required=true) IntentParam param) {
        param.setId(intentId);
        return service.update(param);
    }

    @ApiOperation(value = "删除精彩瞬间", notes = "后台调用")
    @DeleteMapping("{intentId}")
    public BaseResponse delete(@PathVariable @ApiParam(required=true) Integer intentId) {
        return service.delete(intentId);
    }


}
