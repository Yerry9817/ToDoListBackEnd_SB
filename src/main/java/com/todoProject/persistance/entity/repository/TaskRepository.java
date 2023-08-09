/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.todoProject.persistance.entity.repository;

import com.todoProject.persistance.entity.Task;
import com.todoProject.persistance.entity.TaskStatus;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author YERRYRODRIGUEZBARQUE
 */
public interface TaskRepository extends JpaRepository<Task, Long>{
    public List<Task> findAllByTaskStatus(TaskStatus status);
    
    //este metodo utiliza parametros
    @Modifying
    @Query(value="UPDATE TASK SET is_Completed=true WHERE id=:id", nativeQuery = true)
    public void setFastAsCompleted(@Param("id")Long id);
}
