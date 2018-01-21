package com.pengdaijun.demo.spring.framework.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

//@Configuration
//@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

	//设置消息代理，也就是页面上用js来订阅的地址，也是我们服务器往WebSocket端接收js端发送消息的地址。
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
    	System.out.println("服务器启动成功");
    	//这里设置的simple broker是指可以订阅的地址，也就是服务器可以发送的地址
        config.enableSimpleBroker("/topic");
        //设置了一个应用程序访问地址的前缀，也就是说，网页上要发送消息到服务器上的地址是/app/xxx
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
    	System.out.println("WebSocketConfig.registerStompEndpoints()");
    	//注册消息连接点，添加这个Endpoint，这样在网页中就可以通过websocket连接上服务了
        registry.addEndpoint("/gs-guide-websocket").withSockJS();
    }

}