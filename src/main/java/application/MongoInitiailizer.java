package application;

import application.entities.*;
import application.repositories.StudentRepository;
import application.services.CollegeService;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import application.repositories.MessageRepository;
import application.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author Gad Ocansey
 */
@Component
class MongoInitiailizer implements SmartInitializingSingleton {
	private final MessageRepository messages;
	private final UserRepository users;
	private final CollegeService college;

	@Autowired
	private StudentRepository studentRepository;
	MongoInitiailizer(MessageRepository messages, UserRepository users,CollegeService college) {
		this.messages = messages;
		this.users = users;
		this.college=college;
	}

	@Override
	public void afterSingletonsInstantiated() {
		// sha256 w/ salt encoded "password"
		String passsword = "73ac8218b92f7494366bf3a03c0c2ee2095d0c03a29cb34c95da327c7aa17173248af74d46ba2d4c";

		User rob = new User(1L, "rob@example.com", passsword, "Rob", "Winch");
		User joe = new User(100L, "joe@example.com", passsword, "Joe", "Grandja");
		User gad = new User(200L, "gadocansey@gmail.com", "password", "Gad", "Ocansey");
		College col=new College("Science","SCI");
		College col2=new College("Business","BUS");
		this.college.saveCollege(col);
		this.college.saveCollege(col2);
		this.users.save(rob).block();
		this.users.save(joe).block();
		this.users.save(gad).block();

		this.messages.save(new Message(1L, rob, joe, "Hello World")).block();
		this.messages.save(new Message(2L, rob, joe,"Greetings KCDC")).block();

		// @formatter:off
		this.users.findAll()
				.doOnNext(user -> user.setPassword("{sha256}" + user.getPassword()))
				.flatMap(this.users::save)
				.collectList()
				.block();
		// @formatter:on


	}
}
