package com.oufuhua.controller;

import com.oufuhua.service.impl.FileUploadServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @Description:
 * @Author: Nicofh
 * @Date: 2018/7/31 14:12
 */
@Controller
public class FileUploadController {

    @Autowired
    public FileUploadServiceService fileUploadServiceService;

    @Value("${config.savePath}")
    private String configSavePath;



    @RequestMapping(value = "/api/fileupload", method = RequestMethod.POST)
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile file) {
        System.out.println(configSavePath);
        try {
            fileUploadServiceService.fileUpload(file);
            return "成功";
        } catch (IOException e) {
            e.printStackTrace();
            return "失败";
        }
    }
}
