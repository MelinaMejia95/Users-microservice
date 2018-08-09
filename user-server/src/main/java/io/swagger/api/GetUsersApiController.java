package io.swagger.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.model.JsonApiBodyRequest;
import io.swagger.model.JsonApiBodyResponseErrors;
import io.swagger.model.RegUser;
import io.swagger.repository.api.UserRepository;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-09T02:06:01.913Z")

@Controller
public class GetUsersApiController implements GetUsersApi {
	
	@Autowired
	UserRepository userRepo;

    private static final Logger log = LoggerFactory.getLogger(GetUsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GetUsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> getUsersGet() {
        String accept = request.getHeader("Accept");
        JsonApiBodyResponseErrors error = new JsonApiBodyResponseErrors();
        List<RegUser> users = (List<RegUser>) userRepo.findAll();
        if (accept != null && accept.contains("application/json")) {
        	if(users == null) {
        		error.setCode("03");
        		error.setDetail("Database is empty");
        		return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.NOT_FOUND);
        	} else {
        		JsonApiBodyRequest body = new JsonApiBodyRequest();
        		body.setUsers(users);
        		return new ResponseEntity<JsonApiBodyRequest>(body, HttpStatus.OK);
        	}
            
        }

        return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<?> getUsersIdGet(@ApiParam(value = "User id",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        JsonApiBodyResponseErrors error = new JsonApiBodyResponseErrors();
        RegUser user = userRepo.findOne(id);
        if (accept != null && accept.contains("application/json")) {
            if (user == null) {
            	error.setCode("04");
            	error.setDetail("User doesn't exist");
            	return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.CONFLICT);
            } else {
            	JsonApiBodyRequest body = new JsonApiBodyRequest();
            	List<RegUser> users = new ArrayList<RegUser>();
            	users.add(user);
            	body.setUsers(users);
            	return new ResponseEntity<JsonApiBodyRequest>(body, HttpStatus.OK);
            }
        }

        return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

}
