package com.intertec.listusername.username;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.intertec.listusername.model.Result;
import com.intertec.listusername.model.User;
import com.intertec.listusername.model.WordRestrict;
import com.intertec.listusername.repository.WordRestrictRepository;
import com.intertec.listusername.service.ResultService;
import com.intertec.listusername.service.UserService;
import com.intertec.listusername.service.UtilService;
import com.intertec.listusername.service.WordRestrictService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UsernameApplicationTests {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ResultService resultService;
	
	@Autowired
	UtilService utilService;
	
	@Autowired
	WordRestrictRepository wordRestrictRepository;
	
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void  UserNameAlreadyExist() {
		User user = new User();
		user.setName("Username");
		userService.addUser(user.getName());
		Result result = resultService.checkUsername(user.getName());
		assertFalse(result.isValid());
		assertNotNull(result.getSugestion());
		assertEquals("Username already taken, suggestion:", result.getMesssage());
	}
	
	@Test
	public void  UserNameSaveSucess() {
		User user = new User();
		user.setName("Usernamenew");
		Result result = resultService.checkUsername(user.getName());
		assertTrue(result.isValid());
		assertNull(result.getSugestion());
	}
	
	@Test
	public void  WordRestrictAdd() {
		WordRestrict wordRestrict = new WordRestrict();
		wordRestrict.setWord("sexy");
		wordRestrict = wordRestrictRepository.save(wordRestrict);
		assertNotNull(wordRestrict.getId());
		Result result = resultService.checkUsername("Usernamesexyaaa");
		assertFalse(result.isValid());
		assertEquals("Restricted words:", result.getMesssage());
	}

}
