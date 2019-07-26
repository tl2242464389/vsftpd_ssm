package com.test.controller;

import com.test.service.DemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Description:
 * @Author: tl
 * @Date: 2019-06-29 12:22
 * @Version: 1.0
 */
@Controller
public class DemoController {
    @Resource
    private DemoService demoServiceImpl;

    @RequestMapping("/upload")
    public String upload(MultipartFile file){
        try {
            boolean index = demoServiceImpl.upload(file);
            if(index){
                return "/success.jsp";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/error.jsp";
    }
}
