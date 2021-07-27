package com.company.design.singleton;

public class BClazz {

    private SocketClient socketClient;

    public BClazz() {
        System.out.println("BClazz");
        this.socketClient = SocketClient.getInstance();
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
