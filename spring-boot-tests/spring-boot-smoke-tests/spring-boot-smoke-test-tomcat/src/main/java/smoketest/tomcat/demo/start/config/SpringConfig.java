package smoketest.tomcat.demo.start.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * Spring不扫描controller组件、AOP咋实现的....
 */
@ComponentScan(value = "smoketest.tomcat.demo.start",excludeFilters = {
		@ComponentScan.Filter(type= FilterType.ANNOTATION,value = Controller.class)
})
@Configuration
public class SpringConfig {
	//Spring的父容器

}
