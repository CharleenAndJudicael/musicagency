/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.judicael.springmavenstarter.config;

import javax.servlet.ServletRegistration.Dynamic;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author judicael
 */
public class WebInitializer implements WebApplicationInitializer  {
	private static final Logger LOG = Logger.getLogger(WebInitializer.class.getName());	

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
//         AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();  
//        ctx.register(Config.class);  
//        ctx.setServletContext(servletContext);    
//        Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));  
//        servlet.addMapping("/");  
//        servlet.setLoadOnStartup(1);
    	
    	LOG.log(Level.INFO, "demarrage du serveur");
		// Initialisation du contexte Spring
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(Config.class);
		webContext.setServletContext(servletContext);
		
		
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(webContext));
		dispatcher.setLoadOnStartup(1);
		/*
		<servlet-mapping>
		<servlet-name>dispatcher</servlet-name>
		<url-pattern>/api</url-pattern>
		</servlet-mapping>
		*/
		//dispatcher.addMapping("/mvc/api/*");
		dispatcher.addMapping("/");
		/*
		<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
		</listener>
		*/
		servletContext.addListener(new ContextLoaderListener(webContext));
    }
    
}
