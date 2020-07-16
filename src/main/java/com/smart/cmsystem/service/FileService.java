package com.smart.cmsystem.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    void upLoadFile(MultipartFile upload);
    String getImg(MultipartFile upload);
}
