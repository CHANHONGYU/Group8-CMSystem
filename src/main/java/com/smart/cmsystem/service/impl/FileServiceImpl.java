package com.smart.cmsystem.service.impl;

import com.smart.cmsystem.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {
    private String img;
    @Override
    public void upLoadFile(MultipartFile upload) {

        String fileName = upload.getOriginalFilename();  //获取上传文件的名字
        //判断文件夹是否存在,不存在则创建
        //定义上传文件的存放位置
        String filePath = "D:/img/";
        File file=new File(filePath);

        if(!file.exists()){
            file.mkdirs();
        }

        String newFilePath= filePath +fileName; //新文件的路径
        img=newFilePath;

        try {
            upload.transferTo(new File(newFilePath));  //将传来的文件写入新建的文件

        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String getImg(MultipartFile upload){
        upLoadFile(upload);
        return img;
    }
}
