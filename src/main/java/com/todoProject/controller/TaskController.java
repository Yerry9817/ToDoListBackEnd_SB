/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.todoProject.controller;

import com.todoProject.persistance.entity.Task;
import com.todoProject.persistance.entity.TaskStatus;
import com.todoProject.service.TaskService;
import com.todoProject.service.dto.TaskInDTO;
import java.net.http.HttpResponse;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author YERRYRODRIGUEZBARQUE
 */
@RestController
@RequestMapping(path = "tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/add")
    public Task createTask(@RequestBody TaskInDTO taskInDTO) {
        System.out.println("TaskDTO.tittle " + taskInDTO.getDescription());
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> getTasks() {
        return this.taskService.getAllTasks();
    }

    @GetMapping("/{status}")
    public List<Task> getTasks(@PathVariable("status") TaskStatus status) {
        return this.taskService.getAllByTaskStatus(status);
    }

    //Patch porque solo se actualiza una parte del registro
    @PatchMapping(path = ("setCompleted/{id}"))
    //ResponseEntity para returnar el 204
    public ResponseEntity<Void>setTaskAsCompleted(@PathVariable("id")Long id) {
        this.taskService.setTaskAsCompleted(id);
        return ResponseEntity.noContent().build(); //Retorna 204 siempre
    }
    
    @DeleteMapping(path ="/delete/{id}")
    //ResponseEntity para returnar el 204
    public ResponseEntity<Void>delete(@PathVariable("id")Long id) {
        this.taskService.deleteTask(id);
        return ResponseEntity.noContent().build(); //Retorna 204 siempre
    }

}
