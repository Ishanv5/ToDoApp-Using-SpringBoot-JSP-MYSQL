package com.techtalkwithishan.ToDo.App.service;

import com.techtalkwithishan.ToDo.App.model.ToDo;
import com.techtalkwithishan.ToDo.App.repository.IToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {


    @Autowired
    IToDoRepo toDoRepo;

    public List<ToDo> getAllToDoList() {
        ArrayList<ToDo> toDoList = new ArrayList<ToDo>();
        toDoRepo.findAll().forEach(toDo -> toDoList.add(toDo));
        return toDoList;
    }

    public ToDo getToDoById(long id) {
        return toDoRepo.findById(id).get();
    }

    public boolean updateStatus(Long id) {
        ToDo toDo = toDoRepo.findById(id).get();
        toDo.setStatus("Completed");
        return addOrUpdateToDo(toDo);

    }

    public boolean deleteToDo(Long id) {
        toDoRepo.deleteById(id);
        if(getToDoById(id)== null){
            return true;
        }
        return false;
    }

    public boolean addOrUpdateToDo(ToDo toDo) {
       ToDo newToDo=  toDoRepo.save(toDo);
       if(getToDoById(newToDo.getId())!= null){
              return true;
       }
       return false;

    }




}


