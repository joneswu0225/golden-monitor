package com.jones.goldenmonitor.service;


import com.jones.goldenmonitor.model.Query;
import com.jones.goldenmonitor.object.BaseResponse;
import com.jones.goldenmonitor.repository.BaseMapper;
import com.jones.goldenmonitor.repository.IntentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IntentService extends BaseService{

    @Autowired
    private IntentMapper mapper;
    @Override
    public BaseMapper getMapper(){
        return this.mapper;
    }

}


