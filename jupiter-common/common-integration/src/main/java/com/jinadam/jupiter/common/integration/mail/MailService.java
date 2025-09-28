package com.jinadam.jupiter.common.integration.mail;


import com.jinadam.jupiter.common.util.constants.ErrorCode;
import com.jinadam.jupiter.common.util.exception.BizException;
import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @author Adam
 * 2025-09-10 16:27
 */
@Component
public class MailService {

    @Resource
    private JavaMailSender mailSender;

    @Resource
    private MailProperties mailProperties;

    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailProperties.getUsername());
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
        System.out.println("Simple Email Sent to: " + to);
    }

    /**
     * 发送带HTML内容的邮件
     *
     * @param to          收件人
     * @param subject     主题
     * @param htmlContent HTML内容
     */
    public void sendHtmlEmail(String to, String subject, String htmlContent) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(mailProperties.getUsername());
            helper.setTo(to);
            helper.setSubject(subject);
            // true表示内容是HTML
            helper.setText(htmlContent, true);
            mailSender.send(message);
        } catch (MessagingException e) {
            throw new BizException(ErrorCode.BIZ.EMAIL_SEND_ERROR);
        }
    }

    /**
     * 发送带附件的邮件
     *
     * @param to             收件人
     * @param subject        主题
     * @param text           邮件内容
     * @param filePath       附件路径
     * @param attachmentName 附件名
     */
    public void sendEmailWithAttachment(String to, String subject, String text, String filePath, String attachmentName) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
            helper.setFrom(mailProperties.getUsername());
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            helper.addAttachment(attachmentName, file);

            mailSender.send(message);
            System.out.println("Email with Attachment Sent to: " + to);
        } catch (MessagingException e) {
            throw new BizException(ErrorCode.BIZ.EMAIL_SEND_ERROR);
        }
    }
}
