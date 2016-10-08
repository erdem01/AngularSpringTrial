package erdemc.deneme.jmx;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource(objectName="erdemc:name=ControllerMBean")
@Component
public class ControllerMBeanImpl implements ControllerMBean {
	
	private volatile int callCount = 0;
	
	@Override
	public void methodCalled() {
		callCount++;
	}
	
	@ManagedAttribute
	@Override
	public int getCallCount() {
		return callCount;
	}

}
