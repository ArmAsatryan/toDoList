package com.example.todolist.repository;

import com.example.todolist.entity.ToDoItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<ToDoItemEntity, Long> {

}
