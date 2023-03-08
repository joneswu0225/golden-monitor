package com.jones.goldenmonitor.service;


import com.jones.goldenmonitor.model.Query;
import com.jones.goldenmonitor.object.BaseResponse;
import com.jones.goldenmonitor.repository.BaseMapper;
import com.jones.goldenmonitor.repository.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsService extends BaseService{

    @Autowired
    private NewsMapper mapper;
    @Override
    public BaseMapper getMapper(){
        return this.mapper;
    }

    public BaseResponse findAll(Query query){
        return BaseResponse.builder().data(mapper.findAll(query)).build();
    }

}


