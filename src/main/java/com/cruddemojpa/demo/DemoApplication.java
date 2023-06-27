package com.cruddemojpa.demo;

import com.cruddemojpa.demo.dao.StudentDAO;
import com.cruddemojpa.demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    @Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
			saveStudent(studentDAO);

		};

	}

	public void saveStudent(StudentDAO studentDAO){
		Student phil = new Student("Philip","Bukki","philipbukkie@gmail.com");
		studentDAO.save(phil);
		System.out.println(phil);

	}

}
