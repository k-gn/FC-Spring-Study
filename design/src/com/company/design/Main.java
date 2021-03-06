package com.company.design;

import com.company.design.adapter.Electronic110V;
import com.company.design.decorator.A3;
import com.company.design.decorator.Audi;
import com.company.design.decorator.ICar;
import com.company.design.strategy.*;

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
        */

        /* # decorator
        ICar audi = new Audi(1000);
        audi.showPrice();

        ICar a3 = new A3(audi, "audi a3");
        a3.showPrice();
         */

        /* # observer
        Button button = new Button("버튼");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
        button.click("메시지 전달1");
        button.click("메시지 전달2");
        button.click("메시지 전달3");
         */

        /* # facade (각각의 객체에 의존하는게 아닌 정면만 바라볼 수 있는 facade 객체를 사용)
        FTP ftpClient = new FTP("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        ftpClient.disConnect();
        writer.fileDisConnect();
        reader.fileDisConnect();

        SftpClient sftpClient = new SftpClient("www.foo.co.kr", 22, "/home/etc", "text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();
         */

        // strategy pattern
        Encoder encoder = new Encoder();

        EncodingStrategy base64 = new Base64Strategy();
        EncodingStrategy normal = new NormalStrategy();

        String message = "Hello Java";

        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);

        System.out.println(base64Result);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(new AppendStrategy());
        System.out.println(encoder.getMessage(message));
    }

    // 콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
