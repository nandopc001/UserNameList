/**
 * 
 */
package com.intertec.listusername.service;

import java.util.List;

/**
 * @author nandopc001
 *
 */
public interface UtilService {
	List<String> sugestUsername(String name, List<String> nameRestrict);

	List<String> getListSugestion(String name);
}
