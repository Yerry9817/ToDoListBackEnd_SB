/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todoProject.mapper;

import com.todoProject.persistance.entity.Task;
import com.todoProject.persistance.entity.TaskStatus;
import com.todoProject.service.dto.TaskInDTO;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.stereotype.Component;

/**
 *
 * @author YERRYRODRIGUEZBARQUE
 */

//Se declara como un componente para poder inyectarlo en el controlador
@Component
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task> {

    @Override
    public Task map(TaskInDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setCreatedDate(LocalDateTime.now());
        task.setIsCompleted(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
    
}
