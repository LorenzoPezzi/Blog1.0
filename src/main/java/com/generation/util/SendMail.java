package com.generation.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.generation.blog.model.entities.Blogger;

import java.util.Properties;

public class SendMail {
    public static boolean send(Blogger b) {

        final String username = "stepsabelli@gmail.com";
        final String password = "Zeus1993!";

        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("stepsabelli@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(b.getEmail())
            );
            message.setSubject("Thank you for your registration!");
            String mex = "Hello [name]\r\n"
            		+ "\r\n"
            		+ "You registered an account on my Blog, before being able to use your account you need to verify that this is your email address by clicking here: [link]\r\n"
            		+ "\r\n"
            		+ "Kind Regards, Lorenzo";
            mex = mex.replace("[name]", b.getNickname());
            String url = "http://localhost:8080/Blog/Index?cmd=VERIFY&nick="+b.getNickname();
            mex = mex.replace("[link]", url);
            
            message.setText(mex);

            Transport.send(message);

            System.out.println("Done");
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }

}