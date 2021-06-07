package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.domain.Product;

public class ProductMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		Product product = (Product) ctx.getBean("product");
		product.setCompany("LEGO");
		product.setPname("LEGO 블럭");
		product.setPrice("100000");
		product.getInfo();
	}

}
