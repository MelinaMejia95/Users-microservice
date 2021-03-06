/**
 * NOTE: This class is auto generated by the swagger code generator program (2.3.1).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.JsonApiBodyRequest;
import io.swagger.model.JsonApiBodyResponseErrors;
import io.swagger.model.JsonApiBodyResponseSuccess;
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

@Api(value = "updateUser", description = "the updateUser API")
public interface UpdateUserApi {

    @ApiOperation(value = "Update user in the database", nickname = "updateUserPut", notes = "Update user in the database", response = JsonApiBodyResponseSuccess.class, tags={ "Users", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Ok", response = JsonApiBodyResponseSuccess.class),
        @ApiResponse(code = 404, message = "Failed", response = JsonApiBodyResponseErrors.class) })
    @RequestMapping(value = "/updateUser",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<?> updateUserPut(@ApiParam(value = "" ,required=true )  @Valid @RequestBody JsonApiBodyRequest body);

}
