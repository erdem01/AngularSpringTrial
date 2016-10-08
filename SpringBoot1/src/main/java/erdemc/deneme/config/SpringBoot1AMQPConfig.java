package erdemc.deneme.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import erdemc.deneme.amqp.listener.DenemeQueueListener;

@Configuration
public class SpringBoot1AMQPConfig {
	
	@Bean
	public Queue denemeQueue() {
		return new Queue(DenemeQueueListener.DENEME_QUEUE);
	}
	
}
