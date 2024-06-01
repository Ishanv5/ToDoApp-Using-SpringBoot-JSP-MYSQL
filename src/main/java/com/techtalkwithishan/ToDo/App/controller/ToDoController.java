package com.techtalkwithishan.ToDo.App.controller;


import com.techtalkwithishan.ToDo.App.model.ToDo;
import com.techtalkwithishan.ToDo.App.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@EnableAutoConfiguration
@ComponentScan()
public class ToDoController {

    @Autowired
    private ToDoService service;

    @GetMapping({"/","viewToDoList"})
    public String viewAllToDoItems(Model model, @ModelAttribute("message") String message){
        model.addAttribute("list",service.getAllToDoList());
        model.addAttribute("message",message);
        return "ViewToDoList";

    }
    @PostMapping("/updateToDoStatus/{id}")
    public String updateToDoStatus(@PathVariable long id, RedirectAttributes redirectAttributes){
        if(service.updateStatus(id)){
            redirectAttributes.addFlashAttribute("message","Status Updated Successfully");
            return "redirect:/viewToDoList";
        }
        redirectAttributes.addFlashAttribute("message","Status Update Failed");
        return "";

    }

    @GetMapping("/addToDoItem")
    public String addToDoItems(Model model){
      model.addAttribute("todo",new ToDo());
        return "AddToDoItem";
    }

    @PostMapping("/saveToDoItem")
    public String saveToDoItems(ToDo toDo, RedirectAttributes redirectAttributes){
        if(service.addOrUpdateToDo(toDo)){
            redirectAttributes.addFlashAttribute("message","To Do Item Added Successfully");
            return "redirect:/viewToDoList";
        }
        redirectAttributes.addFlashAttribute("message","To Do Item Add Failed");
        return "redirect:/addToDoItem";

    }

    @GetMapping("/editToDoItem/{id}")
    public String editToDoItems(@PathVariable Long id,Model model){
      model.addAttribute("todo",service.getToDoById(id));
        return "EditToDoItem";
    }

    @PostMapping("/editSaveToDoItem")
    public String editSaveToDoItems(ToDo toDo, RedirectAttributes redirectAttributes){
        if(service.addOrUpdateToDo(toDo)){
            redirectAttributes.addFlashAttribute("message","To Do Item Edited Successfully");
            return "redirect:/viewToDoList";
        }
        redirectAttributes.addFlashAttribute("message","To Do Item Edited Failed");
        return "redirect:/editToDoItem/" + toDo.getId();
    }

    @GetMapping("/deleteToDoItem/{id}")
    public String deleteToDoItems(@PathVariable Long id, RedirectAttributes redirectAttributes){
        if(service.deleteToDo(id)){
            redirectAttributes.addFlashAttribute("message","To Do Item Deleted Successfully");
          //  return "redirect:/viewToDoList";
        }
        redirectAttributes.addFlashAttribute("message","To Do Item Delete Failed");
        return "redirect:/viewToDoList";

    }
}
