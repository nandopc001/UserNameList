/**
 * 
 */
package com.intertec.listusername.service;

import java.util.List;

/**
 * @author nandopc001
 *
 */
public interface WordRestrictService {
	
	boolean containsWordRestrict(String name);

	List<String> findAll();
}
