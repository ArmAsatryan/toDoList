package com.example.todolist.service;

import com.example.todolist.dto.ToDoItemDTO;
import com.example.todolist.dto.ToDoItemEditDTO;
import com.example.todolist.entity.ToDoItemEntity;
import com.example.todolist.model.ToDoItemEditModel;
import com.example.todolist.model.ToDoItemModel;
import com.example.todolist.repository.ToDoRepository;
import com.example.todolist.util.ToDoItemMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepository repository;
    private final ToDoItemMapper mapper = new ToDoItemMapper();

    public ToDoService(ToDoRepository repository) {
        this.repository = repository;
    }

    public ToDoItemDTO createTodoItem(ToDoItemModel toDoItemModel) {
        ToDoItemDTO toDoItemDTO = mapper.modelToDto(toDoItemModel);
        ToDoItemEntity toDoItemEntity = mapper.dtoToEntity(toDoItemDTO);
        repository.save(toDoItemEntity);
        return toDoItemDTO;
    }


    public ToDoItemEditDTO edit(ToDoItemEditModel toDoItemEditModel) {
        ToDoItemEditDTO toDoItemEditDTO = mapper.editModelToEditDto(toDoItemEditModel);
        ToDoItemEntity entity = repository.findById(toDoItemEditModel.getId()).orElseThrow(() -> new EntityNotFoundException("item  not found"));
        entity.setCompleted(toDoItemEditDTO.isCompleted());
        entity.setTitle(toDoItemEditDTO.getTitle());
        repository.save(entity);
        return toDoItemEditDTO;
    }

    public void delete(Long id){
        ToDoItemEntity toDoItemEntity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("item  not found"));
        repository.delete(toDoItemEntity);
    }

    public List<ToDoItemDTO> getAllTodoItems() {
        List<ToDoItemEntity> itemEntities = repository.findAll();
        return itemEntities.stream().map(mapper::entityToDto).toList();
    }

    public ToDoItemDTO getById(Long id) {
        ToDoItemEntity toDoItemEntity = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("item  not found"));
        return mapper.entityToDto(toDoItemEntity);
    }

}
