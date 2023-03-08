package com.jones.goldenmonitor.repository;

import com.jones.goldenmonitor.model.AppConst;
import com.jones.goldenmonitor.model.param.AppConstParam;
import com.jones.goldenmonitor.model.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AppConstMapper extends BaseMapper<AppConst> {
    void updateAppConstSeq(AppConstParam param);
}
