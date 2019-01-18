//package com.zwk.weibo.config;
//
//import com.alibaba.fastjson.JSONObject;
//import org.springframework.stereotype.Component;
//import javax.annotation.PostConstruct;
//import javax.websocket.*;
//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.URI;
//
///**
// * @ Author     ：zwk
// * @ Email      ：zwk0@qq.com
// * @ Date       ：Created in 2019-01-17 14:23
// * @ Description：
// */
//@Component
//@ClientEndpoint
//public class WebSocketClient {
//    // 服务端的IP和端口号
//    private static final String URL = "192.168.8.101:8080";
//
//    private Session session;
//
////    @PostConstruct
////    void init() {
////        try {
////            // 本机地址
////            String hostAddress = InetAddress.getLocalHost().getHostAddress();
////            WebSocketContainer container = ContainerProvider.getWebSocketContainer();
////            String wsUrl = "ws://" + URL + "/" + hostAddress;
////            URI uri = URI.create(wsUrl);
////            session = container.connectToServer(WebSocketClient.class, uri);
////        } catch (DeploymentException | IOException e) {
////            e.printStackTrace();
////        }
////    }
//
//    /**
//     * 打开连接
//     * @param session
//     */
//    @OnOpen
//    public void onOpen(Session session) {
//        this.session = session;
//    }
//
//    /**
//     * 接收消息
//     * @param text
//     */
//    @OnMessage
//    public void onMessage(String text) {
//
//    }
//
//    /**
//     * 异常处理
//     * @param throwable
//     */
//    @OnError
//    public void onError(Throwable throwable) {
//        throwable.printStackTrace();
//    }
//
//    /**
//     * 关闭连接
//     */
//    @OnClose
//    public void onClosing() throws IOException {
//        session.close();
//    }
//
//    /**
//     * 主动发送消息
//     */
//    public void send(JSONObject json) {
//       session.getAsyncRemote().sendText(json.toJSONString());
//    }
//
//}
