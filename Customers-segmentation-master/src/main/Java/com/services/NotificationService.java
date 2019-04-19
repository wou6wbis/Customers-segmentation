//package com.services;
//
//import com.entities.EmailDto;
//import com.entities.Manager;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.MailException;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service
//public class NotificationService {
//
//    private JavaMailSender javaMailSender;
//
//    @Autowired
//    public NotificationService(JavaMailSender javaMailSender) {
//        this.javaMailSender = javaMailSender;
//    }
//
//    public void sendNotification(Manager user) throws MailException {
//        //send email
//        SimpleMailMessage mail = new SimpleMailMessage();
//        mail.setTo(user.getEmail());
//        mail.setSubject("Le meuilleur produit");
//        mail.setText("Savez vous que notre produit est classfié le meuilleur produit de l'année 2018 :D \n Avec cette nouvelle profitez de 20% de réduction sur une large sélection de produit!");
//
//        javaMailSender.send(mail);
//    }
//
//    public void sendEmail(EmailDto emailDto) throws MailException {
//        //send email
//        SimpleMailMessage mail = new SimpleMailMessage();
//        mail.setTo(emailDto.getEmailAddressTo());
//        mail.setSubject(emailDto.getEmailTitle());
//        mail.setText(emailDto.getEmailContent());
//
//        javaMailSender.send(mail);
//    }
//}
