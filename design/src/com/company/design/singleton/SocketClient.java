package com.company.design.singleton;

import jdk.swing.interop.SwingInterOpUtils;

public class SocketClient {

    private static SocketClient socketClient;

    private SocketClient() {}

    public static SocketClient getInstance() {

        // 없을 경우 최초 한번만 생성 (단 하나의 유일한 객체를 생성하여 사용 => 싱글톤) , ex) 프린터, 소켓, JDBC
        if(socketClient == null) {
            System.out.println("new socket");
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect() {
        System.out.println("connect");
    }
}
