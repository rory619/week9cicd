package ie.atu.week9cicd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "ie.atu.week9cicd")
public class Week9cicdApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week9cicdApplication.class, args);
	}

}
