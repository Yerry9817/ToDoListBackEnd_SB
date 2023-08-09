/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todoProject.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author YERRYRODRIGUEZBARQUE
 */

/*
    El exception Handler Maneja los errores del servidor de manera optima
    Si lanzamos un error notFound en la respuesta del servidor sera un estatu 404
*/

@ControllerAdvice
public class ExeptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ToDoExeptions.class})
    protected ResponseEntity<Object> handleConflict(
            ToDoExeptions ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), ex.getHttpStatus(), request);
    }
}
