//package com.controllers;
//import com.entities.EmailDto;
//import com.entities.Manager;
//import com.services.NotificationService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.MailException;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class RegistrationController {
//
//    private Logger log = LoggerFactory.getLogger(RegistrationController.class);
//
//    @Autowired
//    private NotificationService notificationService;
//
//    @RequestMapping("/signup")
//    public String signup() {
//        return "Please sign up for our service.";
//    }
//
//    @RequestMapping("/signup-success")
//    public String signupSuccess() {
//
//        Manager manager = new Manager();
//        manager.setName("Oumaima");
//        manager.setSalary(20.2);
//        manager.setEmail("oumaima1saidane@gmail.com");
//
//        try {
//            notificationService.sendNotification(manager);
//        } catch (MailException e) {
//            log.info(e.getMessage());
//        }
//
//        return "Thank you for registering with us.";
//    }
//
//    @RequestMapping("/send")
//    public String send(EmailDto emailDto) {
//
//        try {
//            notificationService.sendEmail(emailDto);
//        } catch (MailException e) {
//            log.info(e.getMessage());
//        }
//
//        return "Success!";
//    }
//}
