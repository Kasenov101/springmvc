package com.kasenov.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {HibernateConfig.class};
    }
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringWebMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //Support UTF-8 character encoding for get from web form correct characters
        FilterRegistration filterRegistration = servletContext
                .addFilter("CharacterEnCodinfgFilter", CharacterEncodingFilter.class);
        filterRegistration.setInitParameter("encoding","UTF-8");
        filterRegistration.setInitParameter("forceEncoding", "true");
        filterRegistration.addMappingForUrlPatterns(null,false,"/*");
        // Add filter for hidden method (path delete) using thymeleaf
        //opportunity to receive and perform (path, delete) requests
        servletContext.addFilter("hiddenHttpMethod", new HiddenHttpMethodFilter())
                .addMappingForUrlPatterns(null, true, "/*");
        super.onStartup(servletContext);
    }
}
