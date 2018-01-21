package com.pengdaijun.demo.spring.framework.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/websockets")
public class GreetingController {
	// 确保如果有一个消息被发送到目的地"/hello"，则此注解关联的方法被调用处理此消息；
	@MessageMapping("/hello")
	// 消息处理完毕后，返回值被广播给所有订阅"/topic/greetings"的订阅者
	@SendTo("/topic/greetings")
	public Greeting greeting(HelloMessage message) throws Exception {
		System.out.println("GreetingController.greeting()");
		Thread.sleep(1000); // simulated delay
		return new Greeting("Hello, " + message.getName() + "!");
	}

}