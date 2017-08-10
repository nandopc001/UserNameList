/**
 * 
 */
package com.intertec.listusername.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intertec.listusername.model.Result;
import com.intertec.listusername.model.User;
import com.intertec.listusername.service.ResultService;
import com.intertec.listusername.service.UserService;

/**
 * @author nandopc001
 *
 */
@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@Autowired
	ResultService resultService;
	
	@RequestMapping(value = "/add_user", method = RequestMethod.GET)
	public ModelAndView addUser(User user, Result result){
		ModelAndView mv = new ModelAndView();
		mv.addObject("user", user);
		mv.addObject("results", result.getSugestion());
		mv.addObject("message", result.getMesssage());
		mv.setViewName("crud_user");		
		return mv;		
	}
	
	@PostMapping("/add_user")
	public ModelAndView saveUser(@Valid User user, BindingResult resul){
		 if(resul.hasErrors()) {
	            return addUser(user, new Result());
	        }
		Result result = resultService.checkUsername(user.getName());
		if(result.isValid()){
			userService.addUser(user.getName());
		}
		return addUser(user,result);
		
	}	

}
