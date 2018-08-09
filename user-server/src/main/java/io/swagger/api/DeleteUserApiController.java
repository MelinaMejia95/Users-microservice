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
import java.util.ArrayList;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-09T02:06:01.913Z")

@Controller
public class DeleteUserApiController implements DeleteUserApi {
	
	@Autowired
	UserRepository userRepo;

    private static final Logger log = LoggerFactory.getLogger(DeleteUserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public DeleteUserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<?> deleteUserIdDelete(@ApiParam(value = "User Id",required=true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        JsonApiBodyResponseErrors error = new JsonApiBodyResponseErrors();
        JsonApiBodyResponseSuccess responseSuccess = new JsonApiBodyResponseSuccess();
        if (accept != null && accept.contains("application/json")) {
           RegUser user = userRepo.findOne(id);
           if (user == null) {
        	   error.setCode("04");
        	   error.setDetail("User doesn't exist");
        	   return new ResponseEntity<JsonApiBodyResponseErrors>(error, HttpStatus.CONFLICT);
           } else {
        	   List<RegUser> users = new ArrayList<RegUser>();
        	   users.add(user);
        	   userRepo.delete(users.get(0).getId());
        	   responseSuccess.setId(users.get(0).getId());
        	   responseSuccess.setName(users.get(0).getName());
        	   return new ResponseEntity<JsonApiBodyResponseSuccess>(responseSuccess, HttpStatus.OK);
           }
        }

        return new ResponseEntity<JsonApiBodyRequest>(HttpStatus.NOT_IMPLEMENTED);
    }

}
