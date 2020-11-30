package ru.itsjava.hibernate.services;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.itsjava.hibernate.services.model.Mail;
import ru.itsjava.hibernate.services.model.Pet;
import ru.itsjava.hibernate.services.model.User;
import ru.itsjava.hibernate.services.services.UserService;
import ru.itsjava.hibernate.services.services.UserServiceImpl;

import java.sql.SQLException;


@SpringBootApplication
public class HibernateApplication {

	public static void main(String[] args) throws SQLException {
		var context = SpringApplication.run(HibernateApplication.class, args);
		Mail mail = new Mail(0l, "alex@mail.ru");
		Pet pet = new Pet(0l,"Cat", "Musya");
		User user = new User(0l, "Alex", 27, mail, pet);
		UserService userService = context.getBean(UserServiceImpl.class);
		userService.createUser(user);
		Console.main(args);
	}

}