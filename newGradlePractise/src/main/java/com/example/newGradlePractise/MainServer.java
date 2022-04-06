package com.example.newGradlePractise;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class MainServer {
    public static void main(String[] args) throws Exception{
        Server  server=new Server(8081);

        ServletHandler servletHandler=new ServletHandler();
        server.setHandler(servletHandler);
        servletHandler.addServletWithMapping(HelloServlet.class,"/");
        server.start();
        server.join();
    }
}