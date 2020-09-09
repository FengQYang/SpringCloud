package com.fqy.controller;

import com.fqy.util.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class UploadController {

    @Autowired
    QiniuUtils qiniuUtils;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam("file")MultipartFile multipartFile){
        String originalFilename = multipartFile.getOriginalFilename();
        return qiniuUtils.upload(multipartFile);
    }
}
