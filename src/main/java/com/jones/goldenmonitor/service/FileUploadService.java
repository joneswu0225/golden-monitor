package com.jones.goldenmonitor.service;

import com.alibaba.fastjson.JSONObject;
import com.jones.goldenmonitor.model.*;
import com.jones.goldenmonitor.model.query.AppConstQuery;
import com.jones.goldenmonitor.object.BaseResponse;
import com.jones.goldenmonitor.object.ErrorCode;
import com.jones.goldenmonitor.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class FileUploadService extends BaseService{
    public static String fileUploadPath;
    @Value("${app.file.path.upload:./static/files}")
    public void setFileUploadPath(String uploadPath){
        FileUploadService.fileUploadPath = uploadPath;
    }

    @PostConstruct
    private void init(){
        File path = Paths.get(fileUploadPath).toFile();
        if(!path.exists()){
            path.mkdirs();
        }
    }

    @Autowired
    private FileUploadMapper mapper;

    @Autowired
    private IntentMapper intentMapper;

    @Autowired
    private NewsMapper newsMapper;

    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private AppConstMapper appConstMapper;

    @Autowired
    private PositionTypeMapper positionTypeMapper;


    public String exportData() throws IOException {
        List<Intent> intentList = intentMapper.findAll(new Query());
        List<News> newsList = newsMapper.findAll(new Query());
        List<Position> positionList = positionMapper.findAll(new Query());
        List<PositionType> positionTypeList = positionTypeMapper.findAll(new Query());
        List<AppConst> appConstList = appConstMapper.findAll(new Query());
        Map<String, Object> data = new HashMap<>();
        data.put("intent", intentList);
        data.put("news", newsList);
        data.put("position", positionList);
        data.put("positionType", positionTypeList);
        data.put("appConst", appConstList);
        String result = JSONObject.toJSONString(data);
        Path path = Paths.get(fileUploadPath, "../data_all.json");
        try(FileOutputStream outputStream = new FileOutputStream(path.toFile())){
            outputStream.write(result.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return path.toAbsolutePath().toString();
    }

    public BaseResponse uploadFile(MultipartFile file, String fileName) {
        try {
            String now = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME).substring(0, 10).replace('T', ' ');
            String timestamp = String.valueOf(System.currentTimeMillis());
            fileName = StringUtils.isEmpty(fileName) ? timestamp : fileName;
            int fileSurfixIndex = fileName.lastIndexOf(".");
            int originFileSurfixIndex = file.getOriginalFilename().lastIndexOf(".");
            fileName = fileSurfixIndex > 0 ? fileName.substring(0, fileSurfixIndex) : fileName;
//            fileName = fileName + "_" + now;
            String fileSurfix = originFileSurfixIndex > 0 ? file.getOriginalFilename().substring(originFileSurfixIndex + 1) : (fileSurfixIndex > 1 ? fileName.substring(fileSurfixIndex + 1) : null);
            fileName = StringUtils.isEmpty(fileSurfix) ? fileName : (fileName + "." + fileSurfix);
            Path path = Paths.get(fileUploadPath, fileName);
            path.toFile().mkdirs();
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            FileUpload fileUpload = FileUpload.builder().path(fileName).name(fileName).create_time(now).build();

            mapper.insert(fileUpload);
            Map<String, String> result = new HashMap<>();
            result.put("path", fileName);
            return BaseResponse.builder().data(result).build();
        } catch (Exception e) {
            log.error("文件上传失败", e);
            return BaseResponse.builder().code(ErrorCode.UPLOAD_FAILED).data(e.getMessage()).build();
        }
    }


    public String getFileUploadPath(){
        return fileUploadPath;
    }

    @Override
    public BaseMapper getMapper() {
        return this.mapper;
    }
}

