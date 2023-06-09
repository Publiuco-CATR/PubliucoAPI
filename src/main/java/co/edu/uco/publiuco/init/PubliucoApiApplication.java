package co.edu.uco.publiuco.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.publiuco"})
public class PubliucoApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PubliucoApiApplication.class, args);
	}

}
