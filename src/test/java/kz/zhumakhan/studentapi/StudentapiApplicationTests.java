package kz.zhumakhan.studentapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentapiApplicationTests {

	@Test
	void contextLoads() {
	}
 @Test
    void studentNameTest() {
        org.junit.jupiter.api.Assertions.assertEquals("Zhasulan", "WrongName");
    }
}
