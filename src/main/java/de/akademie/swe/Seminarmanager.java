package de.akademie.swe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import de.akademie.swe.core.domain.Adresse;
import de.akademie.swe.core.domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.Date;
@SpringBootApplication
public class Seminarmanager {
    public static void main(String[] args) {

        SpringApplication.run(Seminarmanager.class,args);
    }

}
