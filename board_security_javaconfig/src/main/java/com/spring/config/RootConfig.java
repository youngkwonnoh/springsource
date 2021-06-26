package com.spring.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

// <aop:aspectj-autoproxy/>
@EnableAspectJAutoProxy
// <tx:annotation-driven/>
@EnableTransactionManagement
// <mybatis-spring:scan base-package="com.spring.mapper"/>
@MapperScan("com.spring.mapper")
// <context:component-scan base-package="com.spring.service"/>
@ComponentScan("com.spring.service")
// <context:component-scan base-package="com.spring.task"/>
@ComponentScan("com.spring.task")
// <context:component-scan base-package="com.spring.except"/>
@ComponentScan("com.spring.except")
@Configuration

public class RootConfig {
	
	// root-context.xml
	
	/*
	 * <!-- Hikari connection pool --> <bean id="hikariConfig"
	 * class="com.zaxxer.hikari.HikariConfig"> <property name="driverClassName"
	 * value="oracle.jdbc.OracleDriver"/> <property name="jdbcUrl"
	 * value="jdbc:oracle:thin:@localhost:1521:xe"/> <property name="username"
	 * value="javadb"/> <property name="password" value="12345"/> </bean>
	 * 
	 * <!-- Connection Pool을 위한 DataSource 설정 --> <bean id="ds"
	 * class="com.zaxxer.hikari.HikariDataSource" destroy-method="close">
	 * <constructor-arg ref="hikariConfig"/> </bean>
	 * 
	 */
	@Bean
	public DataSource dataSource() {
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		hikariConfig.setUsername("javadb");
		hikariConfig.setPassword("12345");
		
		HikariDataSource datasource = new HikariDataSource(hikariConfig);
		return datasource;
	}
	
	/*
	<!-- mybatis 설정 -->
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="ds"/>
	</bean>
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		return sqlSessionFactoryBean.getObject();
	}
	
	/*
	 * <!-- 트랜잭션 --> 
	 * <bean id="transactionManager"
	 * 	class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
	 * <property name="dataSource" ref="ds"/> </bean>
	 */
	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
}
