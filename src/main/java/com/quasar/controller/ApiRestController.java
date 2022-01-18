package com.quasar.controller;

import com.quasar.entities.DistanciaSatelite;
import com.quasar.exceptions.ExceptionLocalizar;
import com.quasar.exceptions.MensajeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(path = "api/topsecret")
public class ApiRestController {

    @Autowired
    private Response Res;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity topSecret(RequestEntity<DistanciaSatelite> requestEntity) {

        try {
            return ResponseEntity.status(HttpStatus.OK).body(Res.getResponse(requestEntity));

        } catch (MensajeException e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
            
        } catch (ExceptionLocalizar e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }
}
