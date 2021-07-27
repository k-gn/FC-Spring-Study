package com.company.design;

import com.company.design.adapter.Cleaner;
import com.company.design.adapter.Electronic110V;
import com.company.design.adapter.HairDryer;
import com.company.design.adapter.SocketAdaptor;
import com.company.design.proxy.aop.AopBrowser;
import com.company.design.proxy.cache.Browser;
import com.company.design.proxy.cache.BrowserProxy;
import com.company.design.proxy.cache.IBrowser;
import com.company.design.singleton.AClazz;
import com.company.design.singleton.BClazz;
import com.company.design.singleton.SocketClient;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
        /* # singleton
        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));
         */

        /* # adapter
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);
        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdaptor(cleaner);
        connect(adapter);
         */

        /* # proxy
        Browser browser = new Browser("www.naver.com");
        browser.show();
        IBrowser browser = new BrowserProxy("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
         */

        // AtomicLong - Thread-safe로 구현되었고, 멀티쓰레드에서 동시성 고려 없이 사용
        // Atomic Type을 사용하면 멀티 쓰레드 환경에서 최신 데이터임이 보장되는 변수를 선언할 수 있다
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                () -> {
                    System.out.println("Before");
                    start.set(System.currentTimeMillis());
                },
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                });
        aopBrowser.show();
        System.out.println(end.get());
        aopBrowser.show();
        System.out.println(end.get());
    }

    // 콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
