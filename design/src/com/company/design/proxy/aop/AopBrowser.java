package com.company.design.proxy.aop;

import com.company.design.proxy.cache.Html;
import com.company.design.proxy.cache.IBrowser;

public class AopBrowser implements IBrowser {

    private String url;
    private Html html;
    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {

        before.run();

        if(html == null) {
            this.html = new Html(url);
            System.out.println("html loading from : " + url);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("html cache : " + url);
        }

        after.run();
        return html;
    }
}
