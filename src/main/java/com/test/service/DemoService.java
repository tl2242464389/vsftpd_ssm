package com.test.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Description:
 * @Author: tl
 * @Date: 2019-06-29 12:07
 * @Version: 1.0
 */
public interface DemoService {
    boolean upload(MultipartFile multipartFile) throws IOException;
}
