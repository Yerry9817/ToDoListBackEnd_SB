/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todoProject.service;

import com.todoProject.exceptions.ToDoExeptions;
import com.todoProject.mapper.TaskInDTOToTask;
import com.todoProject.persistance.entity.Task;
import com.todoProject.persistance.entity.TaskStatus;
import com.todoProject.persistance.entity.repository.TaskRepository;
import com.todoProject.service.dto.TaskInDTO;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author YERRYRODRIGUEZBARQUE
 */
@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository taskRepository, TaskInDTOToTask mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }
    
    public Task createTask(TaskInDTO taskInDTO){
        //task repository espera un obj de tipo task, se necesita mapear 
        //taskInDTO a tipo Task
        Task task = mapper.map(taskInDTO);
        return this.taskRepository.save(task);
    }
    
    public List<Task> getAllTasks(){
        return this.taskRepository.findAll();
    }
    
    public List<Task> getAllByTaskStatus(TaskStatus status){
        return this.taskRepository.findAllByTaskStatus(status);
    }
    
    @Transactional
    public void setTaskAsCompleted(Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExeptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.setFastAsCompleted(id);
    }
    
    public void deleteTask(Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExeptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.deleteById(id);
    }
}
