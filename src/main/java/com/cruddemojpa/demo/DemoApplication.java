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
//			saveStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			displayStudent(studentDAO);
//			getByLastName(studentDAO);
//			updateStudent(studentDAO);
//			deleteStudent(studentDAO);
			deleteAllStudents(studentDAO);

		};

	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int rowsDeleted = studentDAO.deleteAll();
		System.out.println(rowsDeleted+" students deleted");
	}

	private void deleteStudent(StudentDAO studentDAO) {
//		get student to be deleted by id
		int studentId = 1;
//		delete the given student
		studentDAO.delete(studentId);
	}

	public void createMultipleStudents(StudentDAO studentDAO){
		Student[] studentsList = {
				new Student("Philip","Bukki","philipbukkie@gmail.com"),
				new Student("Veronica","Mukami","philipbukkie@gmail.com"),
				new Student("Jade","One","philipbukkie@gmail.com")
		};
		for(Student student: studentsList){
			studentDAO.save(student);
			System.out.println(student);
		}


	}
	public void saveStudent(StudentDAO studentDAO){
		Student phil = new Student("Philip","Bukki","philipbukkie@gmail.com");
		studentDAO.save(phil);
		System.out.println(phil);

	}
	public void displayStudent(StudentDAO studentDAO){
//		Student phil = new Student("Philip","Bukki","philipbukkie@gmail.com");
//		studentDAO.save(phil);

		Student stud = studentDAO.findById(1);
		System.out.println(stud.getFirstName());

	}

	public void getByLastName(StudentDAO studentDAO){

		studentDAO.findByLastName("Bukki");
	}

	public void updateStudent(StudentDAO studentDAO){
        // get student with id 1
		int studentId = 1;
		Student theStudent = studentDAO.findById(studentId);

        //update firstName of that student
		theStudent.setFirstName("Zac");
		studentDAO.update(theStudent);
        // print updated student details
		System.out.println(theStudent);

	}

}
