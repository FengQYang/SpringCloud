package com.fqy.listen;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Random;

@Component
public class SendEmail {

    @Autowired
    JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    public String from;
    @Autowired
    RedisTemplate redisTemplate;
    @RabbitListener(queues = "springcloud-email")
    public void sendMail(Map map){
        String str="0123456789";
        StringBuilder sb=new StringBuilder(6);
        for(int i=0;i<6;i++) {
            char ch = str.charAt(new Random().nextInt(str.length()));
            sb.append(ch);
        }
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        Object email = map.get("email");
        simpleMailMessage.setTo(email.toString());
        simpleMailMessage.setSubject("验证码");
        simpleMailMessage.setText(sb.toString());
        try {
            javaMailSender.send(simpleMailMessage);
            redisTemplate.opsForValue().set("email",sb.toString());
        }catch (Exception e ){
            System.out.println(e.getMessage());
        }
    }
}
