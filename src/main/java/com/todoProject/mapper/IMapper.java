/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.todoProject.mapper;

/**
 *
 * @author YERRYRODRIGUEZBARQUE
 */
public interface IMapper<I,O>{
    public O map(I in);
}
