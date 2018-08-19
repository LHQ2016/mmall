package com.mmall.service.Impl;

import com.google.common.collect.Lists;
import com.mmall.service.IFileService;
import com.mmall.util.FTPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service("iFileService")
public class FileServiceImpl implements IFileService {
    private Logger logger = LoggerFactory.getLogger(FileServiceImpl.class);

    @Override
    public String upload(String path, MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        String uploadFileName = UUID.randomUUID().toString() + "." + fileExtensionName;//防止同名文件上传后，第一个文件被覆盖
        logger.info("开始上传文件，上传文件的文件名为{}，文件保存路径为{}，新文件名为{}", fileName, path, uploadFileName);

        File fileDir = new File(path);
        if (!fileDir.exists()) {
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(path, uploadFileName);

        try {
            file.transferTo(targetFile);
            FTPUtil.uploadFile(Lists.newArrayList(targetFile));
            //此时文件已经上传的ftp服务器
            targetFile.delete();
        } catch (IOException e) {
            logger.error("文件上传失败", e);
            return null;
        }
        return targetFile.getName();
    }
}
