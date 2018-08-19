package com.mmall.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    String upload(String path, MultipartFile file);
}
