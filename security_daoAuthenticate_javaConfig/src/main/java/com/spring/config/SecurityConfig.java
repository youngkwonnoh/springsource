package com.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.spring.handler.CustomAccessDeniedHandler;
import com.spring.handler.CustomLoginSuccessHandler;
import com.spring.service.CustomUserDetailService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource dataSource;
	
	// <bean id="customLoginSuccessHandler" class="com.spring.handler.CustomLoginSuccessHandler" />
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	// <bean id="customAccessDeniedHandler" class="com.spring.handler.CustomAccessDeniedHandler" />
	@Bean
	public AccessDeniedHandler accessDeniedHandler() {
		return new CustomAccessDeniedHandler();
	}
	
	/*
	<!-- μνΈν -->
	<bean id="bCryptPasswordEncoder" class="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"/>
	*/
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*
	<security:authentication-manager>
		<security:authentication-provider user-service-ref="customUserDetailService">
			<!-- jdbc μΈμ¦ λ°©μ -->
			<security:password-encoder ref="bCryptPasswordEncoder"/>
		</security:authentication-provider>
	</security:authentication-manager>
	*/
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
		repo.setDataSource(dataSource);
		return repo;
	}
	/*
	<!-- UserDetailService -->
	<bean id="customUserDetailService" class="com.spring.service.CustomUserDetailService"/>
	*/
	@Bean
	public UserDetailsService customUserDetailService() {
		return new CustomUserDetailService();
	}
	
	// <security:http>
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// λͺ¨λ  μ¬λμ΄ μ κ·Όν  μ μλ url μ§μ 
		http.authorizeRequests()
			.antMatchers("/login")
			.permitAll();
		
		/*
		<!-- μ κ·Ό μ ν μ handlerλ₯Ό κ±°μ³ μ»¨νΈλ‘€λ¬λ‘ μ΄λνλ νν -->
		<security:access-denied-handler ref="customAccessDeniedHandler"/>
		 */
		http.exceptionHandling(exception -> exception.accessDeniedHandler(accessDeniedHandler()));

		/*
		<!-- λ‘κ·ΈμΈ λ΄λΉ : κΈ°λ³Έ νν° -->
		<security:form-login login-page="/login" authentication-failure-url="/login-error" 
		authentication-success-handler-ref="customLoginSuccessHandler"/>
		 */
		http.formLogin()
			.loginPage("/login")
			.failureUrl("/login-error")
			.successHandler(loginSuccessHandler());
		
		/*
		<!-- λ‘κ·Έ μμ λ΄λΉ -->
		<security:logout invalidate-session="true" logout-success-url="/"/>
		*/
		http.logout()
			.invalidateHttpSession(true)
			.logoutSuccessUrl("/");
		/*
		<!-- remember-me νμ±ν -->
		<security:remember-me data-source-ref="ds" token-validity-seconds="604800"/>
		*/
		http.rememberMe()
			.tokenRepository(persistentTokenRepository())
			.tokenValiditySeconds(604800);
	}
	
	/*
	<!-- UserDetailService -->
	<bean id="customUserDetailService" class="com.spring.service.CustomUserDetailService"/>
	*/
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService())
			.passwordEncoder(passwordEncoder());
	}
	
}
