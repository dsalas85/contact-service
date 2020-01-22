package com.example.demo.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class GlobalController
{

    @ApiOperation( value = "health check for the service. Should return 'pong'", response = String.class )
    @ApiResponses( value = { @ApiResponse( code = 200, message = "Service is working properly" ) } )
    @GetMapping( value = "/ping" )
    public String ping()
    {
        String response = "pong";
        return response;
    }
}
