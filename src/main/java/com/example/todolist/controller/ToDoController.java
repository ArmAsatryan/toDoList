package com.example.todolist.controller;

import com.example.todolist.model.ToDoItemEditModel;
import com.example.todolist.model.ToDoItemModel;
import com.example.todolist.service.ToDoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class ToDoController {
    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping("/create")
    public String createTodoItem(ToDoItemModel todoItem) {
        toDoService.createTodoItem(todoItem);
        return "redirect:/todo-list";
    }

    @PutMapping("/edit")
    public String editTodoItem(ToDoItemEditModel todoItemEdit) {
        toDoService.edit(todoItemEdit);
        return "redirect:/todo-list";
    }

    @DeleteMapping("/{id}}")
    public String createTodoItem(@PathVariable Long id) {
        toDoService.delete(id);
        return "redirect:/todo-list";
    }

    @GetMapping("/items")
    public String getAll() {
        toDoService.getAllTodoItems();
        return "redirect:/todo-list";
    }

    @GetMapping("/item/{id}")
    public String getById(@PathVariable Long id) {
        toDoService.getById(id);
        return "redirect:/todo-list";
    }
}
