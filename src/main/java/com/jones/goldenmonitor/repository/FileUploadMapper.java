package com.jones.goldenmonitor.repository;

import com.jones.goldenmonitor.model.FileUpload;
import com.jones.goldenmonitor.model.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileUploadMapper extends BaseMapper<FileUpload> {
    List<Object> findAllName(Query query);
}
