package com.jones.goldenmonitor.repository;



import com.jones.goldenmonitor.model.Query;

import java.util.List;

public interface BaseMapper<T> {
    List<T> findList(Query paramQuery);

    T findOne(Integer id);

    Integer findCount(Query paramQuery);

    List<T> findAll(Query paramQuery);

    void insert(Object param);

    void update(Object param);

    void delete(Object param);
}

