package com.gai.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * Created by gaigaicoming on 2019/11/4.
 */
@Component
public class MailService {
    @Autowired
    JavaMailSender javaMailSender;

    public void sendSimpleMail(String form,String to,String cc,
                               String subject,String content){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(form);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setCc(cc);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(content);
        javaMailSender.send(simpleMailMessage);
    }

    public void sendAttachFileMail(String form,String to,String cc,
                                   String subject,String content,File file){
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(form);
            helper.setTo(to);
            helper.setCc(cc);
            helper.setSubject(subject);
            helper.setText(content);
            helper.addAttachment(file.getName(),file);
            helper.addAttachment(file.getName()+"2",file);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendImgMail(String form,String to,String cc,
                            String subject,String content,String[] srcPath,
                            String[] resIds){
        if(srcPath.length != resIds.length){
            System.out.println("发送失败");
            return;
        }
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = null;
        try {
            helper = new MimeMessageHelper(mimeMessage,true);
            helper.setFrom(form);
            helper.setTo(to);
            helper.setCc(cc);
            helper.setSubject(subject);
            helper.setText(content,true);
            for (int i = 0; i < srcPath.length; i++){
                FileSystemResource res = new FileSystemResource(new File(srcPath[i]));
                helper.addInline(resIds[i],res);
            }
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }



}
