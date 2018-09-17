package com.websocket.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
public class GreetingController {
    @Resource
    private SimpMessagingTemplate simpMessagingTemplate;
    @RequestMapping("/helloSocket")
    public String index(){
        return "/hello/index";
    }
    @MessageMapping("/change-notice")
    public void greeting(String value){
        this.simpMessagingTemplate.convertAndSend("/topic/notice", value);
    }
}
