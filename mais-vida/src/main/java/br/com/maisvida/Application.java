package br.com.maisvida;

import java.io.Serializable;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import br.com.maisvida.filter.RequisicaoFiltro;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	public FilterRegistrationBean requisicaoFiltro(){
		final FilterRegistrationBean filter = new FilterRegistrationBean();
		
		filter.setFilter(new RequisicaoFiltro());
		filter.setUrlPatterns(Arrays.asList(new String[]{"api/*"}));
		filter.setEnabled(Boolean.TRUE);
		filter.setName("requisicao-filtro");
		
		filter.setOrder(1);
		
		return filter;
	}
	
	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry
                .addMapping("/**")
                
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedHeaders("*").allowedMethods("GET");
            }
        };
    }
}
