package com.jones.goldenmonitor.repository;

import com.jones.goldenmonitor.model.FileUpload;
import com.jones.goldenmonitor.model.Intent;
import com.jones.goldenmonitor.model.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntentMapper extends BaseMapper<Intent> {
}
