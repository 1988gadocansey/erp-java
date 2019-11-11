package application;

import application.services.CollegeService;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;
import application.entities.Message;
import application.repositories.MessageRepository;
import application.entities.User;
import application.entities.College;
import application.repositories.UserRepository;

/**
 * @author Rob Winch
 */
@Component
class MongoInitiailizer implements SmartInitializingSingleton {
	private final MessageRepository messages;
	private final UserRepository users;
	private final CollegeService college;

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
		College col=new College("Science","SCI");
		this.college.saveCollege(col);
		this.users.save(rob).block();
		this.users.save(joe).block();

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
