package com.intellecto2.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * @SpringBootApplication encapsulates @Configuration, @EnableAutoConfiguration,
 * and @ComponentScan annotations with their default attributes.
 * */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * @Bean is a method-level annotation and a direct analog of the XML <bean/> element.
	 * The annotation supports most of the attributes offered by <bean/>, such as: init-method,
	 * destroy-method, autowiring, lazy-init, dependency-check, depends-on and scope.
	 *
	 * When JavaConfig encounters this method, it will execute that method and register
	 * the return value as a bean within a BeanFactory. By default, the bean name will be
	 * the same as the method name
	 * */
	@Bean(name = "application_context_printer")
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}
		};
	}

}
