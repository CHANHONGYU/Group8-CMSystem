package com.smart.cmsystem.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    /**
     * 接收从前端上传文件方法
     * @param upload
     */
    void upLoadFile(MultipartFile upload);

    /**
     * 返回一个图片地址方法
     * @param upload
     * @return
     */
    String getImg(MultipartFile upload);
}
