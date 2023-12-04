package com.yy.service.impl;

import com.yy.service.FileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Description: TODO
 * @Author: LiYao
 * @CreateTime: 2022-11-29 10:43
 */
@Service
public class FileServiceImpl implements FileService {

    @Value("${upload.url}")
    private String url;

    public static final List<String> list = Arrays.asList("jpg", "png", "jpeg", "JPEG", "JPG", "PNG");

    @Override
    public String uploadFile(String fileName, MultipartFile[] uploadFile) {
        String filePaths = "";
        // 1、判断文件是否上传
        if (uploadFile.length == 0) {
            throw new RuntimeException("文件为空,请上传!");
        }
        // 2、
        for (MultipartFile file : uploadFile) {
            String oldName = file.getOriginalFilename();
            String fileType = oldName.substring(oldName.lastIndexOf(".") + 1);
            if (!list.contains(fileType)) {
                throw new RuntimeException("图片格式只能为jpg或png");
            }
            String format = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
            File directory = new File(url + format);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            //1、给上传的图片生成新的文件名
            String newName = UUID.randomUUID().toString().replaceAll("-", "") + oldName.substring(oldName.lastIndexOf("."));
            try {
                file.transferTo(new File(directory, newName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (Objects.equals("", filePaths)) {
                filePaths = format + "/" + newName;
            } else {
                filePaths += ";" + format + "/" + newName;
            }
        }
        return filePaths;
    }


}
