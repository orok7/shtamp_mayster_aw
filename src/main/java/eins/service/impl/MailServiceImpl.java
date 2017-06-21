package eins.service.impl;

import eins.service.interfaces.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendMailRecPass(String email, String pass, double min) {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
            helper.setFrom("orok.java@gmail.com");
            helper.setTo(new InternetAddress(email));
            helper.setText("Hello dear user.<br>" +
                    "If you didn't request to recover your password, please ignore this message.<br>" +
                    "Otherwise, your temporary password is " + pass + ", valid for " + min + " minutes.<br>" +
                    "Thank you for using our service!", true);


        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(message);

    }
}
