package edu.miu.e_mart.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DeploymentDescriptor extends AbstractAnnotationConfigDispatcherServletInitializer {

	protected Class<?>[] getServletConfigClasses() {
		@SuppressWarnings("rawtypes")
		Class[] servletConfigClasses = { Dispatcher.class };
		return servletConfigClasses;
	}

	protected String[] getServletMappings() {
		String[] servletMappings = { "/" };
		return servletMappings;
	}

	protected Class<?>[] getRootConfigClasses() {

		@SuppressWarnings("rawtypes")
		Class[] servletConfigClasses = { PersistenceJPAConfig.class, WebSecurityConfig.class };
		return servletConfigClasses;
	}

	// Allows Characters [ e.g. Geez] in browser
	@Override
	protected Filter[] getServletFilters() {

		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		return new Filter[] { characterEncodingFilter };
	}

	public void getServlet(ServletContext container) {
		container.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"))
				.addMappingForUrlPatterns(null, false, "/**");
	}

}