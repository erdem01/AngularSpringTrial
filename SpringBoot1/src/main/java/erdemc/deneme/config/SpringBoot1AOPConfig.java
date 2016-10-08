package erdemc.deneme.config;

import org.aspectj.lang.Aspects;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import erdemc.deneme.advice.ControllerMethodCallAdvice;
import erdemc.deneme.jmx.ControllerMBean;

@Configuration
public class SpringBoot1AOPConfig {
	
	@Bean
	public ControllerMethodCallAdvice profiler(ControllerMBean controllerMBean) {
		ControllerMethodCallAdvice profiler = Aspects.aspectOf(ControllerMethodCallAdvice.class);
	    profiler.setControllerMBean(controllerMBean);
	    return profiler;
	}
	
}
