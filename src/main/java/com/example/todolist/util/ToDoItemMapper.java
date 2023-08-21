package com.example.todolist.util;

import com.example.todolist.dto.ToDoItemDTO;
import com.example.todolist.entity.ToDoItemEntity;
import com.example.todolist.model.ToDoItemModel;

public class ToDoItemMapper {

    public ToDoItemDTO modelToDto (ToDoItemModel toDoItemModel){
        ToDoItemDTO toDoItemDTO =new ToDoItemDTO();
        toDoItemDTO.setTitle(toDoItemModel.getTitle());
        toDoItemDTO.setCompleted(toDoItemModel.isCompleted());
        return toDoItemDTO;
    }

    public ToDoItemModel dtoToModel (ToDoItemDTO toDoItemDTO){
        ToDoItemModel toDoItemModel =new ToDoItemModel();
        toDoItemModel.setTitle(toDoItemDTO.getTitle());
        toDoItemModel.setCompleted(toDoItemDTO.isCompleted());
        return toDoItemModel;
    }

    public ToDoItemEntity dtoToEntity (ToDoItemDTO toDoItemDTO){
        ToDoItemEntity toDoItemEntity =new ToDoItemEntity();
        toDoItemEntity.setTitle(toDoItemDTO.getTitle());
        toDoItemEntity.setCompleted(toDoItemDTO.isCompleted());
        return toDoItemEntity;
    }

    public ToDoItemDTO entityToDto (ToDoItemEntity toDoItemEntity){
        ToDoItemDTO toDoItemDTO =new ToDoItemDTO();
        toDoItemDTO.setCompleted(toDoItemEntity.isCompleted());
        toDoItemDTO.setTitle(toDoItemEntity.getTitle());
        return toDoItemDTO;
    }
}
