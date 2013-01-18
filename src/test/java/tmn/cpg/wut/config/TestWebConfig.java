package tmn.cpg.wut.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import tmn.cpg.wut.model.UserProfile;

@Configuration
@ComponentScan(basePackages = {"tmn.cpg.wut"})
public class TestWebConfig {

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/pages/");
		resolver.setSuffix(".jsp");

		return resolver;
	}
	
	@Bean
	public UserProfile getUserProfile(){
		return new UserProfile();
	}
	
}
