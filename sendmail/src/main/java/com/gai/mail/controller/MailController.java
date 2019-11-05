package com.gai.mail.controller;

import com.gai.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by gaigaicoming on 2019/11/4.
 */
@RestController
public class MailController {
    @Autowired
    MailService mailService;

    @GetMapping("/mail")
    public void sendSimpleMail(){
        mailService.sendSimpleMail("932820942@qq.com","gaidx@gillion.com.cn","169066178@qq.com","主题","测试邮件发送功能");
    }

    @PostMapping("/sendAttachFileMail")
    public void sendAttachFileMail(@RequestParam(required = true, value = "files")MultipartFile files){
        File file = null;
        String fileName = null;
        try {
            fileName = files.getOriginalFilename();
            String[] name = fileName.split("\\.");
            file = File.createTempFile(name[0],"."+name[1]);
            files.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        mailService.sendAttachFileMail("932820942@qq.com", "gaidx@gillion.com.cn", "169066178@qq.com", "附件主题", "测试添加附件邮件发送功能",file);
    }

    @GetMapping("/sendImgMail")
    public void sendImgMail(){
        mailService.sendImgMail("932820942@qq.com", "gaidx@gillion.com.cn", "169066178@qq.com", "图片主题",
                "<div>hello,这是一封带图片资源的邮件：" +
                        "这是图片1：<div><img src='cid:p01'/></div>" +
                        "这是图片2：<div><img src='cid:p02'/></div>" +
                        "</div>",
                new String[]{"C:\\Users\\lenovo\\Desktop\\测试图片\\test.jpeg","C:\\Users\\lenovo\\Desktop\\测试图片\\测试照片\\timg.jpg"},
                new String[]{"p01","p02"});
    }
}
