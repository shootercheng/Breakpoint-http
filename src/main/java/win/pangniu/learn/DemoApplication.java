package com.scd.demo;

import javax.servlet.MultipartConfigElement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import win.pangniu.learn.service.StorageService;

@SpringBootApplication
@ComponentScan(basePackages={"com.scd.demo","win.pangniu.learn"})
@EnableAutoConfiguration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
    @Bean
    CommandLineRunner init(final StorageService storageService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
            	storageService.init();
//                storageService.deleteAll();
              
            }
        };
    }
    
    @SuppressWarnings("deprecation")
	@Bean  
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        //单个文件最大  
        factory.setMaxFileSize("10240KB"); //KB,MB  
        /// 设置总上传数据总大小  
        factory.setMaxRequestSize("102400KB");  
        return factory.createMultipartConfig();  
    }  
}
