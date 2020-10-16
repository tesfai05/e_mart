package edu.miu.e_mart.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


public class EmartApplicationInitializer {
	public void onStartup(ServletContext servletContext) throws ServletException {

		AnnotationConfigWebApplicationContext webApplication = new AnnotationConfigWebApplicationContext();
		webApplication.register(Dispatcher.class);

		// create a dispatcher servlet
		DispatcherServlet dispatcherServlet = new DispatcherServlet(webApplication);

		// register the dispatcher servlet with servlet contex object
		ServletRegistration.Dynamic myCustomDispatcherServlet = servletContext.addServlet("dispacher",
				dispatcherServlet);

		myCustomDispatcherServlet.setLoadOnStartup(1);
		myCustomDispatcherServlet.addMapping("/*");

	}
}
