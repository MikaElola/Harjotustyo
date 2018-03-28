package hh.Harjotustyo.harjotustyo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import hh.Harjotustyo.harjotustyo.webcontroller.HarjotustyoController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HarjotustyoApplicationTests {
	@Autowired
	private HarjotustyoController contr;
	
	@Test
	public void controllerLoads() throws Exception{
		assertThat(contr).isNotNull();
	}
	
	
	@Test
	public void contextLoads() {
	}

}
