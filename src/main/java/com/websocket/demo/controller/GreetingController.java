package com.websocket.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * MessageMapping
   Spring对于WebSocket封装的特别简单，提供了一个@MessageMapping注解，功能类似@RequestMapping，它是存在于Controller中的，定义一个消息的基本请求，功能也跟@RequestMapping类似，包括支持通配符``的url定义等等，详细用法参见Annotation Message Handling
 * SimpMessagingTemplate
   SimpMessagingTemplate是Spring-WebSocket内置的一个消息发送工具，可以将消息发送到指定的客户端。

 * index()
 指定了一个页面，用来实现WebSocket客户端发送公告功能，使用的是@RequestMapping，所以接收的是http请求，进行页面跳转。
 * greeting(String value)
 这个方法是接收客户端发送功公告的WebSocket请求，使用的是@MessageMapping。
 * this.simpMessagingTemplate.convertAndSend("/topic/notice", value)
 这个方法官方给出的解释是Convert the given Object to serialized form, possibly using a MessageConverter, wrap it as a message and send it to the given destination. 意思就是“将给定的对象进行序列化，使用‘MessageConverter’进行包装转化成一条消息，发送到指定的目标”，通俗点讲就是我们使用这个方法进行消息的转发发送！
 */

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
