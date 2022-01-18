package com.quasar.controller;

import com.quasar.entities.Nave;
import com.quasar.exceptions.ExceptionLocalizar;
import com.quasar.exceptions.MensajeException;
import org.springframework.http.RequestEntity;

public interface Response {

    public Nave getResponse(RequestEntity requestEntity) throws MensajeException, ExceptionLocalizar;
}
