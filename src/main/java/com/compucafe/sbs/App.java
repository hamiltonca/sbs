package com.compucafe.sbs;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Hello world!
 *
 */
@RestController
@EnableAutoConfiguration

public class App 
{
	@Autowired ApplicationContext ctx;
	
	static Logger log = LoggerFactory.getLogger(App.class);
	@RequestMapping("/")

	String hello() {
		log.info("Request received.");
		Set<String> beanNames = new TreeSet<String>(Arrays.asList(ctx.getBeanDefinitionNames()));
		StringBuilder output = new StringBuilder("Bean names in this app...\n");
		for (String beanName : beanNames) {
			output.append(beanName).append("\n");
		}
		return output.toString();
		//return "This is hello-world using Spring Boot for an embedded web app.\n";
	}
    public static void main( String[] args )
    {
        log.info( "Hello World!" );
        SpringApplication.run(App.class, args);
        log.info("main exiting...");
    }
}
