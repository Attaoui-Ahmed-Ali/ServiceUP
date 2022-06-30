package ma.ac.emi.ginf.exam;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import ma.ac.emi.ginf.exam.models.User;
import ma.ac.emi.ginf.exam.repositories.UserRepository;

@SpringBootApplication
public class ExamApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamApplication.class, args);
	}
	
	@Autowired
	UserRepository ur;
	
	
	@Bean
	public CommandLineRunner console() {
		return args -> {
			System.out.println("-----------------Execution-----------");
			User eleve = ur.findUser("admin", "admin");
			System.out.println(eleve);
			
			System.out.println("--------------Fin---------------");

			new Scanner(System.in).next();
		};
	}
}
