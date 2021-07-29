package com.example.hello.ioc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

// ApplicationContext 에 직접 접근하기 위한 provider
@Component
public class ApplicationContextProvider implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            context = applicationContext;
    }

    public static ApplicationContext getContext() {
        return context;
    }
}
