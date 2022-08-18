package mainApp;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

	protected void configure(HttpSecurity http) throws Exception {
		http
        .csrf().disable()
        .authorizeRequests()
        .antMatchers(HttpMethod.OPTIONS, "/**").authenticated()
        .antMatchers(HttpMethod.GET,"/**").authenticated()
        .antMatchers(HttpMethod.POST,"/**").authenticated()
        .antMatchers(HttpMethod.PUT, "/**").authenticated()
        .antMatchers(HttpMethod.DELETE,"/**").hasRole("admin")
        .anyRequest().authenticated()
        .and().formLogin().permitAll()
        .and().httpBasic();
	}
	
	public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedMethods("*");
    }
}
