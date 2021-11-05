package ru.mals.springboot.tasklist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mals.springboot.tasklist.annotation.Loggable;
import ru.mals.springboot.tasklist.service.TaskService;

@Controller
@RequestMapping("/")
public class RedirectController {

    private final TaskService taskService;

    public RedirectController (TaskService taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @Loggable
    @RequestMapping(value="showAll", method = RequestMethod.GET)
    public String showAll(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "showAll";
    }

    @GetMapping("tasks/{id}")
    public String show(@PathVariable("id") long taskId, Model model) {
        model.addAttribute("task", taskService.getTask(taskId));
        return "show";
    }

}
