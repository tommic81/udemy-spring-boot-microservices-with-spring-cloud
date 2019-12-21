package guru.springframework.msscbrewery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsscBreweryApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(UUID.randomUUID());
	}

}
