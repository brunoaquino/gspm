package br.com.gspm.mvc.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.gspm.mvc.filtro.FiltroMigracao;

@EnableWebMvc
@ComponentScan(basePackages = { "br.com.gspm.mvc" })
@Configuration
public class AppWebConfiguration extends WebMvcConfigurerAdapter {

	// private static final String VIEW_RESOLVER_PREFIX = "/WEB-INF/views/";
	// private static final String VIEW_RESOLVER_SUFFIX = ".jsp";

	//
	// @Bean
	// public InternalResourceViewResolver internalResourceViewResolver() {
	// InternalResourceViewResolver resolver = new
	// InternalResourceViewResolver();
	// resolver.setPrefix(VIEW_RESOLVER_PREFIX);
	// resolver.setSuffix(VIEW_RESOLVER_SUFFIX);
	// resolver.setExposedContextBeanNames("Teste");
	// return resolver;
	// }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}

	@Bean(name = "migration")
	public FiltroMigracao getFiltroMigracao() {
		return new FiltroMigracao();
	}

}
