package com.smart.cmsystem.controller;

import com.smart.cmsystem.service.FileService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
public class FileController {
    @Resource
    private FileService fileService;

    @RequestMapping("/saveImg")
    @ResponseBody
    public String saveImg(MultipartFile upload){
        return  fileService.getImg(upload);
    }
}
