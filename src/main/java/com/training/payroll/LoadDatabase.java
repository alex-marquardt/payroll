package com.training.payroll;

import com.training.payroll.model.Employee;
import com.training.payroll.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Employee("Mette Frederiksen", "Partiformand")));
            log.info("Preloading " + repository.save(new Employee("Mogens Jensen", "Næsteformand")));
            log.info("Preloading " + repository.save(new Employee("Marie Stærke", "Næsteformand")));
            log.info("Preloading " + repository.save(new Employee("Lasse Ryberg", "Generalsekretær")));
            log.info("Preloading " + repository.save(new Employee("Rasmus Stoklund", "Politisk ordfører")));
        };
    }
}
