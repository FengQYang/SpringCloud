package com.fqy.service.impl;

import com.fqy.pojo.user.UserReq;
import com.fqy.repository.UserRepository;
import com.fqy.service.UserService;
import com.fqy.pojo.user.TbUser;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public String login(TbUser tbUser) {

        TbUser byLoginName = userRepository.findByUsername(tbUser.getUsername());

        if (byLoginName == null){
            return "0";
        }else if(!byLoginName.getPassword().equals(tbUser.getPassword())){
            return "1";
        }

        UUID token = UUID.randomUUID();
        //一token为key，查询出的用户对象为value存储到redis中
        redisTemplate.opsForValue().set(token.toString(),byLoginName);

        redisTemplate.expire(token.toString(),30, TimeUnit.MINUTES);

        return token.toString();
    }

    @Override
    public String sendMail(String s) {
        //1.去数据库校验是否是唯一
        TbUser byLoginName = userRepository.findByUsername(s);
        if (byLoginName!=null){
            return "用户邮箱已注册";
        }
        Map map = new HashMap<>();
        map.put("email",s);
        rabbitTemplate.convertAndSend("springcloud-email",map);
        return "验证码已发送";
    }

    @Override
    public String registry(UserReq userReq) {
        //1.先通过loginName在redis中获取你的验证码
       /* String loginName = userReq.getLoginName();
        Object o = redisTemplate.opsForValue().get(loginName);
        if (o!=null){
            String code = userReq.getCode();
            if (o.toString().equals(code)){
                //验证码比对通过，加入到数据库，用户注册成功
                TbUser tbUser = new TbUser();
                BeanUtils.copyProperties(userReq,tbUser);
                userRepository.save(tbUser);
                return "注册成功";
            }else {
                return "验证码错误";
            }
        }
        return "验证码超时";*/
        TbUser user = userRepository.findByUsername(userReq.getUsername());
        if (user!= null){
            return "该用户已注册";
        }else {
            String code = userReq.getCode();
            Object codeR = redisTemplate.opsForValue().get("email");
            if (code.equals(codeR.toString())){
                TbUser tbUser = new TbUser();
                BeanUtils.copyProperties(userReq,tbUser);
                userRepository.save(tbUser);
                return "注册成功";
            }else {
                return "注册失败";
            }
        }
    }
}
