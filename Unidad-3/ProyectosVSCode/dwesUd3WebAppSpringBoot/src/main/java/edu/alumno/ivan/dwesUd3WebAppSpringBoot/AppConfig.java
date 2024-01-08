package edu.alumno.ivan.dwesUd3WebAppSpringBoot;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@ComponentScan(basePackages={"edu.profesor.joseramon"})
public class AppConfig implements WebMvcConfigurer {


    @Bean
    public UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver resolver
          = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

	@Bean
	public CommonsMultipartResolver multipartResolver() 
	  throws IOException {
	    CommonsMultipartResolver resolver
	      = new CommonsMultipartResolver();
	    resolver.setMaxUploadSize(10000000);
	    return resolver;
	}
	
	@Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource  resource = new ReloadableResourceBundleMessageSource();
        resource.setBasename("classpath:i18n/messages");
        resource.setDefaultEncoding("UTF-8");
//        resource.setCacheSeconds(10);
        return resource;
    }
	
	@Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver cl = new CookieLocaleResolver();
        cl.setCookieName("language");
        return cl;
    }
	/**
	 * Bean con Spring MVC:
	@Bean
	public SessionLocaleResolver sessionLocaleResolver() { 
	    SessionLocaleResolver localeResolver = new SessionLocaleResolver(); 
	    localeResolver.setDefaultLocale(Locale.getDefault()); 
	    //localeResolver.setDefaultLocale(new Locale("es"));
	    localeResolver.setDefaultTimeZone(TimeZone.getDefault());
	    return localeResolver; 
	}
	Spring Boot trabaja diferente a Spring MVC:
	Con una aplicación Spring MVC si no configuramos LocaleResolver, utiliza
	por defecto AcceptHeaderLocaleResolver, que no permite cambiar locale.
	Para solucionarlo en la UD2 creamos un bean SessionLocaleResolver.
	Sin embargo, con Spring Boot da error si creamos un bean de tipo SessionLocaleResolver,
	por lo que gastamos cookies que utilizamos en la sesión (CookieLocaleResolver).
	Mas info en: https://www.programmersought.com/article/17992294758/
	**/
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
	    LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
	    // Defaults to "locale" if not set
	    localeChangeInterceptor.setParamName("language");
	    return localeChangeInterceptor;
	}
	
	@Override
	  public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(localeChangeInterceptor());
	  }
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/imagenes/**")
        .addResourceLocations("/resources/imagenes/");
		registry.addResourceHandler("/webjars/**")
        .addResourceLocations("/webjars/");
    }
}
