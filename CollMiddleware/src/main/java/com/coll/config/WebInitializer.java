package com.coll.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.coll.config.DBConfig;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("---getRootConfigClasses---");
		return new Class[] {WebResolver.class,DBConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("---getServletConfigClasses---");
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("--- getServletMappings---");
		  return new String[] {"/"};
	}

}
