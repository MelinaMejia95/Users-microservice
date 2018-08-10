package io.swagger.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.model.JsonApiBodyRequest;
import io.swagger.model.JsonApiBodyResponseErrors;
import io.swagger.model.JsonApiBodyResponseSuccess;

@Api(value = "loginUser", description = "the loginUser API")
public interface LoginApi {
	
	 @ApiOperation(value = "Login", nickname = "loginUserPost", notes = "Login", response = JsonApiBodyResponseSuccess.class, tags={ "Users", })
	    @ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "Ok", response = JsonApiBodyResponseSuccess.class),
	        @ApiResponse(code = 404, message = "Failed", response = JsonApiBodyResponseErrors.class) })
	    @RequestMapping(value = "/login",
	        produces = { "application/json" }, 
	        consumes = { "application/json" },
	        method = RequestMethod.PUT)
	    ResponseEntity<?> loginUserPut(@ApiParam(value = "body" ,required=true )  @Valid @RequestBody JsonApiBodyRequest body);
	 
	 @ApiOperation(value = "Logout", nickname = "logoutUserPost", notes = "Logout", response = JsonApiBodyResponseSuccess.class, tags={ "Users", })
	    @ApiResponses(value = { 
	        @ApiResponse(code = 200, message = "Ok", response = JsonApiBodyResponseSuccess.class),
	        @ApiResponse(code = 404, message = "Failed", response = JsonApiBodyResponseErrors.class) })
	    @RequestMapping(value = "/logout",
	        produces = { "application/json" }, 
	        consumes = { "application/json" },
	        method = RequestMethod.PUT)
	    ResponseEntity<?> logoutUserPut(@ApiParam(value = "body" ,required=true )  @Valid @RequestBody JsonApiBodyRequest body);

}
