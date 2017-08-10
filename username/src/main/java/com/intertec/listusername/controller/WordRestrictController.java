/**
 * 
 */
package com.intertec.listusername.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intertec.listusername.model.WordRestrict;
import com.intertec.listusername.repository.WordRestrictRepository;

/**
 * @author nandopc001
 *
 */
@Controller
public class WordRestrictController {
	
	@Autowired
	WordRestrictRepository wordRestrictRepository;
	
	@RequestMapping(value = "/add_word_restrict", method = RequestMethod.POST)
	public ResponseEntity<?> addWordRestrict(@Param("wordRestrict") String wordRestrict){
		WordRestrict word = new WordRestrict();
		word.setWord(wordRestrict);
		return new ResponseEntity<>(wordRestrictRepository.save(word), HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/rem_word_restrict", method = RequestMethod.POST)
	public ResponseEntity<?> delWordRestrict(@Param("wordRestrict") String wordRestrict){
		WordRestrict word = new WordRestrict();
		word.setWord(wordRestrict);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

}
