/**
 * 
 */
package com.intertec.listusername.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.intertec.listusername.model.User;

/**
 * @author nandopc001
 *
 */
@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query("SELECT u.name FROM User u WHERE u.name LIKE CONCAT(:name,'%')")
	List<String> findUserByNameLike(@Param("name") String name);
	
	User findUserByName(String name);

}
