package ma.ac.emi.ginf.exam;

import java.util.Scanner;

import ma.ac.emi.ginf.exam.models.UserType;
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
			ur.save(new User("hamzachafkan@student.emi.ac.ma", "Hamza CHAFKAN","123", UserType.Etudiant));
			ur.save(new User("hamzachafkan@emi.ac.ma", "Hamza CHAFKAN","123", UserType.Enseignant));
			ur.save(new User("hamzachafkan1@student.emi.ac.ma", "Hamza CHAFKAN","123", UserType.Etudiant));
			ur.save(new User("hamzachafkan2@student.emi.ac.ma", "Hamza CHAFKAN","123", UserType.Etudiant));
//			ur.save()
		};
	}
}
