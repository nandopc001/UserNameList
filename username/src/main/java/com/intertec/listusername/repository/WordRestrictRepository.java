/**
 * 
 */
package com.intertec.listusername.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intertec.listusername.model.WordRestrict;

/**
 * @author nandopc001
 *
 */
@RepositoryRestResource
public interface WordRestrictRepository extends JpaRepository<WordRestrict, Long> {

	@Query("SELECT w.word FROM WordRestrict w")
	List<String> findAllWord();

	
}
