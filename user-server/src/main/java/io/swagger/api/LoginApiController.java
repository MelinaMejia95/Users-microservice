package io.swagger.api;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.model.JsonApiBodyRequest;
import io.swagger.model.JsonApiBodyResponseErrors;
import io.swagger.model.JsonApiBodyResponseSuccess;
import io.swagger.model.RegUser;
import io.swagger.repository.api.UserRepository;

@Controller
public class LoginApiController implements LoginApi{
	
	@Autowired
	UserRepository userRepo;

    private static final Logger log = LoggerFactory.getLogger(LoginApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public LoginApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

	public ResponseEntity<?> loginUserPut(@ApiParam(value = "body" ,required=true )  @RequestBody JsonApiBodyRequest body) {
		String accept = request.getHeader("Accept");
        JsonApiBodyResponseErrors error = new JsonApiBodyResponseErrors();
        JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess();
        if (accept != null && accept.contains("application/json")) {
        	List<RegUser> user = userRepo.findByEmail(body.getEmail());
        	System.out.println(user.get(0));
        	if (user.get(0).getEmail().equals(body.getEmail()) && user.get(0).getPassword().equals(body.getPassword())) {
        		SecureRandom random = new SecureRandom();
        		byte bytes[] = new byte[20];
        		random.nextBytes(bytes);
        		String token = bytes.toString();
        		System.out.println(token);
        		user.get(0).setToken(token);
        		userRepo.save(user);
        		responseSuccess.setId(user.get(0).getId());
        		responseSuccess.setName(user.get(0).getName());
        		return new ResponseEntity<JsonApiBodyResponseSuccess>(responseSuccess, HttpStatus.OK);
        	} else {
        		error.setCode("06");
        		error.setDetail("Email or password incorrect");
        		return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.CONFLICT);
        	}
        }
		return null;
	}

	public ResponseEntity<?> logoutUserPut(@ApiParam(value = "body" ,required=true )  @RequestBody JsonApiBodyRequest body) {
		String accept = request.getHeader("Accept");
        JsonApiBodyResponseErrors error = new JsonApiBodyResponseErrors();
        JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess();
        if (accept != null && accept.contains("application/json")) {
        	List<RegUser> user = userRepo.findByEmail(body.getEmail());
        	System.out.println(user.get(0));
        	if (user.get(0).getEmail().equals(body.getEmail())) {
        		user.get(0).setToken("");
        		userRepo.save(user);
        		responseSuccess.setId(user.get(0).getId());
        		responseSuccess.setName(user.get(0).getName());
        		return new ResponseEntity<JsonApiBodyResponseSuccess>(responseSuccess, HttpStatus.OK);
        	} else {
        		error.setCode("07");
        		error.setDetail("Can't logout");
        		return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.CONFLICT);
        	}
        }
		return null;
	}

}
