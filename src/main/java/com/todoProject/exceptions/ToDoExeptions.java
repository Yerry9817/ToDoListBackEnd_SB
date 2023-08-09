/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todoProject.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 *
 * @author YERRYRODRIGUEZBARQUE
 */

//clase para crear exceptions personalizables
 //para que cree los getters y setters
@Data
public class ToDoExeptions extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public ToDoExeptions(String message, HttpStatus httpStatus) {
        super(message);
        this.message = message;
        this.httpStatus = httpStatus;
    }

    
    
    
}
