package com.ecom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ecom.security.JwtAuthenticationEntryPoint;
import com.ecom.security.JwtAuthenticationFilter;


import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtAuthenticationEntryPoint entryPoint;

	@Autowired
	private JwtAuthenticationFilter filter;

	public static String[] PUBLIC_URLS = {

			"/users/", "/auth/login", "/v3/api-docs", "/v2/api-docs", "/swagger-resources/**", "/swagger-ui/**",
			"/webjars/**"

	};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests().antMatchers(PUBLIC_URLS).permitAll().antMatchers(HttpMethod.GET)
				.permitAll()
				// .antMatchers(HttpMethod.POST,"/users/**").hasRole("ADMIN")
				.anyRequest().authenticated().and().exceptionHandling().authenticationEntryPoint(entryPoint).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		http.addFilterAfter(filter, UsernamePasswordAuthenticationFilter.class);
	}

	// important: configuring database auth
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Bean
	public FilterRegistrationBean corsFilter() {
		
		UrlBasedCorsConfigurationSource source =new UrlBasedCorsConfigurationSource();
		
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowCredentials(true);
		configuration.addAllowedOriginPattern("*");
		configuration.addAllowedHeader("Authorization");
		configuration.addAllowedHeader("Content-type");
		configuration.addAllowedHeader("Accept");
		configuration.addAllowedMethod("POST");
		configuration.addAllowedMethod("GET");
		configuration.addAllowedMethod("DELETE");
		configuration.addAllowedMethod("PUT");
		configuration.addAllowedMethod("OPTIONS");
		configuration.setMaxAge(3600L);
		
		source.registerCorsConfiguration("/**", configuration);
		
	   FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
		
		bean.setOrder(-110);
		return bean;
	}


}
