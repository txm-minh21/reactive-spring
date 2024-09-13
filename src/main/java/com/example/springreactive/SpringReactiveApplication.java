package com.example.springreactive;

import com.example.springreactive.student.Student;
import com.example.springreactive.student.StudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringReactiveApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentService studentService) {
		return args -> {
			for (int i = 0; i < 100; i++) {
				studentService.save(
						Student.builder()
								.firstname("Txm " + i)
								.lastname("Minh " + i)
								.age(i)
								.build()
				).subscribe();
			}
		};
	}
}
