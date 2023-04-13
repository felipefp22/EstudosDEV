package com.felipefp2.userDepartment;

// import com.felipefp2.userDepartment.controllers.UserController;
import com.felipefp2.userDepartment.entities.Department;
import com.felipefp2.userDepartment.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UserDepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDepartmentApplication.class, args);


//		UserController userController = new UserController();
//
//		List<User> usuarios = new ArrayList<User>();
//		usuarios = userController.findAll();
//		System.out.println(usuarios);
	}

}
//https://www.youtube.com/watch?v=D4frmIHAxEY