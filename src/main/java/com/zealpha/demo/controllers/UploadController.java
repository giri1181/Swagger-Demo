
package com.zealpha.demo.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zealpha.demo.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/v1")
@Api(description = "Application API", value = "Application API")
public class UploadController {

    @ApiOperation(produces = "application/json", value = "Upload file")
    @RequestMapping(value = "/uploads", method = RequestMethod.POST, consumes = "multipart/form-data")
    @ApiImplicitParams(@ApiImplicitParam(dataType = "file", name = "file", paramType = "body"))
    @ApiResponses({ @ApiResponse(code = 413, message = "File is larger than max allowed limit") })
    public void upload(@ApiIgnore @RequestBody(required = true) MultipartFile file, HttpServletResponse response) {

        try {
            System.out.println("Uploading file to server");
        } catch (Exception e) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @ApiOperation(produces = "application/json", value = "Get User Details", notes = "Get User by Id")
    @RequestMapping(method = RequestMethod.GET, value = "user/{userId}")
    public ResponseEntity<User> getUserDetail(@PathVariable String userId) throws Exception {
        return ResponseEntity.ok(new User(userId,"TestUser", "27 New Road", "Demo"));
    }

}
