package com.jones.goldenmonitor.service;


import com.alibaba.fastjson.JSONObject;
import com.jones.goldenmonitor.model.*;
import com.jones.goldenmonitor.repository.*;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ExportService{
    public static String fileUploadPath;
    @Value("${app.file.path.upload:./dist/static/files}")
    public void setFileUploadPath(String uploadPath){
        FileUploadService.fileUploadPath = uploadPath;
    }

    @Autowired
    private IntentMapper intentMapper;

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    private PositionTypeMapper positionTypeMapper;


    public String exportData() throws IOException {
        List<Intent> intentList = intentMapper.findAll(new Query());
        List<News> newsList = newsMapper.findAll(new Query());
        List<Position> positionList = positionMapper.findAll(new Query());
        List<PositionType> positionTypeList = positionTypeMapper.findAll(new Query());
        Map<String, Object> data = new HashMap<>();
        data.put("intent", intentList);
        data.put("news", newsList);
        data.put("position", positionList);
        data.put("positionType", positionTypeList);
        String result = JSONObject.toJSONString(data);
        Path path = Paths.get(fileUploadPath, "../data_all.json");
        try(FileOutputStream outputStream = new FileOutputStream(path.toFile())){
            outputStream.write(result.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return path.toAbsolutePath().toString();


    }

}


