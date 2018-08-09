package io.swagger.repository.api;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import io.swagger.model.RegUser;;

@EnableScan
public interface UserRepository extends CrudRepository<RegUser, String>{
	
	public List<RegUser> findByType(String type);

}
