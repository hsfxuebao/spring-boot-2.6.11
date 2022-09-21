/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package smoketest.tomcat;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import smoketest.tomcat.web.HelloServlet;

/**
 *
 * SpringBoot整合了Spring和SpringMVC，boot底层都是spring\springmvc
 * 为什么 @SpringBootApplication +
 *   SpringApplication.run(SpringbootSourceApplication.class, args);
 *   能把Spring+SpringMVC+Tomcat+其他场景都整合进来
 *
 *
 * 1）、依赖环节；SpringBoot抽取的各种 spring-boot-starter-xxx 给我们导入了很多依赖（Spring\SpringMVC\embedTomcat）
 * 以后参考 https://docs.spring.io/spring-boot/docs/2.4.4/reference/html/using-spring-boot.html#using-boot-starter
 *
 *
 * 2）、运行原理
 *    @SpringBootConfiguration：代表这是容器中的一个配置类，一个组件【@Configuration配置类会被后置处理器来分析 ConfigurationClassPostProcessor】
 *    @EnableAutoConfiguration：导入所有功能组件
 */
@SpringBootApplication
public class SampleTomcatApplication {

	private static Log logger = LogFactory.getLog(SampleTomcatApplication.class);

	@Bean
	protected ServletContextListener listener() {
		return new ServletContextListener() {

			@Override
			public void contextInitialized(ServletContextEvent sce) {
				logger.info("ServletContext initialized");
			}

			@Override
			public void contextDestroyed(ServletContextEvent sce) {
				logger.info("ServletContext destroyed");
			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SampleTomcatApplication.class, args);
	}


	@Bean //所有的xxxRegistrationBean都是允许我们注册原生的Servlet组件进去，
		//利用 ServletContextInitializer在Tomcat启动完成以后进行回调的机制
	ServletRegistrationBean<HelloServlet> registrationBean(){

		ServletRegistrationBean<HelloServlet> registrationBean = new ServletRegistrationBean<>(new HelloServlet());
		registrationBean.addUrlMappings("/he66");
		return registrationBean;
	}
}
