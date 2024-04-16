package com.backend.config;

import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

public class GetHttpSessionConfig extends ServerEndpointConfig.Configurator {
    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        //获取HTTPSESSION
        HttpSession httpSession = (HttpSession) request.getHttpSession();
        //将httpSession对象保存起来
        sec.getUserProperties().put(HttpSession.class.getName(),httpSession);
    }
}
