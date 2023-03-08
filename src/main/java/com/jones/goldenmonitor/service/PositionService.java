package com.jones.goldenmonitor.service;


import com.jones.goldenmonitor.model.Query;
import com.jones.goldenmonitor.object.BaseResponse;
import com.jones.goldenmonitor.repository.BaseMapper;
import com.jones.goldenmonitor.repository.PositionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService extends BaseService{

    @Autowired
    private PositionMapper mapper;
    @Override
    public BaseMapper getMapper(){
        return this.mapper;
    }

    public BaseResponse findAll(Query query){
        return BaseResponse.builder().data(mapper.findAll(query)).build();
    }

}


