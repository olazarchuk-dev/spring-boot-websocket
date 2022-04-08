package com.websocketdemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;
import java.io.IOException;
import java.util.Date;

@Slf4j
public class WebSocketHandler extends AbstractWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String payload = message.getPayload();
        log.info("(Text) Message Payload Received: '{}'", payload);
        TextMessage msg = new TextMessage("Response: txt='" + payload + "' date='" + new Date() + "'");
        session.sendMessage(msg);
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws IOException {
        log.info("(Binary) Message Payload Received: ", message.getPayload());
        session.sendMessage(message);
    }
}
