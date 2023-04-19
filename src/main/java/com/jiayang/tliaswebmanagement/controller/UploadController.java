package com.jiayang.tliaswebmanagement.controller;

import com.jiayang.tliaswebmanagement.pojo.Result;
import com.jiayang.tliaswebmanagement.utils.AliOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

//    //store files locally
//    @PostMapping("/upload")
//    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
//        log.info("file upload {} {} {}", username, age,image);
//
//        String originalFilename = image.getOriginalFilename();
//        int i = originalFilename.lastIndexOf(".");
//        String substring = originalFilename.substring(i);
//        String newFileName = UUID.randomUUID().toString() + substring;
//        log.info("new filename: {}", newFileName);
//
//
//
//
//        image.transferTo(new File("D:\\filefromurl\\" + originalFilename));
//        return Result.success();
//    }



    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws IOException {
        log.info("upload file: {}", image.getOriginalFilename());

        // use ali cloud to upload file

        String url = aliOSSUtils.upload(image);
        log.info("upload file successfully path: {}", url);

        return Result.success(url);


    }

}
