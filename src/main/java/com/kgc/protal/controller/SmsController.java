package com.kgc.protal.controller;

import com.kgc.smc.SmsUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/page/")
public class SmsController {
    @RequestMapping("getCode")
public String getCode(String sendPhone, HttpSession session){
        //生成随机数  六位
        String code =(int)(Math.random()*1000000)+"";
        //发送信息
        String sendMsg="验证码是："+code+"，请在120秒内输入验证码";
        int result= SmsUtil.sendMsg(sendPhone,sendMsg);
        //3.使用session保存生成的验证码
        session.setAttribute("saveCode",code);
        session.setMaxInactiveInterval(120);  //120秒
        return "{\"result\":"+result +"}";
    }
}
