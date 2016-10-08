package erdemc.deneme.amqp.listener;

import org.apache.log4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class DenemeQueueListener {
	
	public static final String DENEME_QUEUE = "deneme";
	
	private static final Logger LOGGER = Logger.getLogger(DenemeQueueListener.class);
	
	@RabbitListener(queues = DenemeQueueListener.DENEME_QUEUE)
    public void onMessage(String data) {
		LOGGER.info(data);
    }

}
