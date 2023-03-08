package com.jones.goldenmonitor.controller;


import com.jones.goldenmonitor.model.param.NewsParam;
import com.jones.goldenmonitor.model.query.NewsQuery;
import com.jones.goldenmonitor.object.BaseResponse;
import com.jones.goldenmonitor.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
@Slf4j
@Api(value = "信息动态", tags = {"信息动态"})
public class NewsController extends BaseController {

    @Autowired
    private NewsService service;

    @ApiOperation(value = "新信息动态列表", notes = "信息动态列表")
    @GetMapping("")
    public BaseResponse list(@ApiParam NewsQuery query) {
        return service.findByPage(query);
    }

    @ApiOperation(value = "新增信息动态", notes = "新增信息动态")
    @PostMapping("")
    public BaseResponse add(@RequestBody @ApiParam(required=true) NewsParam param) {
        return service.add(param);
    }

    @ApiOperation(value = "信息动态详情", notes = "信息动态详情")
    @GetMapping("{newsId}")
    public BaseResponse findOne(@PathVariable Integer newsId) {
        return service.findById(newsId);
    }

    @ApiOperation(value = "更新信息动态", notes = "更新信息动态")
    @PutMapping("{newsId}")
    public BaseResponse update(
            @PathVariable Integer newsId,
            @RequestBody @ApiParam(required=true) NewsParam param) {
        param.setId(newsId);
        return service.update(param);
    }

    @ApiOperation(value = "删除信息动态", notes = "后台调用")
    @DeleteMapping("{newsId}")
    public BaseResponse delete(@PathVariable @ApiParam(required=true) Integer newsId) {
        return service.delete(newsId);
    }


}
