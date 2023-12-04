package com.yy.controller;

import cn.hutool.core.date.DateTime;
import com.yy.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 文件上传
 * @Author: LiYao
 * @CreateTime: 2022-11-29 10:41
 */
@Api(value = "提供用户列表接口", tags = "用户管理")
@RequestMapping("/doc")
@RestController
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @ApiOperation(value = "文件上传接口", notes = "上传多个文件")
    @PostMapping("/upload")
    public String uploadFile(@RequestParam String fileName, @RequestPart MultipartFile[] multipartFiles) {
        return fileService.uploadFile(fileName, multipartFiles);
    }


    public static void main(String[] args) throws IOException {
        // 从接口返回信息中拿到resourceUrls
        String resourceUrl = "https://zjk-dualstack.trans.dingtalk.com/yundisk0/iAEHAqRmaWxlA6h5dW5kaXNrMATOIQWW4gXNCmgGSAfOZSEX9QjOAAGhTQ.file";
        // 从接口返回信息中拿到headers
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization","OSS LTAIjmWpzHta71rc:arRXLEGjphH5aryo9UG+aDGp03Y=");
        headers.put("x-oss-date","Sat, 07 Oct 2023 08:33:57 GMT");

        URL url = new URL(resourceUrl);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        connection.setDoOutput(true);
        connection.setRequestMethod("PUT");
        connection.setUseCaches(false);
        connection.setReadTimeout(10000);
        connection.setConnectTimeout(10000);
        connection.connect();
        OutputStream out = connection.getOutputStream();
        InputStream is = new FileInputStream("C:\\Users\\18736644276\\Desktop\\666.docx");
        byte[] b =new byte[1024];
        int temp;
        while ((temp=is.read(b))!=-1){
            out.write(b,0,temp);
        }
        out.flush();
        out.close();
        int responseCode = connection.getResponseCode();
        connection.disconnect();
        if (responseCode == 200) {
            System.out.println("上传成功");
        } else {
            System.out.println("上传失败");
        }

    }



}
