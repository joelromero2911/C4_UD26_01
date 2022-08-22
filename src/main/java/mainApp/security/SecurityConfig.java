package mainApp.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//    private @Qualifier("dataSource")
//    DataSource dataSource;

//	@Configuration
//	public class SecurityConfiguration {
//
//	    @Bean
//	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	        http
//	            .authorizeHttpRequests((authz) -> authz
//	                .anyRequest().authenticated()
//	            )
//	            .httpBasic(withDefaults());
//	        return http.build();
//	    }
//
//	}
//	

//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
//            .antMatchers("/login").permitAll() //permitimos el acceso a /login a cualquiera
//            .anyRequest().authenticated() //cualquier otra peticion requiere autenticacion
//            .and()
//            // Las peticiones /login pasaran previamente por este filtro
//            .addFilterBefore(new LoginFilter("/login", authenticationManager()),
//                    UsernamePasswordAuthenticationFilter.class)
//
//            // Las demás peticiones pasarán por este filtro para validar el token
//            .addFilterBefore(new JwtFilter(),
//                    UsernamePasswordAuthenticationFilter.class);
//    }
	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	            .authorizeHttpRequests((authz) -> authz
	            		.antMatchers("/login").permitAll()
	                .anyRequest().authenticated()

	            )
	            
	            .httpBasic();
	    }
	
//	@Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.getSharedObject(AuthenticationManagerBuilder.class);
//        http.csrf().disable().authorizeRequests()
//            .antMatchers("/login").permitAll() //permitimos el acceso a /login a cualquiera
//            .anyRequest().authenticated() //cualquier otra peticion requiere autenticacion
//            .and()
//            // Las peticiones /login pasaran previamente por este filtro
//            .addFilterBefore(new LoginFilter("/login", authenticationManager()),
//                    UsernamePasswordAuthenticationFilter.class)
//
//            // Las demás peticiones pasarán por este filtro para validar el token
//            .addFilterBefore(new JwtFilter(),
//                    UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }

//   private AuthenticationManager authenticationManager() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Creamos una cuenta de usuario por default
       auth.inMemoryAuthentication()
               .withUser("joel")
               .password("{noop}123")
               .roles("ADMIN");
       
       auth.inMemoryAuthentication()
			   .withUser("jose")
			   .password("{noop}root")
			   .roles("USER");
    }
	
//	@Bean
//    public UserDetailsManager users(DataSource dataSource) {
//		UserDetails userAdmin = User.builder()
//	            .username("joel")
//	            .password("{noop}root")
//	            .roles("ADMIN")
//	            .build();
//        UserDetails user = User.builder()
//            .username("jose")
//            .password("{noop}123")
//            .roles("USER")
//            .build();
//        JdbcUserDetailsManager users = new JdbcUserDetailsManager((javax.sql.DataSource) dataSource);
//        users.createUser(userAdmin);
//        users.createUser(user);
//        return users;
//    }
}