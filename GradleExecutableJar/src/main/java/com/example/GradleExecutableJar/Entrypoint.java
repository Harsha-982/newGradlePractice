package com.example.GradleExecutableJar;



import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;

import java.net.URL;

public class Entrypoint {
    public static void main(String[] args) throws Exception{
        Server server=new Server(8080);
        WebAppContext webAppContext = new WebAppContext();
        server.setHandler(webAppContext);

        URL webAppDir =
               Entrypoint.class.getClassLoader().getResource("META-INF/resources");
        webAppContext.setResourceBase(webAppDir.toURI().toString());

        webAppContext.setConfigurations(new Configuration[]{
                new AnnotationConfiguration(),
                new WebInfConfiguration(),
        });
        webAppContext.addServlet(DefaultServlet.class, "/");
//        ServletHandler servletHandler=new ServletHandler();
//        server.setHandler(servletHandler);
//        servletHandler.addServletWithMapping(HelloServlet.class,"/");
        server.start();
        server.join();
    }

}
