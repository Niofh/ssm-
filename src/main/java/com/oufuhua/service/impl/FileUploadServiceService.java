package com.oufuhua.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Description:
 * @Author: Nicofh
 * @Date: 2018/7/31 15:01
 */
@Service
public class FileUploadServiceService {
    @Value("${config.savePath}")
    private String configSavePath;


    public void fileUpload(MultipartFile f) throws IOException {
        if(!f.isEmpty()){
            // 文件夹目录
            File fileFolder = new File(configSavePath);
            // 文件不存在，就创建多级目录
            if (!fileFolder.exists()) {
                fileFolder.mkdirs();
            }
            String fileName = System.currentTimeMillis() + "_" + f.getOriginalFilename();
            System.out.println(fileName);
            // 定义文件的路径
            File file = new File(configSavePath, fileName);

            // 文件转移到自定义文件目录
            f.transferTo(file);
        }
    }
}
