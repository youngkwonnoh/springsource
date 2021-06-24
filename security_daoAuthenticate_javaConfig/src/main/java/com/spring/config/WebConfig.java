package com.spring.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
// <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	// /WEB-INF/spring/root-context.xml
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootConfig.class, SecurityConfig.class};
	}
	
	// <param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletConfig.class};
	}
	
	/*
	 	<servlet-mapping>
		<servlet-name>appServlet</servlet-name>
		<url-pattern>/</url-pattern>
		</servlet-mapping>
	 */
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}
	
	// 한글처리 필터
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		encodingFilter.setEncoding("UTF-8");
		encodingFilter.setForceEncoding(true);

		return new Filter[] {encodingFilter};
	}
	
	
}
