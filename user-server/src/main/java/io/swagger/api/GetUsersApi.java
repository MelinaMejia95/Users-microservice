/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.JsonApiBodyRequest;
import io.swagger.model.JsonApiBodyResponseErrors;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-08-09T02:06:01.913Z")

@Api(value = "getUsers", description = "the getUsers API")
public interface GetUsersApi {

    @ApiOperation(value = "Get users from the database", nickname = "getUsersGet", notes = "Get users from the database", response = JsonApiBodyRequest.class, tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok", response = JsonApiBodyRequest.class),
        @ApiResponse(code = 404, message = "Movie doesn't exist", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/getUsers",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> getUsersGet();


    @ApiOperation(value = "Get movie by User", nickname = "getUsersIdGet", notes = "Get movie by User", response = JsonApiBodyRequest.class, tags={ "Movies", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok", response = JsonApiBodyRequest.class),
        @ApiResponse(code = 404, message = "Movie doesn't exist", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/getUsers/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<?> getUsersIdGet(@ApiParam(value = "User id",required=true) @PathVariable("id") String id);

}
