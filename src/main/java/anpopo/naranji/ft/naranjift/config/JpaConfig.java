package anpopo.naranji.ft.naranjift.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "anpopo.naranji.ft.naranjift.domains")
public class JpaConfig {

}
