package com.wit.ctw.basic;

import com.wit.ctw.basic.web.mapper.sc.BookMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={BootBasicApplication.class})
class BootBasicApplicationTests {

	@Autowired
	BookMapper bookMapper;

	@Test
	void contextLoads() {
		System.out.println(bookMapper.selectByPrimaryKey("1"));
	}

}
