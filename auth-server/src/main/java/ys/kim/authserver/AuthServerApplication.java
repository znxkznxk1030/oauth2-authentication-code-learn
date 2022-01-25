package ys.kim.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ys.kim.authserver.db.JdbcProperties;

@SpringBootApplication
@EnableConfigurationProperties(JdbcProperties.class)
public class AuthServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}
}
