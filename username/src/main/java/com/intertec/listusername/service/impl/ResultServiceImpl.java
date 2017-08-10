/**
 * 
 */
package com.intertec.listusername.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intertec.listusername.model.Result;
import com.intertec.listusername.repository.UserRepository;
import com.intertec.listusername.service.ResultService;
import com.intertec.listusername.service.UtilService;
import com.intertec.listusername.service.WordRestrictService;

/**
 * @author nandopc001
 *
 */
@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	WordRestrictService wordRestrictService;

	@Autowired
	UtilService utilService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.intertec.listusername.service.ResultService#checkUsername(java.lang.
	 * String)
	 */
	@Override
	public Result checkUsername(String name) {
		// TODO Auto-generated method stub
		Result result = new Result();
		result.setValid(false);
		if (!wordRestrictService.containsWordRestrict(name)) {
			if (userRepository.findUserByName(name) == null) {
				result.setValid(true);
			} else {
				result.setMesssage("Username already taken, suggestion:");
				result.setSugestion(utilService.getListSugestion(name));
			}

		} else {
			result.setMesssage("Restricted words:");
			result.setSugestion(wordRestrictService.findAll());
		}
		return result;
	}

}
