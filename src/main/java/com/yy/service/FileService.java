package com.yy.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author LY
 */
public interface FileService {

    /**
     * 上传文件
     * @param fileName
     * @param multipartFiles
     */
    void uploadFile(String fileName, MultipartFile[] multipartFiles);
}
