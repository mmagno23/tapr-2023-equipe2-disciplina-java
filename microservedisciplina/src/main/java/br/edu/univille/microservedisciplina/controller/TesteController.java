package br.edu.univille.microservedisciplina.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.cosmos.implementation.HttpConstants.StatusCodes;

@RestController
@RequestMapping("/")
public class TesteController {
    
    @GetMapping
    public ResponseEntity index(){

        return new ResponseEntity("OK",HttpStatus.OK);
    }
}
