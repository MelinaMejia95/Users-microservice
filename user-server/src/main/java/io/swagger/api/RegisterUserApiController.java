package io.swagger.api;

import io.swagger.model.JsonApiBodyRequest;
import io.swagger.model.JsonApiBodyResponseErrors;
import io.swagger.model.JsonApiBodyResponseSuccess;
import io.swagger.model.RegUser;
import io.swagger.repository.api.UserRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-09T02:06:01.913Z")

@Controller
public class RegisterUserApiController implements RegisterUserApi {
	
	@Autowired
	UserRepository userRepo;

    private static final Logger log = LoggerFactory.getLogger(RegisterUserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public RegisterUserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> registerUserPost(@ApiParam(value = "body" ,required=true )  @Valid @RequestBody JsonApiBodyRequest body) {
        String accept = request.getHeader("Accept");
        JsonApiBodyResponseErrors error = new JsonApiBodyResponseErrors();
        JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess();
        RegUser users = userRepo.findOne(body.getUsers().get(0).getId());
        System.out.println(users);
        if (accept != null && accept.contains("application/json")) {
           if (users == null) {
        	   if (body.getUsers().get(0).getId().matches("^[0-9]")) {
          		   RegUser user = userRepo.save(body.getUsers().get(0));
          		   responseSuccess.setId(body.getUsers().get(0).getId());
          		   responseSuccess.setName(body.getUsers().get(0).getName());
          		   return new ResponseEntity<JsonApiBodyResponseSuccess>(responseSuccess, HttpStatus.OK);
          	   } else {
          		   error.setCode("00");
          		   error.setDetail("User Id is not a number");
          		   return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.CONFLICT);
          	   }
           } else {
        	   error.setCode("01");
        	   error.setDetail("User is already in the database");
        	   return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.CONFLICT);
           }
        }

        return new ResponseEntity<JsonApiBodyResponseSuccess>(HttpStatus.NOT_IMPLEMENTED);
    }


}
