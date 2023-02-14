package com.yy.service.impl;

import com.yy.service.FileService;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: TODO
 * @Author: LiYao
 * @CreateTime: 2022-11-29 10:43
 */
public class FileServiceImpl implements FileService {


    @Override
    public void uploadFile(String fileName, MultipartFile[] multipartFiles) {
        // 1、判断文件是否上传
        if (multipartFiles.length == 0) {
            throw new RuntimeException("文件为空,请上传!");
        }
        // 2、

    }






}
