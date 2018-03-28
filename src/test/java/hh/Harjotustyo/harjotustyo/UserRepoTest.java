package hh.Harjotustyo.harjotustyo;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.Harjotustyo.harjotustyo.domain.User;
import hh.Harjotustyo.harjotustyo.domain.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepoTest {

		@Autowired
		private UserRepository urepo;
		
	@Test
	public void findbyUserName(){
		User user = urepo.findByUsername("admin");
		assertThat(user).isNotNull();
	}
	
	@Test
	public void createNew(){
		User user = new User("test", "test", "testi");
		urepo.save(user);
		List<User> users = (List<User>) urepo.findAll();
		assertThat(users).hasSize(3);
	}
	
	@Test
	public void delete(){
		User user = urepo.findByUsername("user");
		urepo.delete(user);
		User user2 = urepo.findByUsername("user");
		assertThat(user2).isNull();
		
	}
}
