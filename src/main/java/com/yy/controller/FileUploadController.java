package com.yy.controller;

import com.yy.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 文件上传
 * @Author: LiYao
 * @CreateTime: 2022-11-29 10:41
 */

public class FileUploadController {

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public void uploadFile(@RequestParam String fileName, @RequestPart MultipartFile[] multipartFiles) {
        fileService.uploadFile(fileName,multipartFiles);
    }


}
