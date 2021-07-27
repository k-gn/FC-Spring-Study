package com.company.design.proxy.cache;

public class BrowserProxy implements IBrowser {

    private String url;
    private Html html;

    public BrowserProxy(String url) {
        this.url = url;
    }

    @Override
    public Html show() {
        if(html == null) {
            this.html = new Html(url);
            System.out.println("BrowserProxy loading html from : " + url);
        }else {
            System.out.println("BrowserProxy use cache html : " + url);
        }
        return html;
    }
}
