/**
 * 
 */
package com.intertec.listusername.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intertec.listusername.model.WordRestrict;
import com.intertec.listusername.repository.WordRestrictRepository;
import com.intertec.listusername.service.WordRestrictService;

/**
 * @author nandopc001
 *
 */
@Service
public class WordRestrictServiceImpl implements WordRestrictService {
	
	@Autowired
	WordRestrictRepository wordRestrictRepository;
	/* (non-Javadoc)
	 * @see com.intertec.listusername.service.WordRestrictService#checkContainsWordRestrict(java.lang.String)
	 */
	@Override
	public boolean containsWordRestrict(String name) {
		// TODO Auto-generated method stub
		List<WordRestrict> wordRestrict = wordRestrictRepository.findAll();
		return wordRestrict.stream().anyMatch(t -> name.contains(t.getWord().toLowerCase()));
	}
	@Override
	public List<String> findAll() {
		// TODO Auto-generated method stub
		 
		return wordRestrictRepository.findAllWord();
	}

}
