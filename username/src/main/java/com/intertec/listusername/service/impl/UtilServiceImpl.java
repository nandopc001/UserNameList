/**
 * 
 */
package com.intertec.listusername.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intertec.listusername.repository.UserRepository;
import com.intertec.listusername.service.UtilService;
import com.intertec.listusername.service.WordRestrictService;

/**
 * @author nandopc001
 *
 */
@Service
public class UtilServiceImpl implements UtilService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.intertec.listusername.service.Util#sugestUsername(java.lang.String)
	 */
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	WordRestrictService wordRestrictService;
	
	@Override
	public List<String> sugestUsername(String name, List<String> nameRestrict) {
		// TODO Auto-generated method stub
		Random generator = new Random();
		int x = 0;
		int a = 0;
		List<String> resultUsernames = new ArrayList<>();
		while (resultUsernames.size() < 14) {
			x = generator.nextInt();
			a = (x % 100);
			StringBuffer nameAux = new StringBuffer();
			nameAux.append(name);
			nameAux.append(String.valueOf(Math.abs(a)));
			if (!nameRestrict.contains(nameAux.toString())) {
				resultUsernames.add(nameAux.toString());
				nameRestrict.add(nameAux.toString());
			}
		}
		return resultUsernames.stream().sorted().collect(Collectors.toList());
	}

	@Override
	public List<String> getListSugestion(String name) {
		List<String> nameRestrict = userRepository.findUserByNameLike(name);
		nameRestrict.addAll(wordRestrictService.findAll());
		return this.sugestUsername(name, nameRestrict);

	}
}
