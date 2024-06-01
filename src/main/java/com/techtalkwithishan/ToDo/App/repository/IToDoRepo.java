package com.techtalkwithishan.ToDo.App.repository;

import com.techtalkwithishan.ToDo.App.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IToDoRepo extends JpaRepository<ToDo, Long>{


}
