package erdemc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class AngularFrontEndForSpring1Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AngularFrontEndForSpring1Application.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AngularFrontEndForSpring1Application.class);
    }
}
