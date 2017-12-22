package hu.kalee.timeside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Application.
 *
 * @author mkalinovits
 * @since 2017. 12. 22.
 */
@SpringBootApplication
@EnableJpaRepositories
public class Application {
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
