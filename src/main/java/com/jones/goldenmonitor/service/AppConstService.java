package com.jones.goldenmonitor.service;

import com.jones.goldenmonitor.model.param.AppConstParam;
import com.jones.goldenmonitor.object.BaseResponse;
import com.jones.goldenmonitor.repository.AppConstMapper;
import com.jones.goldenmonitor.repository.BaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppConstService extends BaseService{

    @Autowired
    private AppConstMapper mapper;

    @Override
    public BaseMapper getMapper(){
        return this.mapper;
    }

    public BaseResponse updateAppConstSeq(AppConstParam param){
        mapper.updateAppConstSeq(param);
        return BaseResponse.builder().build();
    }


}

