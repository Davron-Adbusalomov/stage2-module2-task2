package com.example.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDateTime;

@WebListener
public class ContextListener implements ServletRequestListener {
    public void contextInitialized(ServletContextEvent sce) {
        LocalDateTime localDateTime = LocalDateTime.now();

        ServletContext servletContext = sce.getServletContext();

        servletContext.setAttribute("servletTimeInit", localDateTime);
    }
}
