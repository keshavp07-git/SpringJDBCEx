package com.keshav.SpringJDBCEx;

import com.keshav.SpringJDBCEx.Service.StudentService;
import com.keshav.SpringJDBCEx.models.Students;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
public class SpringJdbcExApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcExApplication.class, args);
		Students s = context.getBean(Students.class);
		s.setMarks(90);
		s.setName("Keshav");
		s.setRollNo(101);

		StudentService service = context.getBean(StudentService.class);
		service.addStudents(s);

		List<Students> students = service.getstudents();
		System.out.println(students);
	}

}
