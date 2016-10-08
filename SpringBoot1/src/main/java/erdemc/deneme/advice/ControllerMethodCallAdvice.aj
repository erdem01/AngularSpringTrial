package erdemc.deneme.advice;

import javax.annotation.Resource;

import erdemc.deneme.jmx.ControllerMBean;

public aspect ControllerMethodCallAdvice {

	@Resource
	private ControllerMBean controllerMBean;
	
	public void setControllerMBean(ControllerMBean controllerMBean) {
		this.controllerMBean = controllerMBean;
	}

	pointcut controllerMethodCall() : execution(* erdemc.deneme.controller..*(..));

	before() : controllerMethodCall() {
		controllerMBean.methodCalled();
	}

}
