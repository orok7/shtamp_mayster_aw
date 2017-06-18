package eins.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("eins.*")
public class WebConfig extends WebMvcConfigurerAdapter{

    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                .addResourceHandler("/img/**")
                .addResourceLocations("/pages/img/");
        registry
                .addResourceHandler("/css/**")
                .addResourceLocations("/pages/styles/");
        registry
                .addResourceHandler("/bs_css/**")
                .addResourceLocations("/pages/bs_styles/css/");
        registry
                .addResourceHandler("/bs_js/**")
                .addResourceLocations("/pages/bs_styles/js/");
        registry
                .addResourceHandler("/my_js/**")
                .addResourceLocations("/pages/styles/js/");
        registry
                .addResourceHandler("/bs/fonts/**")
                .addResourceLocations("/pages/bs_styles/fonts/");
    }
}