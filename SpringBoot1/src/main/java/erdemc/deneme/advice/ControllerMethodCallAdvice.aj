package erdemc.deneme.advice;

import org.aspectj.lang.Aspects;
import org.springframework.stereotype.Controller;

import erdemc.deneme.jmx.ControllerMBean;

public aspect ControllerMethodCallAdvice {

	private ControllerMBean controllerMBean;
	
	public void setControllerMBean(ControllerMBean controllerMBean) {
		this.controllerMBean = controllerMBean;
	}
	
	private static boolean isMBeanExists() {
	    return Aspects.aspectOf(ControllerMethodCallAdvice.class).controllerMBean != null;
	}
	
	pointcut isActive() : if(isMBeanExists());

	pointcut controllerMethodExecution() : execution(public * (@Controller *) .*(..));
	
	before() : isActive() && controllerMethodExecution() {
		controllerMBean.methodCalled();
	}

}
