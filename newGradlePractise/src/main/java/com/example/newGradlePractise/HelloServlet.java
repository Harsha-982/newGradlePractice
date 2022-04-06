package com.example.newGradlePractise;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class HelloServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        DatastoreService ds=new DatastoreServiceFactory().getDatastoreService();

        Entity entity=new Entity("Person");
        entity.setProperty("FirstName","Harsha");
        entity.setProperty("LastName","Togaru");
        entity.setProperty("Age","21");
        entity.setProperty("Gender","Female");
        ds.put(entity);

    }
}
