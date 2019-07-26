package com.test.service.impl;

import com.test.service.DemoService;
import com.test.utils.FtpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

/**
 * @Description:
 * @Author: tl
 * @Date: 2019-06-29 12:08
 * @Version: 1.0
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Value("${ftpClient.host}")
    private String host;
    @Value("${ftpClient.port}")
    private int port;
    @Value("${ftpClient.username}")
    private String username;
    @Value("${ftpClient.password}")
    private String password;
    @Value("${ftpClient.basePath}")
    private String basePath;
    @Value("${ftpClient.savePath}")
    private String savePath;

    @Override
    public boolean upload(MultipartFile multipartFile) throws IOException {
        String fileName = UUID.randomUUID() + multipartFile.getOriginalFilename()
                .substring(multipartFile.getOriginalFilename().lastIndexOf("."));

        return FtpUtil.uploadFile(host, port, username, password, basePath, savePath,
                fileName, multipartFile.getInputStream());
    }
}
