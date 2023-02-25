package anpopo.naranji.ft.naranjift.config;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaAuditing
@EnableJpaRepositories(basePackages = "anpopo.naranji.ft.naranjift.domains")
public class JpaConfig {

}
