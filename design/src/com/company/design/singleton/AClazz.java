package com.company.design.singleton;

public class AClazz {

    private SocketClient socketClient;

    public AClazz() {
        System.out.println("AClazz");
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
