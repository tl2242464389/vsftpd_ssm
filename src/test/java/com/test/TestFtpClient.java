package com.test;

import org.apache.commons.net.ftp.FTPClient;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description:
 * @Author: tl
 * @Date: 2019-06-29 11:57
 * @Version: 1.0
 */
public class TestFtpClient {
    public static void main(String[] args) throws IOException {
        FTPClient ftp = new FTPClient();
        //设置 ip 和端口,写在用户名和密码上面
        ftp.connect("192.168.76.140", 21);
        //设置用户名和密码
        ftp.login("ftpuser", "ftpuserpwd");
        //设置文件类型，否则会出现图片崩裂情况
        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
        InputStream is = new FileInputStream("E:/test/a.jpg");
        //存储名称
        ftp.storeFile("abc.jpg", is);
        //退出
        ftp.logout();
    }
}
