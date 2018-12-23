package com.wgc.config.web;

import com.wgc.config.BookWeb;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/*实现这个接口，就可以获取到它的实现类*/
@HandlesTypes({BookWeb.class})
public class MyWebConfig implements ServletContainerInitializer {
    @Override
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        //使用反射的方式全部的实现类
        for (Class<?> aClass : set) {
            try {
                BookWeb o = (BookWeb) aClass.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
